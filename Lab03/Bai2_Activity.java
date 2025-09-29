package com.example.lab03;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai2_Activity extends AppCompatActivity {
    GridView gvSanPham;
    Adapter_Bai2 adapter;
    List<SanPham2> dsSanPham;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        gvSanPham = findViewById(R.id.gvSanPham);
        dsSanPham = new ArrayList<>();
        dsSanPham.add(new SanPham2("Máy Sinh Tố", 40, R.drawable.sinhto));
        dsSanPham.add(new SanPham2("Máy Rửa Bát", 60, R.drawable.ruabat));
        dsSanPham.add(new SanPham2("Máy Giặt", 30, R.drawable.maygiat));
        adapter = new Adapter_Bai2(this, R.layout.adapter_bai2, dsSanPham);
        gvSanPham.setAdapter(adapter);
    }
}
