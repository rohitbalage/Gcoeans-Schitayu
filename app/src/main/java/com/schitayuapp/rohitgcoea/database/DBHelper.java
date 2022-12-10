package com.schitayuapp.rohitgcoea.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.schitayuapp.rohitgcoea.model.Notesmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ROHIT on 15/09/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME="schitayu.db";
    private static  final  int DATABASE_VERSION=1;
    private static final String KEY_ID ="id";
    private static final String KEY_NAME ="name";
    private static final String KEY_TEXT ="text";
    private static final String TABLE_NOTES="tbl_notes";

    private static final String CREATE_TABLE_NOTES="CREATE TABLE " + TABLE_NOTES +"(  "
            + KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_NAME + " TEXT NOT NULL,"
            + KEY_TEXT + " TEXT NOT NULL )";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NOTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES );
        onCreate(db);

    }

    public long addNotes(Notesmodel notesmodel) {

        SQLiteDatabase db =getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(KEY_NAME,notesmodel.getName());
        values.put(KEY_TEXT,notesmodel.getText());
       return  db.insert(TABLE_NOTES,null,values);
    }

    public List<Notesmodel> getAllnotes() {
        List<Notesmodel> notesmodelList =new ArrayList<>();
        SQLiteDatabase db =getReadableDatabase();
       Cursor cursor = db.rawQuery("SELECT * from "+TABLE_NOTES,null);

       if (cursor.moveToFirst()){

           do {
               int id = cursor.getInt(0);
               String name =cursor.getString(1);
               String text =cursor.getString(2);

              Notesmodel notesmodel =new Notesmodel(id ,name ,text);
             notesmodelList.add(notesmodel);
           }while (cursor.moveToNext());
       }
        return notesmodelList;
    }

    public int updateNotesmodel(Notesmodel notesmodel) {
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,notesmodel.getName());
        values.put(KEY_TEXT,notesmodel.getText());
      return   db.update(TABLE_NOTES,values,"id=?",new String[]{String.valueOf(notesmodel.getId())});

    }

    public int deletenote(int nid) {
        SQLiteDatabase db =getWritableDatabase();
      return   db.delete(TABLE_NOTES ,"id=?",new String[]{String.valueOf(nid)} );

    }
}