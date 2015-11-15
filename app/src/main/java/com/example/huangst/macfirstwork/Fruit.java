package com.example.huangst.macfirstwork;

import android.app.Application;

/**
 * Created by huangst on 15/10/4.
 */
public class Fruit extends Application {
    private String name;
    private int imageid;
    private String buttonname;
    public Fruit(String name,int imageid,String buttonname){
        this.name=name;
        this.imageid=imageid;
        this.buttonname=buttonname;
    }

    public String getname(){
        return name;
    }

    public int getImageid(){
        return imageid;
    }

    public String getButtonname(){
        return buttonname;
    }
}
