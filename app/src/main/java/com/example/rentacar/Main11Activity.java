package com.example.rentacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main11Activity extends AppCompatActivity implements View.OnClickListener {
    Button call,gps;
    TextView pno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        call=findViewById(R.id.call1);
        pno=findViewById(R.id.pno1);
        call.setOnClickListener(this);
        gps=findViewById(R.id.gps1);
        gps.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if(v.getId()==call.getId()) {
            String phonenumber;
            phonenumber = pno.getText().toString();
            Intent i = new Intent
                    (Intent.ACTION_CALL);
            i.setData
                    (Uri.parse("tel:" + phonenumber));
            // The below if condition will be auto
            // suggessted if not given.
            if (ActivityCompat.checkSelfPermission
                    (this,Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {// add the following line for runtime permission request
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        123);
                return;

            }
            startActivity(i);
        }
        if(v.getId()==gps.getId())
        {
            Intent intent = new Intent(this,MapsActivity.class);
            startActivity(intent);
        }



    }
}