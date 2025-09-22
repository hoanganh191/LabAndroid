package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai8_1_a_Activity extends AppCompatActivity {
    EditText edtHoten, edtQuequan;
    RadioButton rbNam, rbNu;
    Button btnThem, btnInDS;

    ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8_1_a);
        edtHoten = findViewById(R.id.edtHoten);
        edtQuequan = findViewById(R.id.edtQueQuan);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        btnThem = findViewById(R.id.btnThem);
        btnInDS = findViewById(R.id.btnInDS);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nv = new NhanVien();
                nv.setHoten(edtHoten.getText().toString());
                nv.setQuequan(edtQuequan.getText().toString());
                if(rbNu.isChecked()) nv.setGioitinh(false);
                dsNhanVien.add(nv);
                Toast.makeText(Bai8_1_a_Activity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });
        btnInDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai8_1_a_Activity.this, Bai8_1_b_Activity.class);
                intent.putExtra("dsNhanVien", dsNhanVien);
                startActivity(intent);
            }
        });
    }
}
