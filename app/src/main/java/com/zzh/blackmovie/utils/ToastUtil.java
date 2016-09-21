package com.zzh.blackmovie.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/11 0011.
 * 全局一个Toast
 */
public class ToastUtil {

    private static Toast toast;

    public  static void ToastInit(Context context) {
        toast = Toast.makeText(context, "", Toast.LENGTH_LONG);
    }


    public static void makeText(String text) {
        toast.setText(text);
        toast.show();

    }


}
