package com.example.thi_nghiem;

import android.os.StrictMode;
import android.util.Log; // Được thêm vào để sử dụng Log.i và Log.e

import java.sql.Connection; // ĐÂY LÀ DÒNG QUAN TRỌNG ĐƯỢC THÊM
import java.sql.DriverManager;
// import java.util.Collection; // Dòng này sẽ được xóa hoặc comment lại

public class ConnectSQL {
    // THAY ĐỔI KIỂU DỮ LIỆU CỦA BIẾN 'connection'
    Connection connection; // Từ 'Collection' thành 'Connection'

    // Các biến cấu hình kết nối của bạn
    // Bạn có thể giữ chúng ở đây hoặc truyền vào làm tham số cho hàm connect()
    String ip = "192.168.240.134"; // Thay bằng IP thực tế của SQL Server
    String port = "1433";        // Port mặc định của SQL Server
    String db = "Dat_Hang";          // Thay bằng tên Database của bạn
    String un = "sa";            // Thay bằng Username của bạn
    String pass = "sa";  // Thay bằng Password của bạn

    public Connection connect() {
        // Thiết lập policy cho phép hoạt động mạng trên luồng chính (chỉ dùng cho thử nghiệm)
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection conn = null; // Khai báo biến Connection cục bộ và khởi tạo là null

        try {
            // Load JDBC driver
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // Tạo chuỗi URL kết nối
            // Thêm ;encrypt=false;trustServerCertificate=true; có thể cần cho một số cấu hình SQL Server
            String url = "jdbc:jtds:sqlserver://" + this.ip + ":" + this.port + "/" + this.db
                    + ";encrypt=false;trustServerCertificate=true;";

            // Thực hiện kết nối
            conn = DriverManager.getConnection(url, this.un, this.pass);

            // Gán kết nối thành công cho biến của lớp (nếu bạn muốn giữ lại)
            this.connection = conn;

            if (conn != null) {
                Log.i("SQL_Connect", "Kết nối đến SQL Server thành công!");
            } else {
                // Trường hợp này ít khi xảy ra nếu getConnection không ném Exception
                // nhưng vẫn kiểm tra để cẩn thận
                Log.e("SQL_Connect", "Kết nối thất bại! Đối tượng Connection là null mà không có Exception.");
            }

        } catch (Exception e) {
            // Ghi log chi tiết lỗi nếu có Exception xảy ra
            Log.e("SQL_Connect_Error", "Lỗi kết nối SQL Server: " + e.getMessage());
            e.printStackTrace(); // In toàn bộ stack trace của lỗi ra Logcat
        }

        return conn; // Trả về đối tượng Connection (sẽ là null nếu kết nối thất bại)
    }
}
