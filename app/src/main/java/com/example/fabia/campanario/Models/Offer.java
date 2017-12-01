package com.example.fabia.campanario.Models;

import com.example.fabia.campanario.Helpers.DataBase;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by fabia on 2/11/2017.
 */
@Table(name = DataBase.TABLE_OFFER)
public class Offer extends SugarRecord{
    @Column(name = DataBase.OFFER_DATE_INITIAL)
    private Date dateInitial;
    @Column(name = DataBase.OFFER_DATE_FINAL)
    private Date dateFinal;
    @Column(name = DataBase.OFFER_URL_PHOTO)
    private String urlPhoto;
    @Column(name = DataBase.OFFER_DESCRIPTION)
    private String description;
    @Column(name = DataBase.OFFER_STORE_ID)
    private Store store;

    public Offer() {
    }

    public Offer(Date dateInitial, String urlPhoto, Store store) {
        this.dateInitial = dateInitial;
        this.urlPhoto = urlPhoto;
        this.store = store;
    }
    public Offer(Date dateInitial, String urlPhoto, Store store, String description) {
        this.dateInitial = dateInitial;
        this.urlPhoto = urlPhoto;
        this.store = store;
        this.description=description;
    }

    public Offer(Date dateInitial, String urlPhoto, Long id_store, String description) {
        this.dateInitial = dateInitial;
        this.urlPhoto = urlPhoto;
        this.store = Store.findById(Store.class,id_store);
        this.description=description;
    }


    public Offer(Date dateInitial, Date dateFinal, String urlPhoto, Store store) {
        this.dateInitial = dateInitial;
        this.dateFinal = dateFinal;
        this.urlPhoto = urlPhoto;
        this.store = store;
    }

    public Offer(Date dateInitial, Date dateFinal, String urlPhoto, Store store,String description) {
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
