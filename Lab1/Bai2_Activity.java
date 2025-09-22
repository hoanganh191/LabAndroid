package com.example.lab01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Bai2_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

//        Dùng lệnh dưới để đổi tiêu đề
        if (getSupportActionBar() != null) {
           getSupportActionBar().setTitle("Bai 2 ne"); //Cậu thay tiêu đề ở đoạn này nhé
        }
    }
}
