package com.example.rentacar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main9Activity extends AppCompatActivity implements View.OnClickListener,SmsListener {
    Button proceed;
    NotificationManager manager;

    Notification myNotification;
    int notifyID =1;
    MyOTPReceiver broadcastReceiver;
    public static final String OTP_REGEX = "[0-9]{1,6}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        proceed=findViewById(R.id.proceed);
        proceed.setOnClickListener(this);
        proceed=findViewById(R.id.proceed);
        proceed.setOnClickListener(this);
        broadcastReceiver = new MyOTPReceiver();
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,Main11Activity.class);
        startActivity(intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String channel_Id = "my_channel_01";// The id of the channel.
            CharSequence channelName = "NotifChannel";// The user-visible name of the channel.
            int channelImportance = NotificationManager.IMPORTANCE_HIGH;

            manager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            // Create a notification and set the notification channel.
            NotificationChannel channel = new NotificationChannel(channel_Id, channelName,
                    channelImportance);
            manager.createNotificationChannel(channel);

            //Create the intent that’ll fire when the user taps the notification//
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
            //PendingIntent.FLAG_UPDATE_CURRENT - Flag indicating that if the described PendingIntent already exists,
            // then keep it but replace its extra data with what is in this new Intent.
            PendingIntent pendingIntent = PendingIntent.getActivity(Main9Activity.this, 1,
                    intent1, PendingIntent.FLAG_UPDATE_CURRENT);

            myNotification  = new Notification.Builder(Main9Activity.this,channel_Id)
                    .setContentTitle("New Message")
                    //.setAutoCancel(true)
                    .setOngoing(true)
                    .setContentText("You have booked the car")
                    .setSmallIcon(R.drawable.notif_icon)
                    .setContentIntent(pendingIntent)
                    .build();

            manager.notify(notifyID, myNotification);
        }
        else{
            Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
            //PendingIntent.FLAG_UPDATE_CURRENT - Flag indicating that if the described PendingIntent already exists,
            // then keep it but replace its extra data with what is in this new Intent.
            PendingIntent pendingIntent = PendingIntent.getActivity(Main9Activity.this, 1,
                    intent2, PendingIntent.FLAG_UPDATE_CURRENT);

            Notification.Builder builder = new Notification.Builder(Main9Activity.this);
            builder.setAutoCancel(true);
            builder.setContentTitle("App Notification");
            builder.setContentText("You have a new message");
            builder.setSmallIcon(R.drawable.notif_icon);
            builder.setContentIntent(pendingIntent);
            builder.setOngoing(true);
            builder.setSubText("This is subtext...");   //API level 16
            //builder.setNumber(100);
            myNotification= builder.build();
            //  myNotication = builder.getNotification();
            // myNotication.flags = Notification.FLAG_AUTO_CANCEL;
            manager.notify(notifyID,myNotification);
        }}
    private static Main9Activity instance;
    @Override
    protected void onStart() { // onStart() of your activity
        super.onStart();
        instance = this;

       /*This is required to register broadcast
       instead of adding the action in manifest file
        */
        IntentFilter intentFilter=new IntentFilter
                ("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(broadcastReceiver,intentFilter);
    }
    public static Main9Activity getInstance(){
        return instance;
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    public void messageReceived(String messageText) {

        //From the received text string you
        // may do string operations to get the required OTP
        //It depends on your SMS format

        // If your OTP is six digits number
        // you may use the below code

        Pattern pattern = Pattern.compile(OTP_REGEX);
        Matcher matcher = pattern.matcher(messageText);
        String otp = "XXXXX";
        while (matcher.find())
        {
            otp = matcher.group();
        }

        Toast.makeText(Main9Activity.this,"OTP: "+ otp ,
                Toast.LENGTH_LONG).show();


    }
}