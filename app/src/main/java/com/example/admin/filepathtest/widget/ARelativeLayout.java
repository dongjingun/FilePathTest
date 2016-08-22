package com.example.admin.filepathtest.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Debug;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.util.Log;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * Created by admin on 2016/8/19.
 */
public class ARelativeLayout extends RelativeLayout {
    public String Tag=this.getClass().getSimpleName();
    onTouchLogLisenter lisenter;
    public ARelativeLayout(Context context) {
        super(context);
    }

    public ARelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ARelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ARelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        lisenter.onLog(Tag+"开始事件分发");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        String s= (super.onInterceptTouchEvent(ev))? "已经":"没有";
        lisenter.onLog(Tag+s+"拦截");

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String s=(super.onTouchEvent(event))? "响应Touch":"没有响应";
        lisenter.onLog(Tag+s+"Touch");
        return super.onTouchEvent(event);
    }
    public void setOnLogLisenter(onTouchLogLisenter lisenter){
        this.lisenter=lisenter;
    }

}
