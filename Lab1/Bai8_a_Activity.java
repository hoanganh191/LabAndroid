package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai8_a_Activity extends AppCompatActivity {
    EditText edtHoten, edtQuequan;
    RadioButton rbNam, rbNu;
    Button btnThem, btnInDS;
    List<String> arrKq = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8_a);
        edtHoten = findViewById(R.id.edtHoten);
        edtQuequan = findViewById(R.id.edtQueQuan);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        btnThem = findViewById(R.id.btnThem);
        btnInDS = findViewById(R.id.btnInDS);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq = "";
                String hoten = edtHoten.getText().toString();
                String quequan = edtQuequan.getText().toString();
                boolean gioiTinh;
                if (rbNam.isChecked()) {
                    kq = "Họ tên: " + hoten + " - Quê quán: " + quequan + " - Giới tính: Nam";
                } else {
                    kq = "Họ tên: " + hoten + " - Quê quán: " + quequan + " - Giới tính: Nữ";
                }

                arrKq.add(kq);
                Toast.makeText(Bai8_a_Activity.this, "Them duoc r", Toast.LENGTH_SHORT).show();

            }
        });

        btnInDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai8_a_Activity.this, Bai8_b_Activity.class);
                intent.putStringArrayListExtra("kq", (ArrayList<String>) arrKq);
                startActivity(intent);
            }
        });

    }


}
