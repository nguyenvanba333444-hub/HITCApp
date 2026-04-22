package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Ánh xạ các nút bấm mới
        ImageButton btnBack = findViewById(R.id.btnBackCart);
        Button btnCheckout = findViewById(R.id.btnProceedCheckout);

        // Quay lại trang trước
        btnBack.setOnClickListener(v -> finish());

        // Chuyển sang trang Thanh toán (Payment)
        btnCheckout.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
            startActivity(intent);
        });
    }
}