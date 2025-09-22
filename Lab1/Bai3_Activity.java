package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai3_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        CheckBox ckbNam = findViewById(R.id.ckbNam);
        CheckBox ckbNu = findViewById(R.id.ckbNu);
        CheckBox ckbKhac = findViewById(R.id.ckbKhac);
        Button btnKiemTra = findViewById(R.id.btnKiemTra);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Bai 3 ne");
        }
        List<String> daChon = new ArrayList<>();
        if (ckbNam.isChecked()) daChon.add("Nam");
        if (ckbNu.isChecked()) daChon.add("Nữ");
        if (ckbKhac.isChecked()) daChon.add("Khác");
        String thongbao;
        if (daChon.size() == 0) {
            thongbao = "Bạn chọn giới tính";
        } else if (daChon.size() == 1) {
            thongbao = "Bạn chọn giới tính là " + daChon.get(0);
        } else if (daChon.size() == 2) {
            thongbao = "Bạn chọn giới tính là " + daChon.get(0) + " và " + daChon.get(1);
        } else {
            thongbao = "Bạn chọn giới tính là " + daChon.get(0) + ", " + daChon.get(1) + " và " + daChon.get(2);
        }

        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Bai3_Activity.this, thongbao, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
