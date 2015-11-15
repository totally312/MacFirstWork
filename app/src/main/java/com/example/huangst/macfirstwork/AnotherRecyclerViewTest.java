package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangst on 15/10/22.
 */
public class AnotherRecyclerViewTest extends Activity {


    private AnotherAdapter adapter;
    RecyclerView recyclerView;
    List<String> mDatas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anotherrecyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        initData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AnotherAdapter(mDatas);
        recyclerView.setAdapter(adapter);

    }

    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }
}
