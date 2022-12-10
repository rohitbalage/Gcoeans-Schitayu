package com.schitayuapp.rohitgcoea;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.sdsmdg.tastytoast.TastyToast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView camera, faculty,aboutusimg, phone,notes,gsite,contactimg,feedbackbtn,error, flashlg,addon, gallary,
            status, esocial, thanks,developersschitayu,musicicon,pdfcreatoricon, smsicon;
    SwitchCompat mode ;
    BoomMenuButton bmb ;

    TextView updatetext ,share ;
    public static final int REQUEST_LOCATION = 10;
    private static final int REQUEST_PERMISSIONS = 20;
    private DrawerLayout mDrawerLayout ;
    private ActionBarDrawerToggle mToggle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int permission_All = 1;

        String[] Permissions = {Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.SEND_SMS, Manifest.permission.MEDIA_CONTENT_CONTROL,
                Manifest.permission.INTERNET,Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.SET_WALLPAPER,Manifest.permission.SET_WALLPAPER_HINTS,
                Manifest.permission.BLUETOOTH,Manifest.permission.BLUETOOTH_ADMIN,Manifest.permission.ACCESS_FINE_LOCATION
        };

        if (!hasPermissions(this, Permissions)) {

            ActivityCompat.requestPermissions(this, Permissions, permission_All);
        }

        //*****************************************************APP INTRO LIBRARY CODE TO RUN ONCE ************************

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean isFirstStart =getPref.getBoolean("firstStart",true);
                if(isFirstStart)

                {
                    startActivity(new Intent(MainActivity.this,Appintro.class));
                    SharedPreferences.Editor e = getPref.edit();
                    e.putBoolean("firstStart",false);
                    e.apply();

                }

            }
        });

        //***********************************************MY DECLARATIONS *************************************

        updatetext=(TextView)findViewById(R.id.updateline);
        share=(TextView)findViewById(R.id.sharetext);
        smsicon = (ImageView) findViewById(R.id.smsimg);
        camera = (ImageView) findViewById(R.id.cameraimg);
        musicicon = (ImageView) findViewById(R.id.muscicplayer);
        pdfcreatoricon = (ImageView) findViewById(R.id.pdfcreatoriconid);
       phone = (ImageView) findViewById(R.id.phonesimg);
        notes = (ImageView) findViewById(R.id.notesimg);
        flashlg = (ImageView) findViewById(R.id.flashlightimg);
        gallary = (ImageView) findViewById(R.id.gallaryimg);
        esocial = (ImageView) findViewById(R.id.esocialimg);
       // contactimg = (ImageView) findViewById(R.id.contactsimg);
        status = (ImageView) findViewById(R.id.mydeviceimg);
        error = (ImageView) findViewById(R.id.errorimg);
        gsite = (ImageView) findViewById(R.id.gcoeasite);
        feedbackbtn= (ImageView) findViewById(R.id.feedbackimg);
        developersschitayu= (ImageView) findViewById(R.id.devepimg);
        aboutusimg= (ImageView) findViewById(R.id.aboutus);
        addon = (ImageView) findViewById(R.id.addonimg);


        //**************************************************************************************************
        //**********************************MY ON CLICKS ******************************************
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Camerascan.class);
                startActivity(it);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Mydevice.class);
                startActivity(it);
            }
        });

        pdfcreatoricon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, pdfcreater.class);
                startActivity(it);
            }
        });


        musicicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, MusicPlayer.class);
                startActivity(it);
            }
        });

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(MainActivity.this,Pattern.class);
                startActivity(it);
            }
        });
        flashlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(MainActivity.this, Flashlight.class);
                startActivity(it);
            }
        });
        smsicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, SMS.class);
                startActivity(it);
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CALL.class);
                startActivity(it);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Mydevice.class);
                startActivity(it);
            }
        });

        esocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ESocial.class);
                startActivity(it);
            }
        });

        gsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, WebView.class);
                startActivity(it);
            }
        });

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Error.class);
                startActivity(it);
            }
        });

        gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, gallery.class);
                startActivity(it);
            }
        });

        gsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gcoea ="https://gcoea.ac.in/" ;
                Intent it = new Intent(MainActivity.this, Web.class);
                it.putExtra("WEBSITEADDRESS",gcoea);
                startActivity(it);
            }
        });
//***************************************************************************************************************************
        updatetext.setSelected(true);
        ///SPEECH SECTIONS
        // ***************************************************BOOM MENU*********************************************************
        bmb =(BoomMenuButton) findViewById(R.id.boom);
        bmb.setButtonEnum(ButtonEnum.Ham);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_4);

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {

            if (i == 0) {
                HamButton.Builder builder = new HamButton.Builder()
                        .normalImageRes(R.drawable.developersvector)
                        .normalText("Developers")
                        .subNormalText("The Team Behind This Masterpiece")
                        .pieceColorRes(R.color.colorAccent)
                        .normalColor(Color.BLACK)
                        .highlightedColorRes(R.color.white)
                        .subNormalTextColorRes(R.color.colorAccent)
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent it = new Intent(MainActivity.this,Developers.class);
                                startActivity(it);
                            }
                        });
                bmb.addBuilder(builder);
            } else if (i == 1) {

                HamButton.Builder builder = new HamButton.Builder()
                        .normalImageRes(R.drawable.techinicalsupportvector)
                        .normalText("Techinical Support")
                        .pieceColorRes(R.color.colorAccent)
                        .normalColor(Color.BLACK)
                        .highlightedColorRes(R.color.white)
                        .subNormalTextColorRes(R.color.colorAccent)
                        .subNormalText("6 days a week 24*7")
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {

                                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                        "mailto","rohit15005026@gmail.com", null));
                                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                                startActivity(Intent.createChooser(emailIntent, "Send email..."));

                            }
                        });
                bmb.addBuilder(builder);
            }
            if (i == 2) {
                HamButton.Builder builder = new HamButton.Builder()
                        .normalImageRes(R.drawable.rate)
                        .normalText("Sponsors")
                        .pieceColorRes(R.color.colorAccent)
                        .normalColor(Color.BLACK)
                        .highlightedColorRes(R.color.white)
                        .subNormalTextColorRes(R.color.colorAccent)
                        .subNormalText("Our Sponsors")
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent it = new Intent(MainActivity.this,Sponsors.class);
                                startActivity(it);
                            }
                        });
                bmb.addBuilder(builder);
            } else if (i == 3) {

                HamButton.Builder builder = new HamButton.Builder()
                        .normalImageRes(R.drawable.aboutappvector)
                        .normalText("About us")
                        .pieceColorRes(R.color.colorAccent)
                        .normalColor(Color.BLACK)
                        .highlightedColorRes(R.color.white)
                        .subNormalTextColorRes(R.color.colorAccent)
                        .subNormalText("About App")
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent it = new Intent(MainActivity.this,Aboutapp.class);
                                startActivity(it);
                            }
                        });
                bmb.addBuilder(builder);
            }

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Really Exit ?");
            builder.setMessage("Are you sure ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            moveTaskToBack(true);
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(1);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            TastyToast.makeText(MainActivity.this,"Thank You..!",TastyToast.LENGTH_LONG,TastyToast.SUCCESS);
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }


    private static boolean hasPermissions(Context context, String... permissions)

    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && permissions != null) {
            for (String permission : permissions) {

                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.Visitwebsite) {

            String url = "https://prajwalaneventwebeinstein.000webhostapp.com/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_call) {

        } else if (id == R.id.nav_flashight) {

        } else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,share.getText().toString());
            sendIntent.setType("text/plain");
            Intent.createChooser(sendIntent,"Share us to reach out more..");
            startActivity(sendIntent);

        } else if (id == R.id.nav_notes) {

        }
        else if (id == R.id.nav_pdfcreator) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void fshare(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,share.getText().toString());
        sendIntent.setType("text/plain");
        Intent.createChooser(sendIntent,"Share us to reach out more..");
        startActivity(sendIntent);
    }
}
