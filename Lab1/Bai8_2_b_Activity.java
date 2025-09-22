package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai8_2_b_Activity extends AppCompatActivity {
    List<NhanVien2> dsNhanVien;
    Adapter_8_2 adapter;
    ListView lvNhanVien;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8_2_b);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Danh sách nhân viên");
        }
        lvNhanVien = findViewById(R.id.lvNhanVien);
        Intent intent = getIntent();
        dsNhanVien = (List<NhanVien2>) intent.getSerializableExtra("dsNhanVien");
        adapter = new Adapter_8_2(Bai8_2_b_Activity.this,R.layout.adapter_bai8_2_b,dsNhanVien);
        lvNhanVien.setAdapter(adapter);
    }
}
