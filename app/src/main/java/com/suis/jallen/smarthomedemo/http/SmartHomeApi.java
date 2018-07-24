package com.suis.jallen.smarthomedemo.http;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SmartHomeApi {
    public static final String BASEURL = "https://cn-api.coolkit.cc:8080/api/";

    @POST("sms")
    Call<ResponseBody> Sms(@Body RequestBody info);

    @POST("user/login")
    Call<ResponseBody> Login(@Body RequestBody info);

    @POST("user/register")
    Call<ResponseBody> Register(@Body RequestBody info);

    @GET("user/refresh")
    Call<ResponseBody> refresh(@Body RequestBody info);


}
