package com.example.rentacar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;

public class MyOTPReceiver extends BroadcastReceiver {

    SmsListener mListener;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle  = intent.getExtras();
        SmsMessage smsMessage;

        if (Build.VERSION.SDK_INT >= 19) { //KITKAT
            SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            smsMessage = msgs[0];
        } else {
            Object pdus[] = (Object[]) bundle.get("pdus");
            smsMessage = SmsMessage.createFromPdu((byte[]) pdus[0]);
        }
        String messageBody = smsMessage.getMessageBody();
        //Pass the message text to interface
        mListener = Main8Activity.getInstance();
        mListener = Main9Activity.getInstance();
        mListener = Main10Activity.getInstance();
        mListener.messageReceived(messageBody);
    }


}