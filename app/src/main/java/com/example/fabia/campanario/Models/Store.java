package com.example.fabia.campanario.Models;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by fabia on 2/11/2017.
 */

public class Store extends SugarRecord{
    private String name;
    private String ubication;
    private String description;
    private String urlLogo;
    private String business_hours;
    private ArrayList<Offer> listOffers;
    private String category;
    private String numberTelephone;
    private String urlWebPage;

    public Store(String name) {
        this.name = name;
        this.listOffers=new ArrayList<>();
    }

    public Store(String name, String ubication, String urlLogo) {
        this.name = name;
        this.ubication = ubication;
        this.urlLogo = urlLogo;
        this.listOffers=new ArrayList<>();

    }

    public Store(String name,String numberTelephone,  String ubication, String urlLogo) {
        this.name = name;
        this.ubication = ubication;
        this.urlLogo = urlLogo;
        this.listOffers=new ArrayList<>();
        this.numberTelephone=numberTelephone;

    }

    public Store(String name, String numberTelephone,  String ubication, String urlLogo,String description) {
        this.name = name;
        this.ubication = ubication;
        this.description = description;
        this.urlLogo = urlLogo;
        this.listOffers=new ArrayList<>();
        this.numberTelephone=numberTelephone;


    }

    public Store(String name,String numberTelephone, String ubication, String urlLogo,String description,String business_hours) {
        this.name = name;
        this.ubication = ubication;
        this.description = description;
        this.urlLogo = urlLogo;
        this.business_hours = business_hours;
        this.listOffers=new ArrayList<>();
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
        return listOffers;
    }

    public void setListOffers(ArrayList<Offer> listOffers) {
        this.listOffers = listOffers;
    }

    public void addOffer(Offer offer){
        this.listOffers.add(offer);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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
