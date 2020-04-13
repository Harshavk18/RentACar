package com.example.rentacar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    SQLiteDatabase db;
    EditText email, uname, pass, repass;

    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b1 = findViewById(R.id.sun1);
        b1.setOnClickListener(this);

        mImageView = findViewById(R.id.ImageView);;

        email = findViewById(R.id.et1);
        uname = findViewById(R.id.et2);
        pass = findViewById(R.id.et3);
        repass = findViewById(R.id.et4);
        db = openOrCreateDatabase
                ("Users",Context.MODE_PRIVATE,null);
        db.execSQL
                ("CREATE TABLE IF NOT EXISTS " +
                        "Users(email VARCHAR," +
                        "username VARCHAR,password VARCHAR);");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == b1.getId()) {

            if (email.getText().toString().trim().length() == 0 ||
                    uname.getText().toString().trim().length() == 0 ||
                    pass.getText().toString().trim().length() == 0 ||
                    repass.getText().toString().trim().length() == 0) {
                showMessage("Error","Please enter all values");
                return;
            }
            else if(repass.getText()==pass.getText())
            {
                showMessage("Error","password doesnt match");
                pass.setText("");
                repass.setText("" );
                return;
            }
            else{
                db.execSQL("INSERT INTO Users VALUES('" + email.getText() + "','" + uname.getText() +
                        "','" + pass.getText() + "');");
                showMessage("Success", "Record added");
                clearText();
            }

        }
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }



    private void clearText() {

        email.setText("");
        uname.setText("");
        pass.setText("");
        repass.setText("");

    }



    private void showMessage(String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();


    }
}
