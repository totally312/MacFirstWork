package com.example.huangst.macfirstwork;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by huangst on 15/10/18.
 */
public class App extends Application {
    private String textData = "fuck";
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        setTextData(textData);
        context=getApplicationContext();

        Log.d("application","application succeed");
    }


    /**
     *
     * @param textDate
     */

    public void setTextData(String textDate) {
        this.textData = textDate;
    }

    public String getTextData() {
        return textData;
    }

    public Context getContext() {
        return context;
    }
}
