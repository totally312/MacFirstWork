package com.example.huangst.macfirstwork;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static java.lang.Thread.sleep;

public class FileData extends AppCompatActivity {

    EditText et ;
    TextView tv ;

    FileOutputStream fos;
    OutputStreamWriter opsw;
    BufferedWriter bw;

    FileInputStream fis;
    InputStreamReader ipsr;
    BufferedReader br;

    StringBuilder content;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_data);


        et = (EditText) findViewById(R.id.inputtext);
        tv = (TextView) findViewById(R.id.filedata);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fos = openFileOutput("data", Context.MODE_PRIVATE);
                    opsw = new OutputStreamWriter(fos);


//                    opsw.write(et.getText().toString());
//                    opsw.flush();
//                    fos.flush();
//                    opsw.close();
//                    fos.close();
//                    Toast.makeText(FileData.this,"储存成功",Toast.LENGTH_SHORT).show();

                    bw = new BufferedWriter(opsw);
                    bw.write(et.getText().toString());
                    bw.flush();
                    opsw.flush();
                    fos.flush();
                    bw.close();
                    opsw.close();
                    fos.close();
                    Toast.makeText(FileData.this,"储存成功",Toast.LENGTH_SHORT).show();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fis = openFileInput("data");
                    ipsr = new InputStreamReader(fis);

//                    char a[] = new char[fis.available()];
//                    ipsr.read(a);
//                    ipsr.close();
//                    fis.close();
//
//                    String str = new String(a);
//                    tv.setText(str);

                    br = new BufferedReader(ipsr);
                    content = new StringBuilder();

                    String line = "";
                    while((line = br.readLine()) != null){
                        content.append(line);
                    }



                    br.close();
                    ipsr.close();
                    fis.close();


                    tv.setText(content.toString());

                    Log.d("fuck","successful");


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });






    }













}
