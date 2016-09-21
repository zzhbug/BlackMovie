package com.zzh.blackmovie.utils;

/**
 * Created by Administrator on 2016/9/21 0021.
 */

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/9/10 0010.
 */
public class SysState {

    private static Context mContext;

    public static void initSystate(Context context) {
        mContext = context;
    }


    //是否有网络
    public static boolean isConnected() {
        ConnectivityManager conn = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }

    //获取手机唯一标识
    public static String getImei( String imei) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
        } catch (Exception e) {
            Log.e(SysState.class.getSimpleName(), e.getMessage());
        }
        return imei;
    }


    // 取得版本号
    public static String GetVersion() {
        try {
            PackageInfo manager = mContext.getPackageManager().getPackageInfo(
                    mContext.getPackageName(), 0);
            return manager.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Unknown";
        }
    }

    public static int[] getSystemWidthAndHeight() {
        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        int widthPixels = outMetrics.widthPixels;
        int heightPixels = outMetrics.heightPixels;
        int[] ints = new int[2];
        ints[0] = widthPixels+4;
        ints[1] = heightPixels+4;
        return ints;
    }


}
