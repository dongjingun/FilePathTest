package com.example.admin.filepathtest.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by admin on 2016/8/19.
 */
public class BRelativeLayout extends RelativeLayout {
    public String Tag=this.getClass().getSimpleName();
    onTouchLogLisenter lisenter;

    public void setOnLogLisenter(onTouchLogLisenter lisenter){
        this.lisenter=lisenter;
    }

    public BRelativeLayout(Context context) {
        super(context);
    }

    public BRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        lisenter.onLog(Tag+"开始事件分发");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        String s= (super.onInterceptTouchEvent(ev))? "已经":"已经";
        lisenter.onLog(Tag+s+"拦截");
        return super.onInterceptTouchEvent(ev);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String s=(super.onTouchEvent(event))? "响应Touch":"没有响应";
        lisenter.onLog(Tag+s+"Touch");
        return super.onTouchEvent(event);
    }

}
