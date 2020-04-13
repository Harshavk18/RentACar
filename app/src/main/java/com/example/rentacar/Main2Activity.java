package com.example.rentacar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2;
    Button b1;
    TextView tv;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText);
        tv = findViewById(R.id.textView1);
        b1 = findViewById(R.id.button4);
        b1.setOnClickListener(this);
        db = openOrCreateDatabase
                ("Users", Context.MODE_PRIVATE, null);

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==b1.getId()) {
            Cursor c = db.rawQuery("SELECT *" +
                    " FROM Users WHERE username='" + et1.getText() + "' AND password='"+et2.getText() + "'", null);
           /* Cursor d = db.rawQuery("SELECT *" +
                    " FROM Users WHERE password='" + et2.getText() + "'", null);*/
           /* if (c.moveToFirst() ) {
                if( d.moveToFirst()) {
                    SharedPreferences sp =
                            getSharedPreferences
                                    ("mycredentials",
                                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit =
                            sp.edit();
                    edit.putString
                            ("name",et1.getText().toString());
                    edit.commit();
                    Toast.makeText(this, "Data Saved in Shared Preference",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this,Main3Activity.class);
                    startActivity(intent);
                }
            }*/
           if(c.getCount()>=1){
               /*Toast.makeText(this, "Data Saved in Shared Preference",
                       Toast.LENGTH_SHORT).show();*/
               Intent intent = new Intent(this,Main4Activity.class);
               startActivity(intent);
           }
            else
            {
                showMessage("Error", "Invalid password");
                et2.setText("");
            }
            clearText();

        }
    }

    private void clearText() {
        et1.setText("");
        et2.setText("");
    }

    private void showMessage(String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
