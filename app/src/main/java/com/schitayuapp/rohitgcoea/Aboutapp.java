package com.schitayuapp.rohitgcoea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Aboutapp extends AppCompatActivity {

    TextView sharetxt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutapp);

        sharetxt =(TextView)findViewById(R.id.shareaboutappp);


    }




    public void shareapp(View view) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,sharetxt.getText().toString());
        sendIntent.setType("text/plain");
        Intent.createChooser(sendIntent,"Share us to reach out more..");
        startActivity(sendIntent);

    }
}
