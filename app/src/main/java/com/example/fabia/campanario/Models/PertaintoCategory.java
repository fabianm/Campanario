package com.example.fabia.campanario.Models;

import com.example.fabia.campanario.Helpers.DataBase;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Table;

/**
 * Created by fabia on 27/11/2017.
 */
@Table(name = DataBase.TABLE_PERTAIN_CATEGORY)
public class PertaintoCategory extends SugarRecord {
    @Column(name = DataBase.PERTAIN_CATEGORY_ID)
    private Category category;
    @Column(name = DataBase.PERTAIN_STORE_ID)
    private Store store;
    public PertaintoCategory(){

    }

    public PertaintoCategory(Category category, Store store) {
        this.category = category;
        this.store = store;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
