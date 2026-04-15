package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 1. Ánh xạ các thành phần Đăng nhập thông thường
        EditText usernameEt = findViewById(R.id.username);
        EditText passwordEt = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginBtn);

        // 2. Ánh xạ các nút Đăng nhập Mạng xã hội (Hiện đại)
        ImageButton btnGoogle = findViewById(R.id.btnGoogle);
        ImageButton btnFacebook = findViewById(R.id.btnFacebook);

        // 3. Ánh xạ nút chuyển sang trang Đăng ký (Nếu bạn đã thêm TextView vào XML)
        TextView txtGoToRegister = findViewById(R.id.txtGoToRegister);

        // --- XỬ LÝ SỰ KIỆN ---

        // Nút Login chính: Chuyển sang MainActivity
        if (loginBtn != null) {
            loginBtn.setOnClickListener(v -> {
                String user = usernameEt.getText().toString().trim();
                String pass = passwordEt.getText().toString().trim();

                if (user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(this, "Vui lòng nhập đủ tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        // Nút chuyển sang trang Register
        if (txtGoToRegister != null) {
            txtGoToRegister.setOnClickListener(v -> {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            });
        }

        // Xử lý sự kiện cho Google
        if (btnGoogle != null) {
            btnGoogle.setOnClickListener(v -> {
                Toast.makeText(this, "Đang mở cửa sổ đăng nhập Google...", Toast.LENGTH_SHORT).show();
            });
        }

        // Xử lý sự kiện cho Facebook
        if (btnFacebook != null) {
            btnFacebook.setOnClickListener(v -> {
                Toast.makeText(this, "Đang kết nối tới Facebook...", Toast.LENGTH_SHORT).show();
            });
        }
    }
}