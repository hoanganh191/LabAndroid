package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai7_Activity extends AppCompatActivity {
    EditText edt_a, edt_b;
    Button btnGiai, btnXoa;
    TextView txtKetQua;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("GPTBN");
        }
        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        btnGiai = findViewById(R.id.btnGiai);
        btnXoa = findViewById(R.id.btnXoa);
        txtKetQua = findViewById(R.id.txtKetQua);
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Integer.parseInt(edt_a.getText().toString());
                float b = Integer.parseInt(edt_b.getText().toString());
                if (a == 0) {
                    if (b == 0) {
                        txtKetQua.setText("Phương trình vô số nghiệm");
                    } else { // b khac 0
                        txtKetQua.setText("Phương trình vô nghiệm");
                    }
                } else {
                    txtKetQua.setText("Phương trình có nghiệm x = " + (-b / a));
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_a.setText("");
                edt_b.setText("");
                txtKetQua.setText("");
                Toast.makeText(Bai7_Activity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
