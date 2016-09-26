package com.zzh.blackmovie.common;

import android.app.Application;

import com.squareup.picasso.Picasso;
import com.umeng.socialize.PlatformConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;
import com.zzh.blackmovie.utils.SysState;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class AppContext extends Application {
    public static AppConfig appConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        // initLogin();
        SysState.initSystate(this);
        ToastUtil.ToastInit(this);
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(100000L, TimeUnit.MILLISECONDS)
                .readTimeout(100000L, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.loggingEnabled(true).build();

        appConfig = new AppConfig(this);

        DbConfig.InitDbConfig(this);
    }


}
