package com.example.lab02;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai1_Activity extends AppCompatActivity {
    EditText edtTenNgonNgu;
    Button btnThem, btnSua;
    ListView lvNgonNgu;
    List<String> dsNgonNgu = new ArrayList<>();
    ArrayAdapter adapter;

    int viTriChon = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("BaseListReview");
        }
        edtTenNgonNgu = findViewById(R.id.edtTenNgonNgu);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        lvNgonNgu = findViewById(R.id.lvNgonNgu);
        dsNgonNgu.add("Android");
        dsNgonNgu.add("PHP");
        dsNgonNgu.add("NodeJS");
        dsNgonNgu.add("Javascript");
        dsNgonNgu.add("Java");
        dsNgonNgu.add("C#");
        adapter = new ArrayAdapter(Bai1_Activity.this, android.R.layout.simple_list_item_1, dsNgonNgu);
        lvNgonNgu.setAdapter(adapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kqNhap = edtTenNgonNgu.getText().toString().trim();
                if (kqNhap.isEmpty()) {
                    Toast.makeText(Bai1_Activity.this, "Vui lòng nhập tên ngôn ngữ", Toast.LENGTH_SHORT).show();
                    return;
                }
                dsNgonNgu.add(kqNhap);
                adapter.notifyDataSetChanged();
                Toast.makeText(Bai1_Activity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                edtTenNgonNgu.setText("");
            }
        });

        lvNgonNgu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ngonNguChon = dsNgonNgu.get(position);
                edtTenNgonNgu.setText(ngonNguChon);
                viTriChon = position;
            }
        });

        lvNgonNgu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(Bai1_Activity.this).setTitle("Cảnh báo").setMessage("Bạn thực muốn xoá").setPositiveButton("Xoá", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dsNgonNgu.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(Bai1_Activity.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Huỷ", null).show();


                return true;
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenMoi = edtTenNgonNgu.getText().toString().trim();
                if (viTriChon == -1) {
                    Toast.makeText(Bai1_Activity.this, "Vui lòng chọn đúng vị trí", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (tenMoi.isEmpty()) {
                    Toast.makeText(Bai1_Activity.this, "Vui lòng nhập tên ngôn ngữ", Toast.LENGTH_SHORT).show();
                    return;
                }

                dsNgonNgu.set(viTriChon, tenMoi);
                adapter.notifyDataSetChanged();
                Toast.makeText(Bai1_Activity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                edtTenNgonNgu.setText("");
                viTriChon = -1;
            }
        });


    }
}
