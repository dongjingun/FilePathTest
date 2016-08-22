package com.example.admin.filepathtest.TestActivitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.admin.filepathtest.Base.BaseActivity;
import com.example.admin.filepathtest.R;
import com.example.admin.filepathtest.widget.ARelativeLayout;
import com.example.admin.filepathtest.widget.BRelativeLayout;
import com.example.admin.filepathtest.widget.myView;
import com.example.admin.filepathtest.widget.onTouchLogLisenter;

/**
 * Created by admin on 2016/8/19.
 */
public class TouchActivity extends BaseActivity implements onTouchLogLisenter, View.OnClickListener {

    @BindView(R.id.btn)
    myView btn;
    @BindView(R.id.bRelative)
    BRelativeLayout bRelative;
    @BindView(R.id.aRelative)
    ARelativeLayout aRelative;
    @BindView(R.id.logText)
    TextView logText;
    @BindView(R.id.reset)
    Button reset;
    StringBuffer sb=new StringBuffer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        ButterKnife.bind(this);
        bRelative.setOnLogLisenter(this);
        aRelative.setOnLogLisenter(this);
        btn.setOnLogLisenter(this);
        reset.setOnClickListener(this);

    }

    @Override
    public String onLog(String log) {
        sb.append(log+"\n");
        logText.setText(sb);
        return "";
    }

    @Override
    public void onClick(View v) {
        //恢复
        sb.delete(0,sb.length());
        logText.setText("");
    }
}
