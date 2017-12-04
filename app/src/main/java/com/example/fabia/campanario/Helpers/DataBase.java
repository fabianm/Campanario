package com.example.fabia.campanario.Helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fabia.campanario.Models.PertaintoCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabia on 21/11/2017.
 */

public class DataBase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "dbCampanario.db";

    public static final String TABLE_CATEGORY="category";
    public static final String CATEGORY_ID="category_id";
    public static final String CATEGORY_NAME="category_name";
    public static final String CATEGORY_DESCRIPTION="category_description";


    public static final String TABLE_STORE="store";
    public static final String STORE_ID="store_id";
    public static final String STORE_UBICATION="store_ubication";
    public static final String STORE_DESCRIPTION="store_description";
    public static final String STORE_URL_LOGO = "store_url_logo";
    public static final String STORE_NAME="store_name";
    public static final String STORE_HOURS="store_business_hours";
    public static final String STORE_CATEGORY_ID="store_category_id";
    public static final String STORE_TELEPHONE="store_numberTelephone";
    public static final String STORE_WEBPAGE="store_urlWebPage";

    public static final String TABLE_PERTAIN_CATEGORY="pertain_category";
    public static final String PERTAIN_CATEGORY_ID="category_id";
    public static final String PERTAIN_STORE_ID="store_id";

    public static final String TABLE_OFFER = "offer";
    public static final String OFFER_ID = "offer_id";
    public static final String OFFER_STORE_ID = "offer_store_id";
    public static final String OFFER_URL_PHOTO = "offer_url";
    public static final String OFFER_DESCRIPTION = "offer_description";
    public static final String OFFER_DATE_INITIAL="offer_date_initial";
    public static final String OFFER_DATE_FINAL="offer_date_final";

    public static final String TABLE_EVENT = "event";
    public static final String EVENT_ID = "event_id";
    public static final String EVENT_NAME = "event_name";
    public static final String EVENT_URL_PHOTO = "event_url_photo";
    public static final String EVENT_DESCRIPTION = "event_description";
    public static final String EVENT_DATE="event_date";
    public static final String EVENT_DAYS="event_days";

    public static final String TABLE_NOTIFICATION = "notification";
    public static final String NOTIFICATION_ID = "notification_id";
    public static final String NOTIFICATION_NAME = "notification_name";
    public static final String NOTIFICATION_URL_PHOTO = "notification_url_photo";
    public static final String NOTIFICATION_DESCRIPTION = "notification_description";
    public static final String NOTIFICATION_DATE="notification_date";


    private static final String SQL_CREATE_CATEGORY = "create table " +
            TABLE_CATEGORY + "(" +
            CATEGORY_ID + " integer primary key autoincrement, " +
            CATEGORY_NAME + " text not null, " +
            CATEGORY_DESCRIPTION + " text);";

    private static final String SQL_CREATE_STORE = "create table " +
            TABLE_STORE + "(" +
            STORE_ID + " integer primary key autoincrement, " +
            STORE_UBICATION + " text not null, " +
            STORE_DESCRIPTION + " text not null, " +
            STORE_NAME + " text not null, " +
            STORE_HOURS + " text not null, " +
            STORE_TELEPHONE + " text, " +
            STORE_WEBPAGE + " text, " +
            STORE_URL_LOGO + " text, " +
            STORE_CATEGORY_ID+ " integer not null, "+
            "FOREIGN KEY ("+STORE_CATEGORY_ID+") REFERENCES "+TABLE_CATEGORY+" ("+CATEGORY_ID+"));";

    private static final String SQL_CREATE_OFFER = "create table " +
            TABLE_OFFER + "(" +
            OFFER_ID + " integer primary key autoincrement, " +
            OFFER_DESCRIPTION + " text not null, " +
            OFFER_DATE_INITIAL + " date, " +
            OFFER_DATE_FINAL + " date, " +
            OFFER_URL_PHOTO + " text, " +
            OFFER_STORE_ID+ " integer not null, "+
            "FOREIGN KEY ("+OFFER_STORE_ID+") REFERENCES "+TABLE_STORE+" ("+STORE_ID+"));";

    private static final String SQL_CREATE_EVENT = "create table " +
            TABLE_EVENT + "(" +
            EVENT_ID + " integer primary key autoincrement, " +
            EVENT_NAME + " text not null, " +
            EVENT_DESCRIPTION + " text not null, " +
            EVENT_URL_PHOTO + " text, " +
            EVENT_DATE + " date, " +
            EVENT_DAYS + " text);";

    private static final String SQL_CREATE_NOTIFICATION = "create table " +
            TABLE_NOTIFICATION + "(" +
            NOTIFICATION_ID + " integer primary key autoincrement, " +
            NOTIFICATION_NAME + " text not null, " +
            NOTIFICATION_DESCRIPTION + " text not null, " +
            NOTIFICATION_DATE + " date not null, " +
            NOTIFICATION_URL_PHOTO + " text);";

    public static final String TABLE_PQRS="PQRS";
    public static final String PQRS_ID="PQRS_id";
    public static final String PQRS_TYPE="PQRS_type";
    public static final String PQRS_STATE="PQRS_state";
    public static final String PQRS_REQUEST="PQRS_request";
    public static final String PQRS_RESPONSE="PQRS_response";
    public static final String PQRS_DATE_REQUEST="PQRS_date_request";
    public static final String PQRS_DATE_RESPONSE="PQRS_date_response";

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

        /*sqLiteDatabase.execSQL(SQL_CREATE_CATEGORY);
        System.out.println("tabla categoria creada");
        sqLiteDatabase.execSQL(SQL_CREATE_STORE);
        System.out.println("tabla tienda creada");
        sqLiteDatabase.execSQL(SQL_CREATE_OFFER);
        System.out.println("tabla ofeta creada");
        sqLiteDatabase.execSQL(SQL_CREATE_EVENT);
        System.out.println("tabla evento creada");
        sqLiteDatabase.execSQL(SQL_CREATE_NOTIFICATION);
        System.out.println("tabla notificacion creada");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void listPertaintoCategoryList(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {"id", PERTAIN_STORE_ID, PERTAIN_CATEGORY_ID};
        List<PertaintoCategory> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_PERTAIN_CATEGORY, projection, null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    Long nit = cursor.getLong(cursor.getColumnIndex(PERTAIN_STORE_ID));
                    Long name = cursor.getLong(cursor.getColumnIndex(PERTAIN_CATEGORY_ID));
                    System.out.println("storeid= "+nit+"categoryid= "+name);
                    cursor.moveToNext();

                }
            }
        }
        db.close();
    }
}
