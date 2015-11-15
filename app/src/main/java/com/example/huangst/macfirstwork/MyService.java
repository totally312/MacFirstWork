package com.example.huangst.macfirstwork;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private boolean running = false;
    private String data = "默认信息";
    String data1;
    Binder binder=new Binder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return binder;
    }

    public class Binder extends android.os.Binder{
        public void setDate(String data){
            MyService.this.data=data;
        }

        public String getData1(){
            return data1;
        }

        public MyService getService(){
           return MyService.this;

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        running=true;

        new Thread(){
            @Override
            public void run() {
                super.run();

                int n=0;

                while (running) {
                    n=n+1;
                    Log.d("MyService", data);
                    data1=n+data;
                    Log.d("MyService", data1);
                    Log.d("MyService", binder.getData1());

                    if(callback !=null){
                        callback.onDateChange(data1);
                    }




                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running=false;
    }

    public Callback callback;

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }


    public static interface Callback{
        void onDateChange(String data);
    }
}
