package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangst on 15/10/2.
 */
public class ListViewActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this,android.R.layout.simple_list_item_checked,getData());
        ListView listView = (ListView)findViewById(R.id.lv1);

        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);





    }
    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        data.add("啊");
        data.add("列");
        data.add("a");
        data.add("b");
        return data;


    }

}