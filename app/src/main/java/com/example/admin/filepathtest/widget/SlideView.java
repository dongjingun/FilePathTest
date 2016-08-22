package com.example.admin.filepathtest.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by admin on 2016/8/22.
 */
public class SlideView extends View {
    private int lastX;
    private int lastY;
    private Scroller mScroller;
    public SlideView(Context context) {
        super(context);
        init();
    }

    public SlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SlideView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init(){
        mScroller=new Scroller(getContext());
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y= (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX=x;
                lastY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX=x-lastX;
                int offsetY=y-lastY;
//                -----------------------第一种----------------------

//                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);

//                -----------------------第二种----------------------

//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);

//                -----------------------第三种----------------------

//                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) getLayoutParams();
//                params.leftMargin=getLeft()+offsetX;
//                params.topMargin=getTop()+offsetY;
//                setLayoutParams(params);

//               -----------------------第五种---------------ContentView的滑动---注意方向为负！！----

                ((View)getParent()).scrollBy(-offsetX,-offsetY);


                break;
            case MotionEvent.ACTION_UP:
                //                ----------------------第六种，Scroller 平滑移动-----------------------------

                ViewGroup group= (ViewGroup) getParent();
                mScroller.startScroll(group.getScrollX(),group.getScrollY(),-group.getScrollX(),-group.getScrollY());
                invalidate();
                break;
        }

        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }
}
