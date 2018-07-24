package com.suis.jallen.smarthomedemo.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MyInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request.newBuilder()
                .addHeader("Content-Type","application/json")
                .addHeader("Charset","utf-8")
                .addHeader("Authorization","V0LmoW0cd2cg38i1eIM0P5Z29GjES4PA")
                .build();
        return chain.proceed(request);
    }
}
