package net.bingyan.campass.util;

import android.text.TextUtils;
import android.util.Log;

import net.bingyan.campass.BuildConfig;

/**
 * Created by ant on 14-8-9.
 */
public class AppLog {
    //调试模式输出log，发布版本不输出
    public static boolean debug = BuildConfig.DEBUG;
    private static String mTag;

    //log长度有限制
    public static final int MaxLength = 4000;

    public static final int Debug = 1;
    public static final int Verbose = 2;
    public static final int Info = 3;
    public static final int Warn = 4;
    public static final int Error = 5;

    public <T> AppLog(Class<T> class1) {
        mTag = class1.getCanonicalName();
    }

    public static void v(String msg) {
        if (!debug || TextUtils.isEmpty(msg))
            return;
        logMessage(msg, Verbose);
    }

    public static void d(String msg) {
        if (!debug || TextUtils.isEmpty(msg))
            return;
        logMessage(msg, Debug);
    }

    public static void i(String msg) {
        if (!debug || TextUtils.isEmpty(msg))
            return;
        logMessage(msg, Info);
    }

    public static void w(String msg) {
        if (!debug || TextUtils.isEmpty(msg))
            return;
        logMessage(msg, Warn);
    }

    public static void e(String msg) {
        if (!debug || TextUtils.isEmpty(msg))
            return;
        logMessage(msg, Error);
    }

    public static void e(Throwable t) {
        if (!debug || TextUtils.isEmpty(t.getMessage())) {
            return;
        }
        Log.e(mTag, getLogMsg(t.getMessage()));
    }

    public static void e(String msg, Throwable t) {
        if (!debug || TextUtils.isEmpty(msg)) {
            return;
        }
        Log.e(mTag, getLogMsg(msg), t);
    }

    private static void logMessage(String msg, int method) {
        for (int i = 0; i <= msg.length() / MaxLength; i++) {
            int start = i * MaxLength;
            int end = (i + 1) * MaxLength;
            end = end > msg.length() ? msg.length() : end;
            switch (method) {
                case Verbose:
                    Log.v(mTag,msg.substring(start,end));
                    break;
                case Warn:
                    Log.w(mTag, msg.substring(start, end));
                    break;
                case Debug:
                    Log.d(mTag, msg.substring(start, end));
                    break;
                case Info:
                    Log.i(mTag, msg.substring(start, end));
                    break;
                case Error:
                    Log.e(mTag, msg.substring(start, end));
                    break;
                default:
                    break;
            }
        }
    }

    private static String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }

        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            //排除掉AppLog输出
            if (st.getClassName().equals(AppLog.class.getName())) {
                continue;
            }

            return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId()
                    + "): " + st.getFileName() + ":" + st.getMethodName() + ":" + st.getLineNumber() + "]";
        }

        return null;
    }

    private static String getLogMsg(String msg) {
        String functionName = getFunctionName();
        String message = (functionName == null ? msg : (functionName + " - " + msg));
        return message;
    }
}