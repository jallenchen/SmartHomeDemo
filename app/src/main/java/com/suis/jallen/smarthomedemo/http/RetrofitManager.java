package com.suis.jallen.smarthomedemo.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private  OkHttpClient providesOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new MyInterceptor())
                //set timeout
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                //set retry
                .retryOnConnectionFailure(true)
                .build();

        return okHttpClient;
    }

    public Retrofit createRetrofit(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(providesOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
