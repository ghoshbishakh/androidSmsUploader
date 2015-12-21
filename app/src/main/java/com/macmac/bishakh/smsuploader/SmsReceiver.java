package com.macmac.bishakh.smsuploader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.provider.Telephony.Sms.Intents.getMessagesFromIntent;


public class SmsReceiver extends BroadcastReceiver {
    private static final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {

        String address, contactId,str = "";
        String action = intent.getAction();

        if(action.equals(ACTION_SMS_RECEIVED)){
            SmsMessage[] msgs = getMessagesFromIntent(intent);
            if (msgs != null) {
                //Toast toast = Toast.makeText(context, msgs.toString(), Toast.LENGTH_SHORT);
                //toast.show();
                Log.v("MSGARRAY", msgs.toString());

                for (int i = 0; i < msgs.length; i++) {
                    String msgBody = msgs[i].getDisplayMessageBody();
                    String num = msgs[i].getOriginatingAddress();
                    Log.v("MSG_BODY", msgBody);
                    Log.v("MSG_FROM", num);
                    long t = msgs[i].getTimestampMillis();
                    String dateTime = getDate(t, "dd/MM/yyyy hh:mm:ss");
                    Log.v("MSG_TIME", dateTime);
                    MainActivity.saveSms(msgBody, num, dateTime,context);

                }

            }
        }
    }




    public static String getDate(long milliSeconds, String dateFormat)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}