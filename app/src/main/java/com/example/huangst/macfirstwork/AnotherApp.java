package com.example.huangst.macfirstwork;

import android.app.Application;
import android.content.Context;

/**
 * Created by huangst on 15/11/12.
 */
public class AnotherApp extends Application {

private String text = "love";
    private Context context;
    public void onCreate() {
        super.onCreate();
        setText(text);
        context = getApplicationContext();
    }

    public Context getContext() {
        return context;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
