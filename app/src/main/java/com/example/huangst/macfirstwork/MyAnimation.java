package com.example.huangst.macfirstwork;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by huangst on 15/10/28.
 */
public class MyAnimation extends Animation {
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        super.applyTransformation(interpolatedTime, t);

        t.getMatrix().setTranslate((float)Math.sin(interpolatedTime*50)*50,(float)Math.sin(interpolatedTime*50)*50);

//        t.getMatrix().setRotate(360,Animation.RELATIVE_TO_SELF,Animation.RELATIVE_TO_SELF);




    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }
}
