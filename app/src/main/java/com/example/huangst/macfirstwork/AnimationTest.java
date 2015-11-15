package com.example.huangst.macfirstwork;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AnimationTest extends AppCompatActivity implements View.OnClickListener {

    AnimationDrawable ad ;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);

        LinearLayout view = (LinearLayout) findViewById(R.id.animationlinearlayout);
//        LayoutInflater inflater = LayoutInflater.from(AnimationTest.this);
//        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.activity_animation_test, null);
//        ScaleAnimation sa = new ScaleAnimation(0,1,0,1);
//        ScaleAnimation sa = (ScaleAnimation) AnimationUtils.loadAnimation(AnimationTest.this,R.anim.sa);
//        sa.setDuration(2000);
//        LayoutAnimationController lac=new LayoutAnimationController(sa);
//        lac.setDelay(0.3f);
//        lac.setOrder(LayoutAnimationController.ORDER_RANDOM);
//        view.setLayoutAnimation(lac);

        image = (ImageView) findViewById(R.id.animation_image);

        Button alpha = (Button) findViewById(R.id.alpha);
        Button rotate = (Button) findViewById(R.id.rotate);
        Button translate = (Button) findViewById(R.id.translate);
        Button scale = (Button) findViewById(R.id.scale);
        Button set = (Button) findViewById(R.id.set);
        Button myanimation = (Button) findViewById(R.id.myanimation);
        Button begin = (Button) findViewById(R.id.begin);
        Button stop = (Button) findViewById(R.id.stop);
        Button layoutanimation = (Button) findViewById(R.id.layoutanimation);
        alpha.setOnClickListener(this);
        rotate.setOnClickListener(this);
        translate.setOnClickListener(this);
        scale.setOnClickListener(this);
        set.setOnClickListener(this);
        myanimation.setOnClickListener(this);
        begin.setOnClickListener(this);
        stop.setOnClickListener(this);
        layoutanimation.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animation_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alpha:
//                AlphaAnimation aa = new AlphaAnimation(0,1);
//                aa.setDuration(1000);
//                v.startAnimation(aa);
                v.startAnimation(AnimationUtils.loadAnimation(AnimationTest.this, R.anim.aa));
                image.startAnimation(AnimationUtils.loadAnimation(AnimationTest.this,R.anim.aa));
                break;
            case R.id.rotate:
//                RotateAnimation ra = new RotateAnimation(0,100000, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                ra.setDuration(10000);
//                v.startAnimation(ra);
                v.startAnimation(AnimationUtils.loadAnimation(AnimationTest.this, R.anim.ra));
                image.startAnimation(AnimationUtils.loadAnimation(AnimationTest.this,R.anim.ra));
                break;
            case R.id.translate:
//                TranslateAnimation ta = new TranslateAnimation(100,200,100,200);
//                ta.setDuration(1000);
//                v.startAnimation(ta);
                v.startAnimation(AnimationUtils.loadAnimation(AnimationTest.this, R.anim.ta));
                break;
            case R.id.scale:
//                ScaleAnimation sa = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                sa.setDuration(1000);
//                v.startAnimation(sa);
                v.startAnimation(AnimationUtils.loadAnimation(AnimationTest.this,R.anim.sa));
                break;
            case R.id.set:
                AnimationSet set = new AnimationSet(true);
                set.setDuration(1000);

                AlphaAnimation aa= new AlphaAnimation(0,1);
                set.addAnimation(aa);

                RotateAnimation ra = new RotateAnimation(0,10000,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                set.addAnimation(ra);

                v.startAnimation(set);

//                Animation a = AnimationUtils.loadAnimation(AnimationTest.this,R.anim.set);
//                v.startAnimation(a);
                image.startAnimation(set);
                break;
            case R.id.myanimation:
                MyAnimation ma = new MyAnimation();
                ma.setDuration(2000);
                ma.setRepeatCount(0);
//                ma.setStartOffset(1000);
                ma.setFillAfter(true);
                ma.setInterpolator(new DecelerateInterpolator());
                v.startAnimation(ma);
                break;
            case R.id.begin:
                image.setImageResource(R.drawable.al);
                ad = (AnimationDrawable) image.getDrawable();
                ad.start();
                break;
            case R.id.stop:
                ad = (AnimationDrawable) image.getDrawable();
                ad.stop();
                break;
            case R.id.layoutanimation:
                startActivity(new Intent(AnimationTest.this,LayoutAnimationTest.class));
                break;
            default:

        }


    }
}
