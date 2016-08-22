package com.example.admin.filepathtest.TestActivitys;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.admin.filepathtest.R;

public class PathActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    LinearLayout rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView= (TextView) findViewById(R.id.textView);
        rootView= (LinearLayout) findViewById(R.id.rootView);

        initView();
    }
    private void initView() {
        for (int i=0;i<rootView.getChildCount();i++){
                View linear=rootView.getChildAt(i);
            if (linear instanceof LinearLayout){
                for (int j=0;j<((LinearLayout)linear).getChildCount();j++){
                    View btn= ((LinearLayout) linear).getChildAt(j);
                    if (btn instanceof Button){
                        btn.setOnClickListener(this);
                        Log.e("TAG:",btn.getTag().toString());

                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        int tag=Integer.valueOf(v.getTag().toString());
        String path="";
        textView.setText(path);
        //asdasdasdasd
        switch (tag){
            case 1:
                path=Environment.getExternalStorageDirectory().getAbsolutePath();
                break;
            case 2:
                path=Environment.getExternalStoragePublicDirectory("").getAbsolutePath();
                break;
            case 3:
                path=Environment.getDownloadCacheDirectory().getAbsolutePath();
                break;
            case 4:
                path=Environment.getRootDirectory().getAbsolutePath();
                break;
            case 5:
                path=Environment.getDataDirectory().getAbsolutePath();
                break;
            case 6:
                path=Environment.getExternalStoragePublicDirectory("files").getAbsolutePath();
                break;
            case 7:
                path=this.getFilesDir().getAbsolutePath();
                break;
            case 8:
                path=this.getExternalFilesDir("").getAbsolutePath();
                break;
            case 9:
                path=getCacheDir().getAbsolutePath();
                break;
            case 10:
                path=Environment.getExternalStoragePublicDirectory("cache").getAbsolutePath();
                break;
            case 11:
                path=getExternalCacheDir().getAbsolutePath();
                break;

        }
        textView.setText(path);
    }
    public void showText(String str){
        SpannableString spannableString=new SpannableString(str);

    }
}
