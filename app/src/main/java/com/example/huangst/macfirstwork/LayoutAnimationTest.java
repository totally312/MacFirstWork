package com.example.huangst.macfirstwork;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LayoutAnimationTest extends AppCompatActivity {
    LayoutTransition mTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation_test);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutanimation);
        Button add = (Button) findViewById(R.id.addbutton);


        mTransition = new LayoutTransition();
        Animator animator = AnimatorInflater.loadAnimator(LayoutAnimationTest.this,R.animator.animatorset);
        Animator animator1 = AnimatorInflater.loadAnimator(LayoutAnimationTest.this,R.animator.demo1);
//        Animator animator = ObjectAnimator.ofFloat(this, "rotationX", 0, 360);
//        lt.setAnimator(LayoutTransition.APPEARING, animator);
//        lt.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,animator1);
//        lt.setAnimator(LayoutTransition.CHANGE_APPEARING,animator1);
//        lt.setAnimator(LayoutTransition.DISAPPEARING,animator1);

        linearLayout.setLayoutTransition(mTransition);
        setupCustomAnimations();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT,-1);
                Button button = new Button(LayoutAnimationTest.this);
                button.setText("remove me");
                button.setPivotY(200);
                button.setPivotX(200);
                linearLayout.addView(button,1);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        linearLayout.removeView(v);
                    }
                });
            }
        });
    }


    private void setupCustomAnimations() {
        // 动画：CHANGE_APPEARING
        // Changing while Adding
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0,
                1);
        PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom",
                0, 1);
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("scaleX",
                1f, 0.5f, 1f);
        PropertyValuesHolder pvhScaleY = PropertyValuesHolder.ofFloat("scaleY",
                1f, 0.5f, 1f);

        final ObjectAnimator changeIn = ObjectAnimator.ofPropertyValuesHolder(
                this, pvhLeft, pvhTop, pvhRight, pvhBottom, pvhScaleX,
                pvhScaleY).setDuration(
                mTransition.getDuration(LayoutTransition.CHANGE_APPEARING)
        );
        mTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, changeIn);
        changeIn.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                // View也支持此种动画执行方式了
                view.setScaleX(1f);
                view.setScaleY(1f);
            }
        });

        // 动画：CHANGE_DISAPPEARING
        // Changing while Removing
        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
        Keyframe kf1 = Keyframe.ofFloat(.9999f, 360f);
        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe(
                "rotation", kf0, kf1, kf2);
        final ObjectAnimator changeOut = ObjectAnimator
                .ofPropertyValuesHolder(this, pvhLeft, pvhTop, pvhRight,
                        pvhBottom, pvhRotation)
                .setDuration(
                        mTransition
                                .getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        mTransition
                .setAnimator(LayoutTransition.CHANGE_DISAPPEARING, changeOut);
        changeOut.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotation(0f);
            }
        });

        // 动画：APPEARING
        // Adding
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "rotationY", 90f,
                0f).setDuration(
                mTransition.getDuration(LayoutTransition.APPEARING));
        mTransition.setAnimator(LayoutTransition.APPEARING, animIn);
        animIn.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotationY(0f);
            }
        });

        // 动画：DISAPPEARING
        // Removing
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotationX", 0f,
                90f).setDuration(
                mTransition.getDuration(LayoutTransition.DISAPPEARING));
        mTransition.setAnimator(LayoutTransition.DISAPPEARING, animOut);
        animOut.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator anim) {
                View view = (View) ((ObjectAnimator) anim).getTarget();
                view.setRotationX(0f);
            }
        });

    }


}
