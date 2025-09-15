package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai7_1_Activity_b extends AppCompatActivity {
    TextView txtMess;
    Button btnQuayLai;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_bai7_1_b);
        txtMess = findViewById(R.id.txtMess);
        btnQuayLai = findViewById(R.id.btnQuayLai);
        Intent intent = getIntent();
        float a = intent.getFloatExtra("soA", 0);
        float b = intent.getFloatExtra("soB", 0);
        String thongBaoKq = "";
        if (a == 0) {
            if (b == 0) {
                txtMess.setText("Phương trình vô số nghiệm"); // Để Bai7_1_Activity_a hiển thị
                thongBaoKq = "Phương trình vô số nghiệm";
            } else {
                txtMess.setText("Phương trình vô nghiệm"); // Để Bai7_1_Activity_a hiển thị
                thongBaoKq = "Phương trình vô nghiệm";
            }
        } else {
            txtMess.setText("Phương trình có nghiệm x = " + (-b / a)); // Để Bai7_1_Activity_a hiển thị
            thongBaoKq = String.format("Phương trình có nghiệm x = %.2f", (-b / a));
        }

        // Hiển thị thông báo kết quả lên TextView của Activity này nếu muốn
        txtMess.setText(thongBaoKq);

        final String ketQuaDeGui = thongBaoKq; // Tạo biến final

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPhanHoi = new Intent();
                intentPhanHoi.putExtra("phanHoi", ketQuaDeGui); // Sử dụng biến final
                setResult(RESULT_OK, intentPhanHoi);      // THÊM DÒNG NÀY để trả kết quả
                finish();
            }
        });
    }
}
