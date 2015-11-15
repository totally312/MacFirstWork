package com.example.huangst.macfirstwork;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;

public class MyViewTest extends AppCompatActivity {
    ObjectAnimator a,b,c;
     MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_test);
        myView= (MyView) findViewById(R.id.myview);
                myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animator oa = AnimatorInflater.loadAnimator(MyViewTest.this,R.animator.animatorset);
//                myView.setPivotX(Animation.RELATIVE_TO_PARENT);
//                myView.setPivotY(Animation.RELATIVE_TO_PARENT);
//                oa.setTarget(myView);
//                oa.start();



//                mykeyframe(myView);


                myView.setPivotX(200);
                myView.setPivotY(200);
                rotateyAnimRun(myView);

            }
        });
        
        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animator animator = AnimatorInflater.loadAnimator(MyViewTest.this,R.animator.animatorset);
                myView.setPivotX(200);
                myView.setPivotY(200);
//                animator.setTarget(myView);
//                animator.start();


                ObjectAnimator oa = (ObjectAnimator) AnimatorInflater
                        .loadAnimator(MyViewTest.this, R.animator.changebackgroundcolor);
                //用于动画计算的需要，如果开始和结束的值不是基本类型的时候，这个方法是需要的。
                oa.setEvaluator(new ArgbEvaluator());

                //设置动画的设置目标
                oa.setTarget(myView);

                oa.start();
//                变换背景颜色

//                mykeyframe(v);
            }

        });
    }
    
    




    public void rotateyAnimRun(final View view)


    {



        a = ObjectAnimator//
                .ofFloat(view, "rotationX", 0.0F, 360f)//
                .setDuration(1000);

        a.start();

//        a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                view.setRotationX((Float) animation.getAnimatedValue());
//
//            }
//        });

//        b = ObjectAnimator//
//                .ofFloat(view, "translationX", 0, 200)//
//                .setDuration(1000);
//        b.start();
////        b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
////            @Override
////            public void onAnimationUpdate(ValueAnimator animation) {
////                view.setRotationY((Float) animation.getAnimatedValue());
////            }
////        });
//
//        c = ObjectAnimator
//                .ofFloat(view,"scaleX",1.0f,0.5f)
//                .setDuration(1000);
//        c.start();
    }

    public void verticalRun(final View view)
    {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 400);
        animator.setTarget(view);
        animator.setDuration(1000).start();
//      animator.setInterpolator(value)
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float a = (Float) animation.getAnimatedValue();


                view.setTranslationY(a);
            }
        });
    }

    public void myRun(View view){
        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotationX", 0,180f,0);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX", 0,200,100,0);
        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("alpha",0f,1f,0f,1f);
        ObjectAnimator.ofPropertyValuesHolder(view, p1, p2, p3).setDuration(2000).start();
    }

    public void myrotateyAnimRun(final View view)
    {
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(view, "zhy", 1.0F,  0.5F)//
                .setDuration(500);//
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                view.setAlpha(cVal);
                view.setScaleX(cVal);
                view.setScaleY(cVal);

            }
        });

        ObjectAnimator anim2 = ObjectAnimator//
                .ofFloat(view, "zhy2", 300)//
                .setDuration(500);//
        anim2.start();
        anim2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (float) animation.getAnimatedValue();
                view.setTranslationX(cVal);
            }
        });
    }

    void mykeyframe(View view){
        Keyframe kf0 = Keyframe.ofFloat(0, 0);
        Keyframe kf1 = Keyframe.ofFloat(0.10f, 100);
        Keyframe kf2 = Keyframe.ofFloat(0.20f, -100);
        Keyframe kf3 = Keyframe.ofFloat(0.30f, 100);
        Keyframe kf4 = Keyframe.ofFloat(0.40f, -100);
        Keyframe kf5 = Keyframe.ofFloat(0.50f, 100);
        Keyframe kf6 = Keyframe.ofFloat(0.60f, -100);
        Keyframe kf7 = Keyframe.ofFloat(0.70f, 100);
        Keyframe kf8 = Keyframe.ofFloat(0.80f, -100);
        Keyframe kf9 = Keyframe.ofFloat(0.90f, 100);
        Keyframe kf10 = Keyframe.ofFloat(1f, 0);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("translationX", kf0, kf1, kf2, kf3, kf4,kf5,kf6,kf7,kf8,kf10);
        ObjectAnimator widthAnim = ObjectAnimator.ofPropertyValuesHolder(view, pvhRotation);
        widthAnim.setDuration(2000);
        widthAnim.start();
    }

    void run(){

    }
}
