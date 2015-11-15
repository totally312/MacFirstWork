package com.example.huangst.macfirstwork;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ServiceTest extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private MyService.Binder binder;
    private EditText et1;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        findViewById(R.id.bindservice).setOnClickListener(this);
        findViewById(R.id.unbindservice).setOnClickListener(this);
        findViewById(R.id.tongbushuju).setOnClickListener(this);
        et1 = (EditText) findViewById(R.id.et1);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);








    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_service_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bindservice:
                bindService(new Intent(this,MyService.class),this,BIND_AUTO_CREATE);
                break;
            case R.id.unbindservice:
                unbindService(this);
                break;
            case R.id.tongbushuju:

                    binder.setDate(et1.getText().toString());

                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", binder.getData1());
                message.setData(b);
                handler.sendMessage(message);

            default:
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        binder = (MyService.Binder)service;
        binder.getService().setCallback(new MyService.Callback() {
            @Override
            public void onDateChange(String data) {
                Message msg = new Message();
                Bundle b=new Bundle();
                b.putString("data1",data);
                msg.setData(b);
                handler2.sendMessage(msg);
            }
        });


    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }


    private android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv1.setText(msg.getData().getString("data"));


        }
    };

    private android.os.Handler handler2 = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv2.setText(msg.getData().getString("data1"));
        }
    };

}
