package com.schitayuapp.rohitgcoea;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camerascan extends AppCompatActivity {

    ImageView imgView ;
    Button btncapture,btnscan ;
    private static final int CAMERA_REQUEST= 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camerascan);

        btncapture=(Button)findViewById(R.id.btncapture);
        btnscan=(Button)findViewById(R.id.btnqr);

        Toast.makeText(this, " Your Photo will save in pictures folder", Toast.LENGTH_SHORT).show();

        btncapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(it,CAMERA_REQUEST);
                File pictureDirectory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureName=getPictureName();
                File imagefile=new File(pictureDirectory,pictureName);
                Uri pictureUri= Uri.fromFile(imagefile);
                it.putExtra(MediaStore.EXTRA_OUTPUT,pictureUri);
                startActivityForResult(it,CAMERA_REQUEST);
            }
        });
        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent it = new Intent(Camerascan.this,QRcodescanner.class);
            startActivity(it);
            }
        });

    }

    private String getPictureName() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp=sdf.format(new Date());
        return "Gcoean's Schitayu"+timestamp+".jpg";

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==CAMERA_REQUEST&& resultCode==RESULT_OK)
        {

        }
    }
}

