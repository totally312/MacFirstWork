package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

/**
 * Created by huangst on 15/10/20.
 */
public class RecyclerViewTest extends Activity {


    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = new RecyclerView(this);

        setContentView(recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        Animation sa = AnimationUtils.loadAnimation(RecyclerViewTest.this,R.anim.sa);
        LayoutAnimationController lac = new LayoutAnimationController(sa,0.5f);
        recyclerView.setLayoutAnimation(lac);




        Fruit apple = new Fruit("Apple",R.drawable.apple,"apple");

        Fruit banana = new Fruit("banana",R.drawable.banana,"banana");

        Fruit[] f = new Fruit[] {apple,banana};

        recyclerView.setAdapter(new MyAdapter(f));

        recyclerView.setItemAnimator(new DefaultItemAnimator());



    }

}
