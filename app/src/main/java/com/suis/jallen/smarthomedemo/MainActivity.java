package com.suis.jallen.smarthomedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import com.google.gson.Gson;
import com.suis.jallen.smarthomedemo.Mode.SmsBean;
import com.suis.jallen.smarthomedemo.http.RetrofitManager;
import com.suis.jallen.smarthomedemo.http.SmartHomeApi;
import com.suis.jallen.smarthomedemo.utils.Utils;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
    }

    private void test(){
        SmsBean smsBean = new SmsBean();
        smsBean.setAppid("oc3tvAdJPmaVOKrLv0rjCC0dzub4bbnD");
        smsBean.setNonce(Utils.getNumSmallLetter(8));
        smsBean.setTs(System.currentTimeMillis());
        smsBean.setVersion(4);
        smsBean.setEmail("jallenchen@126.com");
        smsBean.setSendType(0);
        smsBean.setTo("+8615013995415");

        Gson gson=new Gson();
        String obj=gson.toJson(smsBean);
        Retrofit retrofit = new RetrofitManager().createRetrofit(SmartHomeApi.BASEURL);

        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),obj);

        SmartHomeApi smartHomeApi = retrofit.create(SmartHomeApi.class);
        smartHomeApi.Sms(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("MainActivity","onResponse");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("MainActivity","onFailure");
            }
        });



    }
}
