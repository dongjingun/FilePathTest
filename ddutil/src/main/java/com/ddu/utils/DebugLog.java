package com.ddu.utils;

import android.util.Log;
import com.orhanobut.logger.Logger;

public class DebugLog {
    static String className;
    static String methodName;
    static int lineNumber;
    static boolean debug;

    private DebugLog() {
    }

    public static void setDebug(boolean debug) {
        debug = debug;
        if(debug) {
            Logger.init().hideThreadInfo();
        }

    }

    public static boolean isDebuggable() {
        return debug;
    }

    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        buffer.append(methodName);
        buffer.append(":");
        buffer.append(lineNumber);
        buffer.append("]");
        buffer.append(log);
        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {
        if(isDebuggable()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.e(className, createLog(message));
        }
    }

    public static void i(String message) {
        if(isDebuggable()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.i(className, createLog(message));
        }
    }

    public static void d(String message) {
        if(isDebuggable()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.d(className, createLog(message));
        }
    }

    public static void v(String message) {
        if(isDebuggable()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.v(className, createLog(message));
        }
    }

    public static void w(String message) {
        if(isDebuggable()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.w(className, createLog(message));
        }
    }

    public static void wtf(String message) {
        if(isDebuggable()) {
            getMethodNames((new Throwable()).getStackTrace());
            Log.wtf(className, createLog(message));
        }
    }

    public static void xml(String xml) {
        if(isDebuggable()) {
            Logger.xml(xml);
        }
    }

    public static void json(String json) {
        if(isDebuggable()) {
            Logger.json(json);
        }
    }
}