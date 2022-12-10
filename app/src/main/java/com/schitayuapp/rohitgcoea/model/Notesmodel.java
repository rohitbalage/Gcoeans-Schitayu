package com.schitayuapp.rohitgcoea.model;

import java.io.Serializable;

/**
 * Created by ROHIT on 15/09/2018.
 */
public class Notesmodel implements Serializable {

    int id ;
    String name ;
    String text ;

    public Notesmodel(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public Notesmodel(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }
    public void setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return name;
    }
}
