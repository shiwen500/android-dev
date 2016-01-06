package com.github.shiwen500.library.NetWork;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by sunyun004_macmini on 16/1/6.
 */
public class NetWorkStatus {

    public static boolean isNetworkAvailable(Context context) {

        return isMobileNetworkAvailable(context) || isWifiNetworkAvailable(context);
    }

    public static boolean isMobileNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }

        NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return mobile.isAvailable();
    }

    public static boolean isWifiNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }

        NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return mobile.isAvailable();
    }
}
