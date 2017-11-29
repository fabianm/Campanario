package com.example.fabia.campanario.Models;

import com.example.fabia.campanario.Helpers.DataBase;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

import java.util.ArrayList;

/**
 * Created by fabia on 2/11/2017.
 */

@Table(name = DataBase.TABLE_STORE)
public class Store extends SugarRecord{
    @Column(name=DataBase.STORE_NAME)
    private String name;
    @Column(name=DataBase.STORE_UBICATION)
    private String ubication;
    @Column(name=DataBase.STORE_DESCRIPTION)
    private String description;
    @Column(name=DataBase.STORE_URL_LOGO)
    private String urlLogo;
    @Column(name=DataBase.STORE_HOURS)
    private String business_hours;

    @Column(name=DataBase.STORE_TELEPHONE)
    private String numberTelephone;
    @Column(name=DataBase.STORE_WEBPAGE)
    private String urlWebPage;

    public Store(String name) {
        this.name = name;
       // this.listOffers=new ArrayList<>();
    }

    public Store(String name, String ubication, String urlLogo) {
        this.name = name;
        this.ubication = ubication;
        this.urlLogo = urlLogo;
       // this.listOffers=new ArrayList<>();

    }

    public Store(String name,String numberTelephone,  String ubication, String urlLogo) {
        this.name = name;
        this.ubication = ubication;
        this.urlLogo = urlLogo;
        //this.listOffers=new ArrayList<>();
        this.numberTelephone=numberTelephone;

    }

    public Store(String name, String numberTelephone,  String ubication, String urlLogo,String description) {
        this.name = name;
        this.ubication = ubication;
        this.description = description;
        this.urlLogo = urlLogo;
       // this.listOffers=new ArrayList<>();
        this.numberTelephone=numberTelephone;


    }

    public Store(String name,String numberTelephone, String ubication, String urlLogo,String description,String business_hours) {
        this.name = name;
        this.ubication = ubication;
        this.description = description;
        this.urlLogo = urlLogo;
        this.business_hours = business_hours;
       // this.listOffers=new ArrayList<>();
        this.numberTelephone=numberTelephone;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getBusiness_hours() {
        return business_hours;
    }

    public void setBusiness_hours(String business_hours) {
        this.business_hours = business_hours;
    }

    public ArrayList<Offer> getListOffers() {
        return new ArrayList<Offer>();
    }

 /*   public void setListOffers(ArrayList<Offer> listOffers) {
        this.listOffers = listOffers;
    }

    public void addOffer(Offer offer){
        this.listOffers.add(offer);
    }*/



    public String getNumberTelephone() {
        return numberTelephone;
    }

    public void setNumberTelephone(String numberTelephone) {
        this.numberTelephone = numberTelephone;
    }

    public String getUrlWebPage() {
        return urlWebPage;
    }

    public void setUrlWebPage(String urlWebPage) {
        this.urlWebPage = urlWebPage;
    }

   }
