package com.softianstech.androidtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.softianstech.androidtutorial.SqliteDatabaseRegistration.activities.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView sqlite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlite= (TextView) findViewById(R.id.sqlite);

        sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
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
