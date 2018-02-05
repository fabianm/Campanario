package com.example.fabia.campanario.Pojos;

import java.util.Date;

/**
 * Created by Fabian Muñoz on 5/02/2018.
 */

public class OfferPOJO {
    private Long offer_id;
    private Long store_id;
    private String offer_url_photo;
    private String offer_description;
    private String offer_date_initial;
    private String offer_date_final;
    private Integer offer_state;

    public Long getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(Long offer_id) {
        this.offer_id = offer_id;
    }

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public String getOffer_url_photo() {
        return offer_url_photo;
    }

    public void setOffer_url_photo(String offer_url_photo) {
        this.offer_url_photo = offer_url_photo;
    }

    public String getOffer_description() {
        return offer_description;
    }

    public void setOffer_description(String offer_description) {
        this.offer_description = offer_description;
    }

    public String getOffer_date_initial() {
        return offer_date_initial;
    }

    public void setOffer_date_initial(String offer_date_initial) {
        this.offer_date_initial = offer_date_initial;
    }

    public String getOffer_date_final() {
        return offer_date_final;
    }

    public void setOffer_date_final(String offer_date_final) {
        this.offer_date_final = offer_date_final;
    }

    public Integer getOffer_state() {
        return offer_state;
    }

    public void setOffer_state(Integer offer_state) {
        this.offer_state = offer_state;
    }
}
