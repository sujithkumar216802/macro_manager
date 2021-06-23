package com.example.macromanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceintent = new Intent(MainActivity.this, service.class);
        startService(serviceintent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}