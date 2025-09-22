package com.example.lab01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Bai1_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        if (getSupportActionBar() != null) {
           getSupportActionBar().setTitle("Bai 1 ne");
        }
    }
}
