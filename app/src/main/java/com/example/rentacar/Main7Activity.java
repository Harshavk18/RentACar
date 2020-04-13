package com.example.rentacar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main7Activity extends AppCompatActivity implements View.OnClickListener {
    Button micro,mini,xuv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
      micro=findViewById(R.id.micro1);
        mini=findViewById(R.id.mini1);
        xuv=findViewById(R.id.xuv1);
        micro.setOnClickListener(this);
        mini.setOnClickListener(this);
        xuv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==micro.getId()){
            Intent intent=new Intent(this,Main8Activity.class);
            startActivity(intent);
        }
        if(v.getId()==mini.getId()){
            Intent intent=new Intent(this,Main9Activity.class);
            startActivity(intent);
        }
        if(v.getId()==xuv.getId()){
            Intent intent=new Intent(this,Main10Activity.class);
            startActivity(intent);
        }

    }
}