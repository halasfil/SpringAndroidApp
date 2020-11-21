package com.halasfilip.androidspringclient.retrofitUtils;

import com.halasfilip.androidspringclient.utils.DataResource;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface InterfaceAPIRetrofit {

    @POST("/information")
    Call<ResponseBody> sendDataToDB(@Body DataResource dataResource);

    @GET("/information")
    Call<List<DataResource>> getAllData();

}
