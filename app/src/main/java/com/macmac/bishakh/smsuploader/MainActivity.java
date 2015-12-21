package com.macmac.bishakh.smsuploader;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import android.database.sqlite.*;
import com.macmac.bishakh.smsuploader.SmsReceiver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.provider.Telephony.Sms.Intents.getMessagesFromIntent;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    public static SmsSaver mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new SmsSaver(getApplicationContext());

        Toast toast = Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_SHORT);
        toast.show();
    }


    public static boolean saveSms(String message, String number, String datetime, Context context){
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SmsSaverContract.FeedEntry.COLUMN_NAME_MESSAGE, message);
        values.put(SmsSaverContract.FeedEntry.COLUMN_NAME_NUMBER, number);
        values.put(SmsSaverContract.FeedEntry.COLUMN_NAME_DATE_TIME, datetime);

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                SmsSaverContract.FeedEntry.TABLE_NAME,
                SmsSaverContract.FeedEntry.COLUMN_NAME_NULLABLE,
                values);
        //Toast t = Toast.makeText(context, ""+newRowId, Toast.LENGTH_LONG);
        //t.show();
        Log.v("DB_ENTRY", ""+newRowId);
        return true;
    }
}







