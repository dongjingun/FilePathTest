package com.example.admin.filepathtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.BindView;
import com.example.admin.filepathtest.Base.BaseActivity;
import com.example.admin.filepathtest.Base.FirstItems;

/**
 * Created by admin on 2016/8/19.
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,R.layout.item_list, FirstItems.getItems());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,FirstItems.getClassByPosition(position));

        startActivity(intent);
    }
}
