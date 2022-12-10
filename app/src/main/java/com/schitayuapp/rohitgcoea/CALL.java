package com.schitayuapp.rohitgcoea;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.jar.Manifest;

public class CALL extends AppCompatActivity {
    EditText et_call ;
    ImageView createcall;
    Button btn ;
    int pid =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);


        createcall=(ImageView)findViewById(R.id.callimage);
        et_call =(EditText)findViewById(R.id.et_phone);


        createcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callatruntimepermission();

            }
        });
    }

    private void callatruntimepermission() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && checkSelfPermission(android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)

        {
            requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE},pid);
        }
        else
        {
            String smobile=et_call.getText().toString();
            Intent call=new Intent(Intent.ACTION_CALL);
            call.setData(Uri.parse("tel:"+smobile));
            startActivity(call);
        }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}

