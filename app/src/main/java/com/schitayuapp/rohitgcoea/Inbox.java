package com.schitayuapp.rohitgcoea;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

    public class Inbox extends AppCompatActivity {


    ListView listView;
    ArrayList<String> smsList;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);


        listView = (ListView) findViewById(R.id.idList);
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            showContacts();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS},
                    PERMISSIONS_REQUEST_READ_CONTACTS
            );
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {

            showContacts();
        } else {

            Toast.makeText(this, "Please grant the permission", Toast.LENGTH_SHORT).show();
        }


    }

    private void showContacts() {


        Uri inboxUri = Uri.parse("content://sms/inbox");
        smsList = new ArrayList<>();
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(inboxUri, null, null, null, null);
        while (cursor.moveToNext()){
            String number =cursor.getString(cursor.getColumnIndexOrThrow("address")).toString();
            String body =cursor.getString(cursor.getColumnIndexOrThrow("body")).toString();
            smsList.add("Number :"+number+"\n"+"Message :"+body);
        }

        cursor.close();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                smsList
        );
        listView.setAdapter(adapter);
    }
}
