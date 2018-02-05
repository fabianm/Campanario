package com.example.fabia.campanario.Persistence;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fabia on 23/11/2017.
 */

public class PersistenceData {
    private static final String NAME_FILE_SHARED_PREFERENCE = "dataPreference";
    private static final String LOAD_DATA = "load_data";
    private static final String SAVE_STORE = "save_store";
    private static final String SAVE_CATEGORY = "save_category";
    private static final String SAVE_OFFER = "save_offer";
    private static final String SAVE_CENTER = "save_center";


    private Context context;

    public PersistenceData(Context context) {
        this.context = context;
    }

    private SharedPreferences getSharedPreferences() {
        //return this.context.getSharedPreferences(NAME_FILE_SHARED_PREFERENCE, this.context.MODE_APPEND);
        return this.context.getSharedPreferences(NAME_FILE_SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    public boolean isLoadData() {
        return getSharedPreferences().getBoolean(LOAD_DATA, false);
    }

    public void setLoadData(boolean load_data) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(LOAD_DATA, load_data);
        editor.commit();
    }

    public boolean isSaveStore() {
        return getSharedPreferences().getBoolean(SAVE_STORE, false);
    }

    public void setSaveStore(boolean saveStore) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(SAVE_STORE, saveStore);
        editor.commit();
    }

    public boolean isSaveCategory() {
        return getSharedPreferences().getBoolean(SAVE_CATEGORY, false);
    }

    public void setSaveCategory(boolean saveCategory) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(SAVE_CATEGORY, saveCategory);
        editor.commit();
    }

    public boolean isSaveOffer() {
        return getSharedPreferences().getBoolean(SAVE_OFFER, false);
    }

    public void setSaveOffer(boolean saveOffer) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(SAVE_OFFER, saveOffer);
        editor.commit();
    }

    public boolean isSaveCenter() {
        return getSharedPreferences().getBoolean(SAVE_CENTER, false);
    }

    public void setSaveCenter(boolean saveCenter) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(SAVE_CENTER, saveCenter);
        editor.commit();
    }


}
