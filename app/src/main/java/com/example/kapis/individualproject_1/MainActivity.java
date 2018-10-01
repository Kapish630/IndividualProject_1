package com.example.kapis.individualproject_1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // variable to control time for splach screen in milliseconds
    public static int splash_time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // switching to the MainActivity 2 page after 3 seconds for splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent homeIntent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }, splash_time);


        }

    }


