package com.example.fabia.campanario.Models;

import com.example.fabia.campanario.Helpers.DataBase;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.NotNull;
import com.orm.dsl.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabia on 27/11/2017.
 */
@Table(name = DataBase.TABLE_PERTAIN_CATEGORY)
public class PertaintoCategory extends SugarRecord {

    @NotNull
    @Column(name = DataBase.PERTAIN_STORE_ID)
    //private Long store;
    private Store store;
    @NotNull
    @Column(name = DataBase.PERTAIN_CATEGORY_ID)
    private Category category;


    public PertaintoCategory(){

    }

    public PertaintoCategory(Store store,Category category) {
        this.category = category;
        this.store = store;
        //this.store = store.getId();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

/*    public Store getStore() {
        Store store= Store.findById(Store.class,this.store);
        return store;
    }
    public void setStore(Store store) {
        this.store = store.getId();
    }*/

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public static PertaintoCategory getPertaintoCategory(){
        PertaintoCategory pertaintoCategory=PertaintoCategory.first(PertaintoCategory.class);
        if(pertaintoCategory!=null){
            pertaintoCategory.setStore(Store.first(Store.class));
            pertaintoCategory.setCategory(Category.first(Category.class));
        }
        return pertaintoCategory;

    }


    public static List<Store> findStoreByCategory(String nameCategory){
        //Category category=Category.findByName(nameCategory);
        System.out.println("se va abuscar -"+nameCategory+"-");
        List<Category> categories=Category.listAll(Category.class);
        for(Category c:categories){
            System.out.println(c.getName());
        }
        Category category=((ArrayList<Category>) Category.find(    Category.class, DataBase.CATEGORY_NAME +" = ? ",nameCategory)).get(0);
        System.out.println(category.getId()+"**************"+category.getName());

        System.out.println(category.getStores().size()+"++++5454+++++++ +545+++++++++++++");

        return category.getStores();
    }



}
