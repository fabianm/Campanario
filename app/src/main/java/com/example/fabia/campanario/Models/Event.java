package com.example.fabia.campanario.Models;

import java.util.Date;

/**
 * Created by fabia on 28/10/2017.
 */

public class Event {
    private Date date;
    private String title;
    private String description;
    private String ubication;
    private String urlphoto;


    public Event(){
        this.title="";
        this.description="";
        this.ubication="";
        this.urlphoto="";
        this.date=null;
    }

    public Event(Date date, String title, String description, String ubication) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.ubication = ubication;
    }
    public Event(Date date, String title, String description, String ubication,String urlphoto ) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.ubication = ubication;
        this.urlphoto=urlphoto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getUrlphoto() {
        return urlphoto;
    }

    public void setUrlphoto(String urlphoto) {
        this.urlphoto = urlphoto;
    }

    public String getFormattedDate(){
        String dateStr="";

        dateStr+=this.date.getHours()+":"+this.date.getMinutes();

        return dateStr;
    }

    @Override
    public String toString(){
        return this.title;
    }
}
