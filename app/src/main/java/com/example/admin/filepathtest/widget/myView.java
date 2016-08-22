package com.example.admin.filepathtest.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by admin on 2016/8/18.
 */
public class myView extends Button {
    public String Tag=this.getClass().getSimpleName();
    onTouchLogLisenter lisenter;

    public myView(Context context) {
        super(context);
    }

    public myView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public myView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public myView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String s=(super.onTouchEvent(event))? "响应":"没有响应";
        lisenter.onLog(Tag+s+"Touch");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        lisenter.onLog(Tag+"开始事件分发");

        return super.dispatchTouchEvent(event);
    }
    public void setOnLogLisenter(onTouchLogLisenter lisenter){
        this.lisenter=lisenter;
    }
}
