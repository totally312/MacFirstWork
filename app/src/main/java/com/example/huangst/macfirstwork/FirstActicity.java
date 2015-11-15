package com.example.huangst.macfirstwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActicity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_acticity);
        Log.d("FirstActivity", "Task id is" + getTaskId());
        Log.d("FirstActivity",this.toString());

        TextView tv = (TextView)findViewById(R.id.tv);
        tv.setText("Task id is" + getTaskId() + "     " + this.toString());

        Button gotofirstactivity = (Button) findViewById(R.id.gotofirstactivity);
        gotofirstactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActicity.this, FirstActicity.class);
                startActivity(intent);
            }
        });

        Button gotosecondactivity = (Button) findViewById(R.id.gotosecondactivity);
        gotosecondactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActicity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        Button gotothirdactivity = (Button) findViewById(R.id.gotothirdactivity);
        gotothirdactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActicity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("FirstActivity","onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_acticity, menu);
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
}
