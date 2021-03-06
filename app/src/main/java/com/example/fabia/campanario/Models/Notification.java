package com.example.fabia.campanario.Models;

import com.example.fabia.campanario.Helpers.DataBase;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

import java.util.Date;

/**
 * Created by fabia on 22/11/2017.
 */

@Table(name = DataBase.TABLE_NOTIFICATION)
public class Notification extends SugarRecord{
    @NotNull
    @Column(name = DataBase.NOTIFICATION_ID)
    private Long id;
    @Column(name = DataBase.NOTIFICATION_NAME)
    private String name;
    @Column(name = DataBase.NOTIFICATION_DESCRIPTION)
    private String description;
    @Column(name = DataBase.NOTIFICATION_DATE)
    private Date date;
    @Column(name = DataBase.NOTIFICATION_URL_PHOTO)
    private String url_photo;

    public Notification() {
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
