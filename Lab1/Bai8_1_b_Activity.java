package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai8_1_b_Activity extends AppCompatActivity {
    ListView lvNhanVien;
    ArrayList<NhanVien> dsNhanVien;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8_1_b);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Danh sách nhân viên");
        }
        lvNhanVien = findViewById(R.id.lvNhanVien);
        Intent intent = getIntent();
        dsNhanVien = (ArrayList<NhanVien>) intent.getSerializableExtra("dsNhanVien");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dsNhanVien);
        lvNhanVien.setAdapter(adapter);

    }
}
