package com.schitayuapp.rohitgcoea;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.schitayuapp.rohitgcoea.database.DBHelper;
import com.schitayuapp.rohitgcoea.model.Notesmodel;

import java.util.List;

public class Noteslist extends AppCompatActivity {

    ListView lvnotes ;
    List<Notesmodel> list ;
    ArrayAdapter <Notesmodel> arrayAdapter ;
    DBHelper dbHelper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteslist);
        lvnotes =findViewById(R.id.lvnotes);
        dbHelper=new DBHelper(this);
        list = dbHelper.getAllnotes();
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        lvnotes.setAdapter(arrayAdapter);
        lvnotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Notesmodel notesmodel =  list.get(position);
                Intent intent = new Intent(Noteslist.this,Notesupdate.class);
                intent.putExtra("NOTESMODEL",notesmodel);
                startActivity(intent);
            }
        });

        lvnotes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Notesmodel notesmodel  = list.get(position);
                int nid  =notesmodel.getId();
                int result =  dbHelper.deletenote(nid);

                if (result>0)
                {
                    Toast.makeText(Noteslist.this,"Note delete",Toast.LENGTH_SHORT).show();
                    list.remove(notesmodel);
                    arrayAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(Noteslist.this,"something went wrong",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }

}
