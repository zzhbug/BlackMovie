package com.zzh.blackmovie.http;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public interface BaseSerializator {
    <T> T transform(String response, Class<T> classOfT);
}
