package com.example.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    AutoCompleteTextView tv;
    String[] language ={"Hyderabad","Chennai","Mumbai","Coimbatore","'Banglore","Goa","Pune",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b1=findViewById(R.id.button3);
        b1.setOnClickListener(this);
        tv=findViewById(R.id.act);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,language);
        tv.setThreshold(1);
        tv.setAdapter(adapter);
        tv.setTextColor(Color.BLUE);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,Main5Activity.class);
        startActivity(i);

    }
}