package com.ddu.utils;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.WindowManager;
public class UIUtils {
    private static int measuredWidth = -1;
    private static int measuredHeight = -1;

    public UIUtils() {
    }

    public static int getWidth(Context c) {
        if(measuredWidth == -1) {
            WindowManager wm = (WindowManager)c.getSystemService(Context.WINDOW_SERVICE);
            if(VERSION.SDK_INT >= 13) {
                Point size = new Point();
                wm.getDefaultDisplay().getSize(size);
                measuredWidth = size.x;
            } else {
                measuredWidth = wm.getDefaultDisplay().getWidth();
            }
        }

        return measuredWidth;
    }

    public static int getHeight(Context c) {
        if(measuredHeight == -1) {
            WindowManager wm = (WindowManager)c.getSystemService(Context.WINDOW_SERVICE);
            if(VERSION.SDK_INT >= 13) {
                Point size = new Point();
                wm.getDefaultDisplay().getSize(size);
                measuredHeight = size.y;
            } else {
                measuredHeight = wm.getDefaultDisplay().getHeight();
            }
        }

        return measuredHeight;
    }

    public static int dpToPx(int dp) {
        return (int)((float)dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int px2sp(float px) {
        return (int)(px / Resources.getSystem().getDisplayMetrics().density + 0.5F);
    }

    public static int sp2px(float spValue) {
        float fontScale = Resources.getSystem().getDisplayMetrics().density;
        return (int)(spValue * fontScale);
    }

    public static int pxToDp(int dp) {
        return (int)((float)dp / Resources.getSystem().getDisplayMetrics().density);
    }
}