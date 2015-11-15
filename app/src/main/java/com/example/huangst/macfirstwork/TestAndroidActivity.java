package com.example.huangst.macfirstwork;

/**
 * Created by huangst on 15/10/5.
 */
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class TestAndroidActivity extends Activity {
    /** Called when the activity is first created. */

    private Button button,add;
    private TextView text;
    private ListView listview;
    public MyAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlistview);
        listview = (ListView) findViewById(R.id.listview);
        add = (Button) findViewById(R.id.add);
        adapter = new MyAdapter(this);
        listview.setAdapter(adapter);

        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                adapter.arr.add("");
                adapter.notifyDataSetChanged();
            }
        });
    }


    private class MyAdapter extends BaseAdapter {

        private Context context;
        private LayoutInflater inflater;
        public ArrayList<String> arr;
        public MyAdapter(Context context) {
            super();
            this.context = context;
            inflater = LayoutInflater.from(context);
            arr = new ArrayList<String>();
            for(int i=0;i<3;i++){    //listview初始化3个子项
                arr.add("");
            }
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return arr.size();
        }
        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }
        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }
        @Override
        public View getView(final int position, View view, ViewGroup arg2) {
            // TODO Auto-generated method stub
            if(view == null){
                view = inflater.inflate(R.layout.mainlistviewitem, null);
            }
            final EditText edit = (EditText) view.findViewById(R.id.edit);
            edit.setText(arr.get(position));    //在重构adapter的时候不至于数据错乱
            Button del = (Button) view.findViewById(R.id.del);
            edit.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub
                    if(arr.size()>0){
                        arr.set(position, edit.getText().toString());
                    }
                }
            });
            del.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    //从集合中删除所删除项的EditText的内容
                    arr.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
            return view;
        }
    }
}
