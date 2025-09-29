package com.example.lab03;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai1_Activity extends AppCompatActivity {
    ListView lvSanPham;
    List<SanPham> dsSanPham;
    Adapter_Bai1 adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        lvSanPham = findViewById(R.id.lvSanPham);
        dsSanPham = new ArrayList<>();
        dsSanPham.add(new SanPham("Máy xay sinh tố", "Máy xay sinh tố nhập khẩu từ Đức", 40, R.drawable.sinhto));
        dsSanPham.add(new SanPham("Máy Rửa bát", "Máy Rửa bát nội địa", 60, R.drawable.ruabat));
        dsSanPham.add(new SanPham("Máy Giặt", "Máy Giặt nội địa", 30, R.drawable.maygiat));
        adapter = new Adapter_Bai1(this, R.layout.adapter_bai1, dsSanPham);
        lvSanPham.setAdapter(adapter);
    }
}
