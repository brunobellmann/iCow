package com.android.icow;

/**
 * Created by Maxet on 07.01.2018.
 */

public class NotizCard {

    private int id;
    private String title, notiztext, datum; //Noch nicht alles benutzt
    private int image;


    public NotizCard(int id, String title, String notiztext, String datum, int image) {
        this.id = id;
        this.title = title;
        this.notiztext = notiztext;
        this.datum = datum;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNotiztext() {
        return notiztext;
    }

    public String getDatum() {
        return datum;
    }

    public int getImage() {
        return image;
    }
}
