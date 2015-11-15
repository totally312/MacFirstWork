package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangst on 15/10/4.
 */
public class MyListViewActivity extends Activity{

    public static List<Fruit> fruitList = new ArrayList<Fruit>();
    private Button add;
    private EditText edit;

    protected void onCreate(Bundle savedStanceState){
        super.onCreate(savedStanceState);
        setContentView(R.layout.mylistview);

        initFruit();

        final FruitAdapter adapter = new FruitAdapter(MyListViewActivity.this,R.layout.mylistviewitem,fruitList);
        final ListView listView = (ListView)findViewById(R.id.mylistview);

        edit = (EditText)findViewById(R.id.mylistview_et1);



        add = (Button)findViewById(R.id.mylistview_bt1);


        listView.setAdapter(adapter);

//        Animation sa = new ScaleAnimation(0,1,0,1);
//        Animation aa = AnimationUtils.loadAnimation(MyListViewActivity.this,R.anim.aa);
        Animation sa = AnimationUtils.loadAnimation(MyListViewActivity.this,R.anim.sa);
        LayoutAnimationController lac = new LayoutAnimationController(sa);
        lac.setOrder(LayoutAnimationController.ORDER_REVERSE);
        lac.setDelay(0.5f);
        listView.setLayoutAnimation(lac);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fruit fruit = fruitList.get(position);
                Toast.makeText(MyListViewActivity.this,fruit.getname(),Toast.LENGTH_LONG).show();
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edit.getText().toString();

                if(str.equals("orange")) {
                    Fruit fruit = new Fruit(str, R.drawable.orange, str);
                    Log.d("MylistViewActivity","strrrrrrrrr-----"+str);
                fruitList.add(fruit);

                }
                adapter.notifyDataSetChanged();}

        });


    }

    public void initFruit(){
        Fruit apple = new Fruit("Apple",R.drawable.apple,"apple");
        fruitList.add(apple);
        Fruit banana = new Fruit("banana",R.drawable.banana,"banana");
        fruitList.add(banana);
    }
}
