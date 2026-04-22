package com.example.hitcapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText userEt = findViewById(R.id.reg_username);
        EditText passEt = findViewById(R.id.reg_password);
        Button btnReg = findViewById(R.id.registerBtn);
        TextView backLogin = findViewById(R.id.txtBackToLogin);

        btnReg.setOnClickListener(v -> {
            String username = userEt.getText().toString().trim();
            String password = passEt.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else {
                // Lưu tài khoản mới vào bộ nhớ máy (SharedPreferences)
                UserManager.registerUser(this, username, password);
                Toast.makeText(this, "Đăng ký thành công! Hãy đăng nhập lại.", Toast.LENGTH_SHORT).show();
                finish(); // Quay lại trang Login
            }
        });

        backLogin.setOnClickListener(v -> finish());
    }
}