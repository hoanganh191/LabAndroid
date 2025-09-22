package com.example.lab01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable; // Thêm import này
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai8_2_a_Activity extends AppCompatActivity {
    EditText edtHoten, edtQuequan;
    RadioButton rbNam, rbNu;
    Button btnThem, btnInDS;
    ImageView imgNhanVien;
    List<NhanVien2> dsNhanVien;

    String uriAnh = null;


    private static final int PICK_IMAGE_REQUEST = 1; // Thêm: Mã yêu cầu chọn ảnh

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai8_2_a);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Thêm nhân viên");
        }
        edtHoten = findViewById(R.id.edtHoten);
        edtQuequan = findViewById(R.id.edtQueQuan);
        rbNam = findViewById(R.id.rbNam);
        rbNu = findViewById(R.id.rbNu);
        btnThem = findViewById(R.id.btnThem);
        btnInDS = findViewById(R.id.btnInDS);
        imgNhanVien = findViewById(R.id.imgNhanVien);
        dsNhanVien = new ArrayList<>();


        imgNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST); // Thay đổi: Gọi startActivityForResult
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edtHoten.getText().toString();
                String quequan = edtQuequan.getText().toString();
                boolean gioiTinh = rbNam.isChecked();


                if (hoten.isEmpty() || quequan.isEmpty()) {
                    Toast.makeText(Bai8_2_a_Activity.this, "Vui lòng nhập đủ họ tên và quê quán!", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                if (uriAnh == null) {
                    Toast.makeText(Bai8_2_a_Activity.this, "Vui lòng chọn hình ảnh!", Toast.LENGTH_SHORT).show();
                    return;
                }

                NhanVien2 nv = new NhanVien2(hoten, quequan, gioiTinh, uriAnh);
                dsNhanVien.add(nv);
                Toast.makeText(Bai8_2_a_Activity.this, "Thêm nhân viên thành công!", Toast.LENGTH_SHORT).show();
                //Reset lại các mục nhập dữ liệu
                edtHoten.setText("");
                edtQuequan.setText("");
                rbNam.setChecked(true);
                imgNhanVien.setImageResource(R.drawable.koanh);
                uriAnh = null;
                edtHoten.requestFocus();
            }
        });
        btnInDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bai8_2_a_Activity.this, Bai8_2_b_Activity.class);
                intent.putExtra("dsNhanVien", (ArrayList<NhanVien2>) dsNhanVien);
                startActivity(intent);
            }
        });
    }

    // Thêm phương thức onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null ) {
            uriAnh = data.getData().toString();
            if (uriAnh != null) {
                imgNhanVien.setImageURI(Uri.parse(uriAnh));
            }
        }
    }
}
