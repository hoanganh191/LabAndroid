package com.example.lab01;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai9_b_Activity extends AppCompatActivity {
    ImageView imgSinhVien;
    TextView tvHoTen, tvGioiTinh, tvVanBang, tvMoTa;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai9_b);
        mapping();
        SinhVien sv = (SinhVien) getIntent().getSerializableExtra("thongTin");
        if (sv == null) {
            Toast.makeText(Bai9_b_Activity.this, "Lỗi", Toast.LENGTH_SHORT).show();
            return;
        }
        imgSinhVien.setImageURI(Uri.parse(sv.getImageUri()));
        tvHoTen.setText("Họ Tên: " + sv.getHoTen());
        if (sv.gioiTinh){
            tvGioiTinh.setText("Giới Tính: Nam");
        }else {
            tvGioiTinh.setText("Giới Tính: Nữ");
        }
        if (sv.vanBang){
            tvVanBang.setText("Văn Bằng: Có");
        }
        tvMoTa.setText("Mô tả: " + sv.getMoTa());
    }

    private void mapping() {
        imgSinhVien = findViewById(R.id.imgSinhVien);
        tvHoTen = findViewById(R.id.tvHoTen);
        tvGioiTinh = findViewById(R.id.tvGioiTinh);
        tvVanBang = findViewById(R.id.tvVanBang);
        tvMoTa = findViewById(R.id.tvMoTa);
    }
}
