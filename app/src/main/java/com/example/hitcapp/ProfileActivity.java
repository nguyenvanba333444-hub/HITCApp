package com.example.hitcapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton btnBack = findViewById(R.id.btnBackFromProfile);
        Button btnLogout = findViewById(R.id.btnLogout);

        btnBack.setOnClickListener(v -> finish());
        
        btnLogout.setOnClickListener(v -> {
            // Xử lý đăng xuất ở đây
            finish();
        });
    }
}