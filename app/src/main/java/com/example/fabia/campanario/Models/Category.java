package com.example.fabia.campanario.Models;

import com.example.fabia.campanario.Helpers.DataBase;
import com.example.fabia.campanario.R;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

/**
 * Created by fabia on 23/11/2017.
 */
@Table(name = DataBase.TABLE_CATEGORY)
public class Category extends SugarRecord {
    @Column(name = DataBase.CATEGORY_NAME)
    private String name;
    @Column(name = DataBase.CATEGORY_DESCRIPTION)
    private String description;

    public Category(){

    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Category(String name) {
        this.name = name;
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
    public static Category findByName(String name_categpry){
        Category category=(Category) find(    Category.class, DataBase.CATEGORY_NAME +" = ?",name_categpry);
        return category;

    }

}
