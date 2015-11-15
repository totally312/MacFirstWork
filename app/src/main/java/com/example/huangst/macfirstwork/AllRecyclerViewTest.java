package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by huangst on 15/10/22.
 */
public class AllRecyclerViewTest extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allrecyclerviewtest);

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllRecyclerViewTest.this, RecyclerViewTest.class));
            }
        });

        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllRecyclerViewTest.this,AnotherRecyclerViewTest.class));
            }
        });
    }
}
