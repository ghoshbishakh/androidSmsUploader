package com.macmac.bishakh.smsuploader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SmsSaver extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SmsSaverContract.FeedEntry.TABLE_NAME + " (" +
                    SmsSaverContract.FeedEntry._ID + " INTEGER PRIMARY KEY ," +
                    SmsSaverContract.FeedEntry.COLUMN_NAME_NUMBER + " varchar(60)," +
                    SmsSaverContract.FeedEntry.COLUMN_NAME_MESSAGE + " text," +
                    SmsSaverContract.FeedEntry.COLUMN_NAME_DATE_TIME + " datetime)";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SmsSaverContract.FeedEntry.TABLE_NAME;


    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SmsSaver.db";

    public SmsSaver(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}