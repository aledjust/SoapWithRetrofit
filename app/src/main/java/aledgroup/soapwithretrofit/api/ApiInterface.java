package aledgroup.soapwithretrofit.api;

import aledgroup.soapwithretrofit.api.model.request.UsStatesRequestEnvelope;
import aledgroup.soapwithretrofit.api.model.response.UsStatesResponseEnvelope;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by aled on 10/23/2016.
 */

public interface ApiInterface {

    @Headers({"Content-Type: text/xml","Accept-Charset: utf-8"})
    @POST("/uszip.asmx")
    Call<UsStatesResponseEnvelope> requestStateInfo(@Body UsStatesRequestEnvelope body);
}
