package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by huangst on 15/10/9.
 */
public class CreateDatabase extends Activity {

    private MydatabaseHelper dbHelper;

    protected void onCreate(Bundle savedInstanceStated){
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.createdatabase);

        dbHelper=new MydatabaseHelper(this,"BookStore.db",null,3);

        Button createDatabase = (Button)findViewById(R.id.createdatabase);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });

        Button querydata = (Button)findViewById(R.id.querydata);
        querydata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from Book",null);

                if(cursor.moveToFirst()){
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int id = cursor.getInt(cursor.getColumnIndex("id"));

                        Log.d("Book","Book id is "+id);
                        Log.d("Book","Book name is "+name);
                        Log.d("Book","Book author is "+author);
                    }while(cursor.moveToNext());

                }
                cursor = db.query("Category", null, null, null, null, null, null);
                if(cursor.moveToFirst()){
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("category_name"));
                        int code = cursor.getInt(cursor.getColumnIndex("category_code"));
                        int id = cursor.getInt(cursor.getColumnIndex("id"));

                        Log.d("Book","Book id is "+id);
                        Log.d("Book","Book category_name is "+name);
                        Log.d("Book","Book category_code is "+code);
                    }while(cursor.moveToNext());

                }

                cursor.close();

            }
        });

        Button adddata = (Button)findViewById(R.id.add);
        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","The Da Vinci cODE");
                values.put("author","Dan Brown");
                db.insert("Book", null, values);

                values.clear();
                values.put("category_name","fuck");
                values.put("category_code","111111");
                db.insert("Category", null, values);

                Log.d("Book", "creatsuccessful");
            }
        });

        Button deteledata = (Button)findViewById(R.id.delete);
        deteledata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book","name = ?",new String[]{"The Da Vinci cODE"});

            }
        });

    }
}
