package com.schitayuapp.rohitgcoea;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.schitayuapp.rohitgcoea.database.DBHelper;
import com.schitayuapp.rohitgcoea.model.Notesmodel;

public class Notesupdate extends AppCompatActivity {

    EditText edname ,edtext ;
    DBHelper dbHelper ;
    int id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper =new DBHelper(this);
        setContentView(R.layout.activity_notesupdate);
        edname =(EditText)findViewById(R.id.ednotename) ;
        edtext =(EditText)findViewById(R.id.ednotetext) ;

        Notesmodel notesmodel = (Notesmodel) getIntent().getExtras().getSerializable("NOTESMODEL");
        id =notesmodel.getId();
        edname.setText(notesmodel.getName());
        edtext.setText(notesmodel.getText());

    }

    public void update(View view) {

        String name =edname.getText().toString();
        String text =edtext.getText().toString();

        Notesmodel notesmodel =new Notesmodel(id,name,text);

        int result = dbHelper.updateNotesmodel(notesmodel);

        if(result>0)

        {
            Toast.makeText(this,"Note updated",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Error..",Toast.LENGTH_LONG).show();
        }

    }
}
