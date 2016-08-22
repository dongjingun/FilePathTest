package com.example.admin.filepathtest.Base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.admin.filepathtest.R;

public class BaseActivity extends AppCompatActivity {
    @Nullable Toolbar toolbar;
    private Unbinder unbinder;
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        unbinder=ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }
        setTitle(this.getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }
}
