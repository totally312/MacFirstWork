package com.example.huangst.macfirstwork;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by huangst on 15/10/9.
 */
public class MydatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK ="create table Book("
    +"id integer primary key autoincrement,"
    +"author text,"
    +"price real,"
    +"pages integer,"
    +"name text)";

    public static final String CREATE_CATEGORY ="create table Category("
            +"id integer primary key autoincrement,"
            +"category_name text,"
            +"category_code integer)";

    public static final String CREATE_CATEGORYY ="create table Category2("
            +"id integer primary key autoincrement,"
            +"category_name text,"
            +"category_code integer)";

    private Context mContext;
    public MydatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
        mContext = context;
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        db.execSQL(CREATE_CATEGORYY);

    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        switch (oldVersion){
            case 2:
                db.execSQL(CREATE_CATEGORYY);
                Log.d("Book", "createCategory2 and oldVersion is " + oldVersion);
                Log.d("Book", "newVersion is "+newVersion);
                default:
        }
    }
}
