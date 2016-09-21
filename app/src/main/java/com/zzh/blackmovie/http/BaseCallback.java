package com.zzh.blackmovie.http;

import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.ParameterizedType;

import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public abstract class BaseCallback<T> extends Callback<T> {
    private static final String TAG = "BaseCallback";
    BaseSerializator mBaseSerializator;

    public BaseCallback(BaseSerializator baseSerializator) {
        this.mBaseSerializator = baseSerializator;
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {

        String string = response.body().string();
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }
        T bean = mBaseSerializator.transform(string, entityClass);

        return bean;
    }

}
