package com.ddu.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

public class VersionUtils {
    public VersionUtils() {
    }

    public static boolean isAPI20() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean isAPI14() {
        return VERSION.SDK_INT >= 14;
    }

    public static boolean isAPI16() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean isAPI19() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean isAPI10() {
        return VERSION.SDK_INT >= 10;
    }

    public static boolean isAPI13() {
        return VERSION.SDK_INT >= 13;
    }

    public PackageInfo getPackageInfo(Context context) {
        try {
            PackageManager e = context.getPackageManager();
            return e.getPackageInfo(context.getPackageName(), 0);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }
}