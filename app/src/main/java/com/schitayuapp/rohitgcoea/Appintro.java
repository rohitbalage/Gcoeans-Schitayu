package com.schitayuapp.rohitgcoea;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class Appintro extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun)
        {
            // Code to run once
            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }

        // slide 1
        addSlide(AppIntroFragment.newInstance("INTRODUCING" +
                        " GCOEAN'S " +
                        "SCHITAYU",
                "Gcoean's Schitayu is a multifunctional android app which contain all the functionalites of andorid ",
                R.drawable.appicon,
                Color.parseColor("#01579b")

        ));

        //slide 2
        addSlide(AppIntroFragment.newInstance("SCHITAYU LIVE STREAMING","Now, watch all the live streaming of tv channels right from app",
                R.drawable.appicon,
                Color.parseColor("#0277bd")

        ));

        //slide 3
        addSlide(AppIntroFragment.newInstance("FIND UTILITY TOOLS","find regurlar utility tools like camera access,QR scan pf creation,call service ,sms ,Inbox and many more !",
                R.drawable.appicon,
                Color.parseColor("#0288d1")

        ));

        //slide 4
        addSlide(AppIntroFragment.newInstance("STAY TUNNED WITH SOCIAL AND E-COMMERCE ","get connect wiht your social network and e-commerace site anytime",
                R.drawable.appicon,
                Color.parseColor("#039be5")

        ));
        //slide 5
        addSlide(AppIntroFragment.newInstance("PRIVATE NOTES WITH SECURE PATTRN LOCK","Secure your prive notes right from app with pattern lock",
                R.drawable.appicon,
                Color.parseColor("#03a9f4")

        ));
        //slide 6
        addSlide(AppIntroFragment.newInstance("GET INFO ,LOCATON AND MAY MORE","get fine position , inormation gathering and many more",
                R.drawable.appicon,
                Color.parseColor("#29b6f6")

        ));

        showStatusBar(false);
        setBarColor(Color.parseColor("#333639"));
        setSeparatorColor(Color.parseColor("#2196F3"));
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        Intent it = new Intent(Appintro.this,MainActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        Intent it = new Intent(Appintro.this,MainActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {

    }
}
