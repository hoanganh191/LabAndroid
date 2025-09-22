package com.example.lab02;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai2_Activity extends AppCompatActivity {
    EditText edtNhap;
    Button btnNhap;
    ListView lvNhap;

    TextView tvKq;
    List<String> dsNhap;
    ArrayAdapter adapter;

    int viTriChon = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ListViewActivityWithArrayList");
        }
        edtNhap = findViewById(R.id.edtNhap);
        btnNhap = findViewById(R.id.btnNhap);
        lvNhap = findViewById(R.id.lvNhap);
        tvKq = findViewById(R.id.tvKq);
        dsNhap = new ArrayList<>();
        adapter = new ArrayAdapter(Bai2_Activity.this, android.R.layout.simple_list_item_1, dsNhap);
        lvNhap.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kqNhap = edtNhap.getText().toString().trim();
                if (kqNhap.isEmpty()) {
                    Toast.makeText(Bai2_Activity.this, "Vui lòng nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }
                dsNhap.add(kqNhap);
                adapter.notifyDataSetChanged();
                Toast.makeText(Bai2_Activity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                edtNhap.setText("");
            }
        });

        lvNhap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viTriChon = position;
                tvKq.setText("Vị trí: " + viTriChon + " và Giá trị: " + dsNhap.get(position));
            }
        });
    }
}
