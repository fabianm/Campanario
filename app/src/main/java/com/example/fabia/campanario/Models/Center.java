package com.example.fabia.campanario.Models;

import com.example.fabia.campanario.Helpers.DataBase;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

/**
 * Created by Fabian Muñoz on 5/02/2018.
 */
@Table(name = DataBase.TABLE_SHOPPING_CENTER)
public class Center extends SugarRecord {
    @NotNull
    @Column(name=DataBase.CENTER_ID)
    private Long id;
    @NotNull
    @Column(name=DataBase.CENTER_NAME)
    private String name;
    @NotNull
    @Column(name=DataBase.CENTER_ADDRESS)
    private String address;
    @NotNull
    @Column(name=DataBase.CENTER_TELEPHONE)
    private String telephone;
    @Column(name=DataBase.CENTER_HOURS)
    private String businness_hours;

    public Center() {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBusinness_hours() {
        return businness_hours;
    }

    public void setBusinness_hours(String businness_hours) {
        this.businness_hours = businness_hours;
    }
}
