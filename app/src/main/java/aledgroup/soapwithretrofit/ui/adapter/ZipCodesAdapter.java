package aledgroup.soapwithretrofit.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import aledgroup.soapwithretrofit.R;
import aledgroup.soapwithretrofit.ui.model.ZipCodeData;

/**
 * Created by aled on 10/23/2016.
 */

public class ZipCodesAdapter extends RecyclerView.Adapter<ZipCodesAdapter.ZipCodesViewHolder> {

    private List<ZipCodeData> zipCodeDataList;
    private int rowLayout;
    private Context context;

    public ZipCodesAdapter(List<ZipCodeData> zipCodeDataList, int rowLayout, Context context) {
        this.zipCodeDataList = zipCodeDataList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return zipCodeDataList.size();
    }

    @Override
    public ZipCodesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.list_item_zip_code, null);
        return new ZipCodesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ZipCodesViewHolder holder, int position) {
        holder.bind(zipCodeDataList.get(position));
    }

    public static class ZipCodesViewHolder extends RecyclerView.ViewHolder{

        TextView tvCityState;
        TextView tvCityName;
        TextView tvCityZip;
        TextView tvCityAreaCode;

        public View root;

        public ZipCodesViewHolder(View itemView) {
            super(itemView);

            root = itemView.findViewById(R.id.rootListItemZipCode);

            tvCityState = (TextView) itemView.findViewById(R.id.tvCityState);
            tvCityName = (TextView) itemView.findViewById(R.id.tvCityName);
            tvCityZip = (TextView) itemView.findViewById(R.id.tvCityZip);
            tvCityAreaCode = (TextView) itemView.findViewById(R.id.tvCityAreaCode);
        }

        public void bind(ZipCodeData data){

            tvCityState.setText(itemView.getContext().getString(R.string.item_state, data.getState()));
            tvCityName.setText(data.getCity());
            tvCityZip.setText(itemView.getContext().getString(R.string.item_zip, data.getZipCode()));
            tvCityAreaCode.setText(itemView.getContext().getString(R.string.item_area, data.getAreaCode()));
        }
    }
}
