package com.example.huangst.macfirstwork;

import android.content.Context;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by huangst on 15/11/11.
 */
public class SmsObserver extends ContentObserver {

    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */

    Context mContext;
    Handler mHandler;
    public SmsObserver(Context context,Handler handler) {
        super(handler);
        mContext = context;
        mHandler = handler;
    }



    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);

        Log.d("smsobserver","successful");
        Log.d("smsobserver",uri.toString());

        if(uri.toString().equals("content://sms/raw")){
            return;
        }

        Uri smsuri = Uri.parse("content://sms/inbox");
        Cursor cursor = mContext.getContentResolver().query(smsuri, null, null, null, "date desc");
        if(cursor != null){


            if(cursor.moveToFirst()){
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String content = cursor.getString(cursor.getColumnIndex("body"));

                Log.d("smsobserver1",address);
                Log.d("smsobserver1",content);

                Log.d("smsobserver1", "successful");

                Pattern pattern = Pattern.compile("(\\d{6})");
                Matcher matcher = pattern.matcher(content);

                if(matcher.find()) {
                    String code = matcher.group(0);
                    mHandler.obtainMessage(SmsTest.NUMBER,code ).sendToTarget();
                }

            }
            cursor.close();

        }else {
            Log.d("smsobserver1","fail");
        }
    }
}
