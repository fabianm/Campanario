package com.example.fabia.campanario.Pojos;

/**
 * Created by Fabian Muñoz on 5/02/2018.
 */

public class CategoryPOJO {
    private Long category_id;
    private String category_name;
    private String category_description;

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }
}
