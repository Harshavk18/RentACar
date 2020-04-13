package com.example.rentacar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.AlertDialog;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener {

    Button b;
    TextView city;
    EditText pd,dd;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        b=findViewById(R.id.carbutton1);
        b.setOnClickListener(this);
        city=findViewById(R.id.city);
        pd=findViewById(R.id.pdate);
        dd=findViewById(R.id.ddate);
        SharedPreferences sp =
                getSharedPreferences
                        ("mycredentials",
                                Context.MODE_PRIVATE);
        String name = sp.getString
                ("name","NA");

        city.setText(name);
        db = openOrCreateDatabase
                ("Booking", Context.MODE_PRIVATE, null);
        db.execSQL
                ("CREATE TABLE IF NOT EXISTS " +
                        "Booking(pickup DATE," +
                        "dropdate DATE);");

    }

    @Override
    public void onClick(View v) {
        if (pd.getText().toString().trim().length() == 0 ||
                dd.getText().toString().trim().length() == 0 ) {
            showMessage("Error", "Please enter all values");
            return;
        }
        // Inserting record

        db.execSQL("INSERT INTO Booking VALUES('" + pd.getText() +
                "','" + dd.getText() + "');");
        showMessage("Success", "Record added");
        clearText();
        Intent i =new Intent(Main5Activity.this,Main7Activity.class);
        startActivity(i);
    }

    private void clearText() {
        pd.setText("" );
        dd.setText("");
    }

    private void showMessage(String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }


  /*  public void onButtonClicked(View view) {
        DialogFragment newFragment = new datefragment();
        newFragment.show(getFragmentManager(),"Date Picker");
    }*/
}