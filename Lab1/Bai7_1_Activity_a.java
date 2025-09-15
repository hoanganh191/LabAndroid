package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai7_1_Activity_a extends AppCompatActivity {

    EditText edt_a, edt_b;
    Button btnGiai, btnXoa;
    TextView txtKetQua;

    private static final int REQUEST_CODE_PTBN = 1411;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Đảm bảo R.layout.activity_bai7_1_a là tên layout XML chính xác của bạn
        setContentView(R.layout.activity_bai7_1_a);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("GPTBN - Màn hình 1");
        }

        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        btnGiai = findViewById(R.id.btnGiai);
        btnXoa = findViewById(R.id.btnXoa);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_a.setText("");
                edt_b.setText("");
                txtKetQua.setText("");
            }
        });

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA = edt_a.getText().toString().trim();
                String strB = edt_b.getText().toString().trim();

                if (strA.isEmpty() || strB.isEmpty()) {
                    Toast.makeText(Bai7_1_Activity_a.this, "Vui lòng nhập đủ hệ số a và b", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(Bai7_1_Activity_a.this, Bai7_1_Activity_b.class);
                intent.putExtra("soA", strA);
                intent.putExtra("soB", strB);
                startActivityForResult(intent, REQUEST_CODE_PTBN);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_PTBN && resultCode == RESULT_OK && data != null) {
            txtKetQua.setText(data.getStringExtra("phanHoi"));
        }
    }
}
