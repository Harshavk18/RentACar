package com.example.rentacar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b;
    ImageView i1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.button);
        b.setOnClickListener(this);
        i1=findViewById(R.id.iv1);
        b2=findViewById(R.id.button1);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==b.getId()) {
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);
        }
        if(v.getId()==b2.getId())
        {
            Intent intent = new Intent(this,Main3Activity.class);
            startActivity(intent);
        }
    }
}
