package com.macmac.bishakh.smsuploader;

import android.provider.BaseColumns;

/**
 * Created by bishakh on 12/21/15.
 */
public final class SmsSaverContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public SmsSaverContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "smsTable";
        public static final String COLUMN_NAME_NUMBER = "number";
        public static final String COLUMN_NAME_MESSAGE = "message";
        public static final String COLUMN_NAME_DATE_TIME = "datetime";
        public static final String COLUMN_NAME_NULLABLE = "message";
    }
}
