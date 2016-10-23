package aledgroup.soapwithretrofit.ui.views;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import aledgroup.soapwithretrofit.R;
import aledgroup.soapwithretrofit.api.ApiClient;
import aledgroup.soapwithretrofit.api.ApiInterface;
import aledgroup.soapwithretrofit.api.model.request.UsStatesRequestBody;
import aledgroup.soapwithretrofit.api.model.request.UsStatesRequestData;
import aledgroup.soapwithretrofit.api.model.request.UsStatesRequestEnvelope;
import aledgroup.soapwithretrofit.api.model.response.TableElement;
import aledgroup.soapwithretrofit.api.model.response.UsStatesResponseEnvelope;
import aledgroup.soapwithretrofit.ui.adapter.ZipCodesAdapter;
import aledgroup.soapwithretrofit.ui.model.ZipCodeData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etCityName;
    private ProgressDialog progressDialog;
    private RecyclerView rvElements;
    ZipCodesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCityName = (EditText) findViewById(R.id.etCityName);

        (findViewById(R.id.btMakeRequest)).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MakeSearch();
            }
        });
    }

    private void MakeSearch()
    {
        hideKeyboard();
        showWaitingDialog();

        UsStatesRequestEnvelope envelope = new UsStatesRequestEnvelope();
        UsStatesRequestBody body = new UsStatesRequestBody();

        UsStatesRequestData data = new UsStatesRequestData();

        data.setCity(etCityName.getText().toString());

        body.setUsStatesRequestData(data);
        envelope.setBody(body);

        ApiInterface apiService = ApiClient.getSOAPClient().create(ApiInterface.class);

        Call<UsStatesResponseEnvelope> call = apiService.requestStateInfo(envelope);

        call.enqueue(new Callback<UsStatesResponseEnvelope>() {

            @Override
            public void onResponse(Call<UsStatesResponseEnvelope> call, final Response<UsStatesResponseEnvelope> response) {

                hideWaitingDialog();

                final List<ZipCodeData> itemTerbaru = reverseMapList(response.body().getBody().getData().getData().getElements());

                adapter = new ZipCodesAdapter(itemTerbaru, R.layout.list_item_zip_code, getApplicationContext());
                rvElements = (RecyclerView) findViewById(R.id.rvElements);
                rvElements.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                rvElements.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<UsStatesResponseEnvelope> call, Throwable t) {

                //ERROR!!

            }

        });
    }

    public ZipCodeData reverseMap(TableElement element) {
        ZipCodeData codeData = new ZipCodeData();
        codeData.setCity(element.getCity());
        codeData.setState(element.getState());
        codeData.setAreaCode(element.getAreaCode());
        codeData.setTimeZone(element.getTimeZone());
        codeData.setZipCode(element.getZip());
        return codeData;
    }

    public List<ZipCodeData> reverseMapList(List<TableElement> list){

        List<ZipCodeData> returnedList = new ArrayList<>();

        for(TableElement element: list ){
            returnedList.add( reverseMap(element) );
        }

        return returnedList;

    }

    public void showWaitingDialog() {

        if (progressDialog == null) {
            progressDialog = new ProgressDialog( this );
            progressDialog.setIndeterminate( true );
            progressDialog.setProgressStyle( ProgressDialog.STYLE_SPINNER );
            progressDialog.setTitle( getString( R.string.dialog_title ) );
            progressDialog.setMessage( getString( R.string.dialog_message ) );
        }

        progressDialog.show();
    }

    public void hideWaitingDialog() {

        if (progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}
