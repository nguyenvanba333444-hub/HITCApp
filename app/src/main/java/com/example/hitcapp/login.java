package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText usernameEt = findViewById(R.id.username);
        EditText passwordEt = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginBtn);
        TextView txtGoToRegister = findViewById(R.id.txtGoToRegister);

        loginBtn.setOnClickListener(v -> {
            String user = usernameEt.getText().toString().trim();
            String pass = passwordEt.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();
            } else {
                // Kiểm tra đăng nhập với dữ liệu đã lưu trong máy
                if (UserManager.checkLogin(this, user, pass)) {
                    Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtGoToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(login.this, register.class);
            startActivity(intent);
        });
    }
}