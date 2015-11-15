package com.example.huangst.macfirstwork;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;

import static java.lang.Thread.sleep;

/**
 * Created by huangst on 15/10/27.
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.MyView);
        int color = a.getColor(R.styleable.MyView_myviewcolor,Color.BLUE);
        setBackgroundColor(color);

        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.MyView);
        int color = a.getColor(R.styleable.MyView_myviewcolor, Color.BLUE);
        setBackgroundColor(color);

        init();
    }

    private Paint p,pp;

    public void init(){
        p = new Paint();
        p.setColor(Color.RED);
        pp = new Paint();
        pp.setColor(Color.BLACK);
        pp.setStrokeWidth(10);
        pp.setTextSize(40);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);





//

        canvas.save();



//        canvas.scale((float) number, (float) number);
//        canvas.translate(i, i);

        canvas.drawCircle(200,200,150,p);
        canvas.drawText("12",180,85,pp);
        canvas.drawText("3",320,200,pp);
        canvas.drawText("6",190,345,pp);
        canvas.drawText("9",55,200,pp);
        canvas.rotate(i,200,200);
        canvas.drawLine(200, 200, 200, 85, pp);

//        canvas.rotate(ii, i * (1 + (float)number),ii * (1 + (float)number));

//        canvas.scale((float) number, (float) number);
//        canvas.translate(i, i);



        i=i+6;

        number=number+0.1;

        canvas.restore();

        canvas.save();

        canvas.rotate(ii,200,500);
        canvas.translate(100,100);
        canvas.drawRect(0, 300, 200, 500, p);
        canvas.restore();



        ii=ii+5;
        number=number+0.1;


        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0){
                    invalidate();
                }


            }
        };





        new Thread(new Runnable() {
            @Override
            public void run() {

                try {


                    sleep(1000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message msg = new Message();
                msg.what=0;


                handler.sendMessage(msg);
            }
        }).start();
    }



    private float i = 0;
    private float ii= 0;
    private double number=0;
}
