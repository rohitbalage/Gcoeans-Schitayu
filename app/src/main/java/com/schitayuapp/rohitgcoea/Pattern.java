package com.schitayuapp.rohitgcoea;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

import io.paperdb.Paper;

public class Pattern extends AppCompatActivity {
    String save_pattern_key ="pattern_code";
    String final_pattern="";
    PatternLockView mPatternLockView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paper.init(this);
        final String save_pattern = Paper.book().read(save_pattern_key);
        if(save_pattern!=null&&!save_pattern.equals("null"))
        {

            setContentView(R.layout.pattern_screen);
            mPatternLockView=(PatternLockView)findViewById(R.id.pattern_lock_view);
            mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {

                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {


                    String final_pattern = PatternLockUtils.patternToString(mPatternLockView,pattern);
                    if(final_pattern.equals(save_pattern))
                    {
                        Intent it =new Intent (Pattern.this,Addnotes.class);
                        startActivity(it);
                    }
                    else
                        Toast.makeText(Pattern.this, "Password incorrect !",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCleared() {

                }
            });

        }
        else
        {

            setContentView(R.layout.activity_pattern);
            mPatternLockView=(PatternLockView)findViewById(R.id.pattern_lock_view);
            mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {

                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    final_pattern=PatternLockUtils.patternToString(mPatternLockView,pattern);

                }

                @Override
                public void onCleared() {

                }
            });{



        };


            Button btnsetup =(Button)findViewById(R.id.btnSetPattern);
            btnsetup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Paper.book().write(save_pattern_key,final_pattern);
                    Toast.makeText(Pattern.this,"Save pattern okay !!!",Toast.LENGTH_SHORT).show();
                    Intent it=new Intent(Pattern.this,Addnotes.class);
                    startActivity(it);
                }
            });

        }


    }


}
