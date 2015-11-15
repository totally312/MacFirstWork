package com.example.huangst.macfirstwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MulTouchTest extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView xyz;
    ImageView iv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_touch_test);
        linearLayout = (LinearLayout) findViewById(R.id.continer);
        xyz = (TextView) findViewById(R.id.xyz);
        iv = (ImageView) findViewById(R.id.iv);

        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("touch","ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("touch", "ACTION_MOVE");

                        xyz.setText("X:" + event.getX() + "," + "Y:" + event.getY());
//                        iv.setPivotX(event.getX());
//                        iv.setPivotY(event.getY());
//                        iv.setScaleX(event.getX());
//                        iv.setScaleY(event.getY());

//                        iv.setTranslationX(event.getX());
//                        iv.setTranslationY(event.getY());

                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) iv.getLayoutParams();
                        lp.leftMargin = ((int) event.getX())-100;
                        lp.topMargin = ((int) event.getY())-100;

                        iv.setLayoutParams(lp);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("touch","ACTION_UP");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

}
