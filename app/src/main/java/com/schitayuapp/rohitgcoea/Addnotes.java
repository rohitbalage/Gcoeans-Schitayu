package com.schitayuapp.rohitgcoea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.schitayuapp.rohitgcoea.Noteslist;
import com.schitayuapp.rohitgcoea.database.DBHelper;
import com.schitayuapp.rohitgcoea.model.Notesmodel;

public class Addnotes extends AppCompatActivity {

    EditText nname ,ntext ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnotes);

        nname =(EditText)findViewById(R.id.ednotename);
        ntext =(EditText)findViewById(R.id.ednotetext);
    }
    public void process(View view) {

        switch ((view.getId()))

        {
            case R.id.btnsavenote :
                String name =nname.getText().toString();
                String text =ntext.getText().toString();

                if(TextUtils.isEmpty(name))
                {
                    nname.setError("please provide name");
                    return;
                }

                if(TextUtils.isEmpty(text))
                {
                    ntext.setError("please provide some text ");
                    return;
                }
                DBHelper dbHelper =new DBHelper(this);
                Notesmodel notesmodel =new Notesmodel(name ,text);

                long result = dbHelper.addNotes(notesmodel);

                if (result!=-1)
                {
                    Toast.makeText(this,"Notes Saved",Toast.LENGTH_LONG).show();
                    nname.setText("");
                    ntext.setText("");
                }else {
                    Toast.makeText(this,"Failed To Saved",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnshowall :
                startActivity( new Intent(Addnotes.this, Noteslist.class));
                break;
        }
    }
}
