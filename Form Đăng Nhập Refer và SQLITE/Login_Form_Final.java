package com.example.demo_constrait;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login_Form_Final extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    CheckBox rememberLogin;
    Button btnLogin;

    MyDatabase myDatabase;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        rememberLogin = findViewById(R.id.rememberLogin);
        btnLogin = findViewById(R.id.btnLogin);

        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        // Lấy giá trị đã lưu
        edtUsername.setText(sharedPreferences.getString("username", ""));
        edtPassword.setText(sharedPreferences.getString("password", ""));
        rememberLogin.setChecked(sharedPreferences.getBoolean("checked", false));


        myDatabase = new MyDatabase(this, "User.sqlite", null, 1);
        String sql_Create_Table = "create table if not exists account(id integer primary key autoincrement,username varchar(50), password varchar(50))";
        myDatabase.ExecuteSQL(sql_Create_Table);
//        String sql_insert = "insert into account values(null,'admin','123456'),(null,'alex','123'),(null,'hoanganh','1234')";
//        myDatabase.ExecuteSQL(sql_insert);
//        Toast.makeText(this, "Add Success", Toast.LENGTH_SHORT).show();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String sql_select = "select * from account where username = '" + username + "' and password = '" + password + "'";
                Cursor c = myDatabase.selectData(sql_select);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (c.getCount() > 0) {
                    Toast.makeText(Login_Form_Final.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                    if (rememberLogin.isChecked()) {
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putBoolean("checked", true);
                    } else {

                        editor.remove("username").remove("password").remove("checked");
                    }



                } else {
                    Toast.makeText(Login_Form_Final.this, "Đăng Nhập Thất bại", Toast.LENGTH_SHORT).show();
                    editor.putString("username", "");
                    editor.putString("password", "");
                    editor.putBoolean("checked", false);
                }

                editor.apply();
            }
        });
    }
}
