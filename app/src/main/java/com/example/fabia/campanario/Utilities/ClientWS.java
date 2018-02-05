package com.example.fabia.campanario.Utilities;

import com.example.fabia.campanario.Pojos.CategoryPOJO;
import com.example.fabia.campanario.Pojos.CenterPOJO;
import com.example.fabia.campanario.Pojos.PertaintoCategoryPOJO;
import com.example.fabia.campanario.Pojos.StorePOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Fabian Muñoz on 5/02/2018.
 */

public interface ClientWS {
    public static final String urlWS="http://186.81.129.129:2018";
    @GET("/api/categories")
    Call<List<CategoryPOJO>> getCategories();
    @GET("/api/centers")
    Call<List<CenterPOJO>> getCenters();
    @GET("/api/stores")
    Call<List<StorePOJO>> getStores();
    @GET("/api/stores/findbycategory/{category_id}")
    Call<List<StorePOJO>> findStoresByCategory(@Path("category_id") Long category);
    @GET("/api/stores/findbycenter/{center_id}")
    Call<List<StorePOJO>> findStoresByCenters(@Path("center_id") Long center);
    @GET("/api/pertaintocategory")
    Call<List<PertaintoCategoryPOJO>> getPertain();
}
