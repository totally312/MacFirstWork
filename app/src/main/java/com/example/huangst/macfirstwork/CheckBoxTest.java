package com.example.huangst.macfirstwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CheckBoxTest extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    Button bt;
    TextView tv;
    CheckBox cb1,cb2,cb3,cb4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_test);

        tv= (TextView) findViewById(R.id.chosen);

        cb1 = (CheckBox) findViewById(R.id.cba);
        cb2 = (CheckBox) findViewById(R.id.cbb);
        cb3 = (CheckBox) findViewById(R.id.cbc);
        cb4 = (CheckBox) findViewById(R.id.cbd);

        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);

        bt = (Button) findViewById(R.id.submit);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "you choose:" ;
                if(cb1.isChecked()){
                    String str1 = "A,"+",";
                    str=str+cb1.getText()+",";
                }
                if(cb2.isChecked()){
                    String str2 = "B,";
                    str=str+cb2.getText()+",";
                }
                if(cb3.isChecked()){
                    String str3 = "C,";
                    str=str+cb3.getText()+",";
                }
                if(cb4.isChecked()){
                    String str4 = "D,";
                    str=str+cb4.getText()+",";
                }

                Toast.makeText(CheckBoxTest.this,str,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check_box_test, menu);
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
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String str = "you choose:" ;
        if(cb1.isChecked()){
            String str1 = "A,"+",";
            str=str+cb1.getText()+",";
        }
        if(cb2.isChecked()){
            String str2 = "B,";
            str=str+cb2.getText()+",";
        }
        if(cb3.isChecked()){
            String str3 = "C,";
            str=str+cb3.getText()+",";
        }
        if(cb4.isChecked()){
            String str4 = "D,";
            str=str+cb4.getText()+",";
        }

        tv.setText(str);




    }
}
