package com.example.fabia.campanario.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fabia on 21/11/2017.
 */

public class DataBase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "databaseCampanario.db";

    public static final String TABLE_CATEGORY="category";
    public static final String CATEGORY_ID="category_id";
    public static final String CATEGORY_NAME="category_name";
    public static final String CATEGORY_DESCRIPTION="category_description";


    public static final String TABLE_STORE="store";
    public static final String STORE_ID="store_id";
    public static final String STORE_UBICATION="store_ubication";
    public static final String STORE_DESCRIPTION="store_description";
    public static final String STORE_NAME="store_name";
    public static final String STORE_HOURS="store_business_hours";
    public static final String STORE_CATEGORY="store_category_id";
    public static final String STORE_TELEPHONE="store_numberTelephone";
    public static final String STORE_WEBPAGE="store_urlWebPage";

    public static final String TABLE_OFFER = "offer";
    public static final String OFFER_ID = "offer_id";
    public static final String OFFER_STORE_ID = "offer_store_id";
    public static final String OFFER_URL_PHOTO = "offer_url";
    public static String OFFER_DESCRIPTION = "offer_description";
    public static String OFFER_DATE="offer_date";


    private static final String SQL_CREATE_ENTITY = "create table " +
            TABLE_PROMOTION + "(" +
            PROMOTION_ID + " integer primary key autoincrement, " +
            PROMOTION_STORE_ID + " text not null, " +
            ENTITY_NAME + " text not null);";

    private static DataBase dataBase;

    public static DataBase getInstance(Context context) {
        if (dataBase == null) {
            dataBase = new DataBase(context);
        }
        return dataBase;
    }

    private DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
