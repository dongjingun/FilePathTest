package com.example.admin.filepathtest.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by admin on 2016/8/22.
 */
public class DragViewGroup extends FrameLayout {
    private ViewDragHelper mViewDragHelper;
    private View mMenuView,mMainView;
    private int mWidth;
    public DragViewGroup(Context context) {
        super(context);
        initView();
    }

    public DragViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DragViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    public DragViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
    private void initView() {
        mViewDragHelper=ViewDragHelper.create(this, callback);
    }

    /**
     * 拦截事件
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    /**
     * 处理触摸事件
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    /**
     *  平滑滑动
     */
    @Override
    public void computeScroll() {
        if (mViewDragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /**
     * 布局加载完毕
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView=getChildAt(0);
        mMainView=getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=mMenuView.getMeasuredWidth();
    }
    private ViewDragHelper.Callback callback= new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            // 哪一个View是可以被拖动的
            return mMainView==child;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            if (dx>=0){
                return left;
            }
            if (dx<0){
                if (mMainView.getLeft()>0){
                    return left;
                }
                return 0;
            }
            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }
        /*
            拖动结束后调用。
         */
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if (mMainView.getLeft()<500){
                // 关闭菜单
                //相当于Scroller的startScroller 方法。
                mViewDragHelper.smoothSlideViewTo(mMainView,0,0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }else {
                //打开菜单
                mViewDragHelper.smoothSlideViewTo(mMainView,300,0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }
        }
    };
}
