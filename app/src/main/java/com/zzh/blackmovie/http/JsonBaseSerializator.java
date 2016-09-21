package com.zzh.blackmovie.http;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class JsonBaseSerializator implements BaseSerializator {
    Gson mGson = new Gson();

    @Override
    public <T> T transform(String response, Class<T> classOfT) {
        return mGson.fromJson(response, classOfT);
    }
}
