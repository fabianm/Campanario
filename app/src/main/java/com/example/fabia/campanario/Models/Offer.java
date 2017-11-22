package com.example.fabia.campanario.Models;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by fabia on 2/11/2017.
 */

public class Offer extends SugarRecord{
    private Date dateInitial;
    private Date dateFinal;
    private String urlPhoto;
    private String description;
    private String store;

    public Offer() {
    }

    public Offer(Date dateInitial, String urlPhoto, String store) {
        this.dateInitial = dateInitial;
        this.urlPhoto = urlPhoto;
        this.store = store;
    }
    public Offer(Date dateInitial, String urlPhoto, String store, String description) {
        this.dateInitial = dateInitial;
        this.urlPhoto = urlPhoto;
        this.store = store;
        this.description=description;
    }


    public Offer(Date dateInitial, Date dateFinal, String urlPhoto, String store) {
        this.dateInitial = dateInitial;
        this.dateFinal = dateFinal;
        this.urlPhoto = urlPhoto;
        this.store = store;
    }

    public Offer(Date dateInitial, Date dateFinal, String urlPhoto, String store,String description) {
        this.dateInitial = dateInitial;
        this.dateFinal = dateFinal;
        this.urlPhoto = urlPhoto;
        this.description = description;
        this.store = store;
    }

    public Date getDateInitial() {
        return dateInitial;
    }

    public void setDateInitial(Date dateInitial) {
        this.dateInitial = dateInitial;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
