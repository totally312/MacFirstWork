package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by huangst on 15/11/11.
 */
public class SmsTest extends Activity {

    @Override
    protected void onPause() {
        super.onPause();
        getContentResolver().unregisterContentObserver(sms);

    }

    public static final int NUMBER = 1;

    SmsObserver sms;
    EditText codenumber;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smstest);

        sms = new SmsObserver(SmsTest.this,handler);
        Uri uri = Uri.parse("content://sms");
        getContentResolver().registerContentObserver(uri,true,sms);

        codenumber = (EditText) findViewById(R.id.number);




    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == NUMBER){
                String code = (String) msg.obj;
                codenumber.setText(code);

            }
        }
    };
}
