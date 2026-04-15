package com.example.hitcapp;

import android.content.Intent;
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

        EditText user = findViewById(R.id.reg_username);
        EditText email = findViewById(R.id.reg_email);
        EditText pass = findViewById(R.id.reg_password);
        Button btnReg = findViewById(R.id.registerBtn);
        TextView backLogin = findViewById(R.id.txtBackToLogin);

        btnReg.setOnClickListener(v -> {
            if(user.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
                Toast.makeText(this, "Vui lòng nhập đầy đủ!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                finish(); // Quay lại trang Login
            }
        });

        backLogin.setOnClickListener(v -> finish());
    }
}