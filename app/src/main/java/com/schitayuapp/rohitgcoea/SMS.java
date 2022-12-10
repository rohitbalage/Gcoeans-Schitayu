package com.schitayuapp.rohitgcoea;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

public class SMS extends Activity {

    Button btnSend ,inbox ;
    TextView txt ;
    EditText etMsg ,etPhoneNO ;
    private static final int MY_PERMISSION_REQUEST_SMS =0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        btnSend =(Button)findViewById(R.id.idBtnSend);
        etMsg =(EditText)findViewById(R.id.msg);
        etPhoneNO =(EditText)findViewById(R.id.phone);
        inbox =(Button)findViewById(R.id.inbox);
        txt =(TextView)findViewById(R.id.sendmsg);


        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(SMS.this, Inbox.class);
                startActivity(it);
            }
        });

    }

    public void sendSMS(View view) {

        int PermissionCheck = ContextCompat.checkSelfPermission( this, Manifest.permission.SEND_SMS);
        if(PermissionCheck==PackageManager.PERMISSION_GRANTED){

            MyMessage();
        }
        else {
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS}

                    ,MY_PERMISSION_REQUEST_SMS
            );
        }
    }
    public void MyMessage()
    {
        String text =txt.getText().toString().trim();
        String myNumber =etPhoneNO.getText().toString().trim();
        String myMsg =etMsg.getText().toString().trim();
        String totalmsg =myMsg+"\n"+text;
        if(myNumber.equals("")
                ||myMsg.equals(""))
        {
            TastyToast.makeText(SMS.this,"Please submit proper data or message",TastyToast.LENGTH_LONG,TastyToast.ERROR);
        }
        else{
            if(TextUtils.isDigitsOnly(myNumber))
            {
                SmsManager smsManager =SmsManager.getDefault();
                smsManager.sendTextMessage(myNumber,null ,totalmsg,null,null);
                etMsg.setText("");
                etPhoneNO.setText("");
                TastyToast.makeText(SMS.this,"Message send succesfully..!",TastyToast.LENGTH_LONG,TastyToast.SUCCESS);
            }else {

                Toast.makeText(this, " Please Enter Numbers only !", Toast.LENGTH_SHORT).show();
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case MY_PERMISSION_REQUEST_SMS:
                if (grantResults.length>=0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED)
                {
                    MyMessage();
                }else{
                    Toast.makeText(this, " you don't have required permission !", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
