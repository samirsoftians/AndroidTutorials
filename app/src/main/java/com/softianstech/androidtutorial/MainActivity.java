package com.softianstech.androidtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.softianstech.androidtutorial.SqliteDatabaseRegistration.activities.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView sqlite,recyclerview,RetriveRetro,insertretro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlite= (TextView) findViewById(R.id.sqlite);
        recyclerview=(TextView) findViewById(R.id.reycler);
        RetriveRetro=(TextView) findViewById(R.id.RetriveRetro);
        insertretro=(TextView) findViewById(R.id.insertretro);

        insertretro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, com.softianstech.androidtutorial.InsertRetro.MainActivity.class);
                startActivity(intent);

            }
        });


        sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });


        recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, com.softianstech.androidtutorial.RecyclerView.MainActivity.class);
                startActivity(intent);

            }
        });


        RetriveRetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, com.softianstech.androidtutorial.RetriveRetroDemo.MainActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sqlite:
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

                break;
//            case R.id.textViewLinkRegister:
//                // Navigate to RegisterActivity
//                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
//                startActivity(intentRegister);
//                break;
        }
    }
}
