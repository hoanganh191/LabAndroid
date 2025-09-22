package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai9_a_Activity extends AppCompatActivity {
    EditText edtHoten, edtThongTin;
    RadioButton rbNam, rbNu;
    CheckBox ckVanBang2;
    ImageView imgSinhVien;
    Button btnXemTT, btnHuy;

    SinhVien sv;


    private static final int maLayAnh = 1;
    String uriAnh = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai9_a);
        mapping();
        imgSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, maLayAnh);
            }
        });

        btnXemTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoten.getText().toString().trim();
                String moTa = edtThongTin.getText().toString().trim();

                if (hoten.isEmpty() || moTa.isEmpty()) {
                    Toast.makeText(Bai9_a_Activity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean gioitinh = true;
                if (rbNu.isChecked()) {
                    gioitinh = false;
                }

                boolean vanbang = false;
                if (ckVanBang2.isChecked()) {
                    vanbang = true;
                }

                if (uriAnh == null) {
                    Toast.makeText(Bai9_a_Activity.this, "Vui lòng chọn ảnh", Toast.LENGTH_SHORT).show();
                    return;
                }

                sv = new SinhVien(hoten, moTa, gioitinh, vanbang, uriAnh);
                Intent intent = new Intent(Bai9_a_Activity.this, Bai9_b_Activity.class);
                intent.putExtra("thongTin",sv);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == maLayAnh && resultCode == RESULT_OK && data != null) {
            imgSinhVien.setImageURI(data.getData());
            uriAnh = data.getData().toString();
        }
    }

    private void mapping() {
        edtHoten = findViewById(R.id.edtHoten);
        edtThongTin = findViewById(R.id.edtThongTin);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        ckVanBang2 = findViewById(R.id.ckVanBang2);
        imgSinhVien = findViewById(R.id.imgSinhVien);
        btnXemTT = findViewById(R.id.btnXemTT);
        btnHuy = findViewById(R.id.btnHuy);
    }

}
