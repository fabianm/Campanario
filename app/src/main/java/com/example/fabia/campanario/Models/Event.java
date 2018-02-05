package com.example.fabia.campanario.Models;

import com.example.fabia.campanario.Helpers.DataBase;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by fabia on 28/10/2017.
 */
@Table(name = DataBase.TABLE_CATEGORY)
public class Event extends SugarRecord {
    @NotNull
    @Column(name = DataBase.EVENT_ID)
    private Long id;
    @Column(name = DataBase.EVENT_DATE)
    private Date date;
    @Column(name = DataBase.EVENT_DAYS)
    private String days;
    @Column(name = DataBase.EVENT_NAME)
    private String title;
    @Column(name = DataBase.EVENT_URL_PHOTO)
    private String urlphoto;
    @Column(name = DataBase.EVENT_DESCRIPTION)
    private String description;
    @Column(name = DataBase.EVENT_UBICATION)
    private String ubication;


    public Event(){

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
        this.id = id;
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
