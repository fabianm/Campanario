package com.example.fabia.campanario.Models;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.util.Date;

/**
 * Created by fabia on 22/11/2017.
 */

public class Notification extends SugarRecord{
    private String name;
    private String description;
    private Date date;
    private String url_photo;

    public Notification() {
    }

    public Notification(String name, String description, Date date, String url_photo) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.url_photo = url_photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

}
