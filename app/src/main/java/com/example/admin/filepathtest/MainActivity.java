package com.example.admin.filepathtest;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    LinearLayout rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView= (TextView) findViewById(R.id.textView);
        rootView= (LinearLayout) findViewById(R.id.rootView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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

}
