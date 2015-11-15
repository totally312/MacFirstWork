package com.example.huangst.macfirstwork;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangst on 15/10/12.
 */
public class ContactsTest extends Activity {

    List<String> contactsList = new ArrayList<String>();
    ListView contactsview;
    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceStated){
        super.onCreate(savedInstanceStated);
        setContentView(R.layout.contactstest);

        contactsview=(ListView)findViewById(R.id.contactstest);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList);
        contactsview.setAdapter(adapter);
        contactsList.add("why no message");
        readContacts();



    }

    private void readContacts(){
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        int n=0;
        if (cursor.moveToFirst()) {
            do {

                String name = cursor.getString(cursor.getColumnIndex(android.provider.ContactsContract.Contacts.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Log.d("ContactsTest", "name=" + name + " number=" + number);
                contactsList.add(name + "\n" + number);

                n=n+1;
            }while (cursor.moveToNext());

        }

        contactsList.add(""+n);

        cursor.close();

    }

}
