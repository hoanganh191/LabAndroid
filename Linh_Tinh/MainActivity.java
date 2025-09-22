package com.example.thi_nghiem;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textViewStatus;
    GridView gridViewNhaCungCap;
    NhaCungCapAdapter nhaCungCapAdapter;
    List<NhaCungCap> dsNhaCungCap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textViewStatus = findViewById(R.id.textViewStatus);
        gridViewNhaCungCap = findViewById(R.id.gridViewNhaCungCap);
        dsNhaCungCap = new ArrayList<>();
        nhaCungCapAdapter = new NhaCungCapAdapter(this, dsNhaCungCap);
        gridViewNhaCungCap.setAdapter(nhaCungCapAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Tải dữ liệu nhà cung cấp
        // LƯU Ý QUAN TRỌNG: Kết nối mạng và truy vấn CSDL PHẢI được thực hiện trên luồng nền
        // trong một ứng dụng thực tế để tránh lỗi ANR.
        // Code dưới đây chạy trên luồng chính chỉ nhằm mục đích minh họa đơn giản.
        // BẠN CẦN SỬ DỤNG AsyncTask, Executors, hoặc Kotlin Coroutines.
        loadNhaCungCapData();
    }

    private void loadNhaCungCapData() {
        ConnectSQL connectSQL = new ConnectSQL();
        Connection connection = connectSQL.connect();

        if (connection != null) {
            textViewStatus.setText("Kết nối SQL Server THÀNH CÔNG! Đang tải dữ liệu...");
            Log.i("MainActivity_SQL", "Kết nối SQL Server thành công!");
            Statement st = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT MACONGTY, TENCONGTY, TENGIAODICH, DIACHI, EMAIL, DIENTHOAI, FAX FROM NHACUNGCAP";
                st = connection.createStatement();
                rs = st.executeQuery(sql);

                dsNhaCungCap.clear(); // Xóa dữ liệu cũ (nếu có)
                while (rs.next()) {
                    String maCongTy = rs.getString("MACONGTY");
                    String tenCongTy = rs.getString("TENCONGTY");
                    String tenGiaoDich = rs.getString("TENGIAODICH");
                    String diaChi = rs.getString("DIACHI");
                    String email = rs.getString("EMAIL");
                    String dienThoai = rs.getString("DIENTHOAI");
                    String fax = rs.getString("FAX");
                    dsNhaCungCap.add(new NhaCungCap(maCongTy, tenCongTy, tenGiaoDich, diaChi, email, dienThoai, fax));
                }
                nhaCungCapAdapter.notifyDataSetChanged(); // Cập nhật GridView

                if (dsNhaCungCap.isEmpty()) {
                    textViewStatus.setText("Kết nối thành công. Không có dữ liệu nhà cung cấp.");
                    Toast.makeText(this, "Không có dữ liệu nhà cung cấp.", Toast.LENGTH_SHORT).show();
                } else {
                     textViewStatus.setText("Tải dữ liệu nhà cung cấp thành công!");
                }

            } catch (Exception e) {
                Log.e("MainActivity_SQL_Query", "Lỗi khi truy vấn dữ liệu: " + e.getMessage());
                e.printStackTrace();
                textViewStatus.setText("Lỗi khi tải dữ liệu: " + e.getMessage());
                Toast.makeText(this, "Lỗi khi tải dữ liệu.", Toast.LENGTH_LONG).show();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (st != null) st.close();
                    connection.close();
                    Log.i("MainActivity_SQL", "Đã đóng kết nối SQL Server.");
                } catch (Exception e) {
                    Log.e("MainActivity_SQL", "Lỗi khi đóng kết nối: " + e.getMessage());
                }
            }
        } else {
            textViewStatus.setText("Kết nối SQL Server THẤT BẠI!");
            Log.e("MainActivity_SQL", "Kết nối SQL Server thất bại!");
            Toast.makeText(this, "Không thể kết nối đến SQL Server.", Toast.LENGTH_LONG).show();
        }
    }
}
