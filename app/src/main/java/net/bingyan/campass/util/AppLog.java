package net.bingyan.campass.util;

import android.util.Log;

/**
 * Created by ant on 14-8-9.
 */
public class AppLog {
    String TAG = "hustpass";
    String className;
    public AppLog(Class<?> clazz) {
        className = '[' + clazz.getSimpleName() + ']';
    }

    public void v(String msg) {
        if (msg != null) {
            Log.v(TAG, className + msg);
        } else {
            Log.v(TAG, msg);
        }
    }
}