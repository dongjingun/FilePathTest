package com.example.admin.filepathtest.TestActivitys;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.admin.filepathtest.Base.BaseActivity;
import com.example.admin.filepathtest.R;

/**
 * Created by admin on 2016/8/22.
 */
public class ShowHidActivity extends BaseActivity {
    @BindView(R.id.firstLinear)
    LinearLayout firstLinear;
    @BindView(R.id.tv_hindden)
    TextView tvHindden;
    @BindView(R.id.hiddenView)
    LinearLayout hiddenView;

    float mDenity;
    int mHidHeight;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hint);

        mDenity=getResources().getDisplayMetrics().density;
        mHidHeight=(int)(mDenity*100+0.5);
    }
    @OnClick(R.id.firstLinear)
     public void showHiddenView(){
        if (hiddenView.getVisibility()== View.GONE){
            open(hiddenView);
        }else {
            close(hiddenView);
        }
    }
    private void  open(final  View view){
        view.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator=getAnimator(view,0,mHidHeight);
        valueAnimator.start();
    }
    private void close(final View view){
        int origHeigh=view.getHeight();
        ValueAnimator valueAnimator=getAnimator(view,origHeigh,0);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }
        });
        valueAnimator.start();
    }
    private ValueAnimator getAnimator(final View view ,int start,int end){
        ValueAnimator animator=ValueAnimator.ofInt(start,end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value= (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams params=view.getLayoutParams();
                params.height=value;
                view.setLayoutParams(params);
            }
        });
        return animator;
    }
}
