package com.android.icow;

/**
 * Created by Maxet on 07.01.2018.
 */

public class NotizCard {


    private String last_modification, title, content, latitude, longitude, image;
    private long id;

    public NotizCard() {
        this(0, null, null, null, null, null, null);
    }

    public NotizCard(final String title) {
        this(0, null, title, null, null, null, null);
    }

    public NotizCard(int id, String last_modification, String title, String content, String latitude, String longitude, String image) {
        this.id = id;
        this.last_modification = last_modification;
        this.title = title;
        this.content = content;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }

    public String getLast_modification() {
        return last_modification;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getImage() {
        return image;
    }

    public long getId() {
        return id;
    }

    public void setLast_modification(String last_modification) {
        this.last_modification = last_modification;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(long id) {
        this.id = id;
    }
}
