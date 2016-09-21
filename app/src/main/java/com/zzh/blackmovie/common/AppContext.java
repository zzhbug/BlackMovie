package com.zzh.blackmovie.common;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        // initLogin();
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(100000L, TimeUnit.MILLISECONDS)
                .readTimeout(100000L, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }


}
