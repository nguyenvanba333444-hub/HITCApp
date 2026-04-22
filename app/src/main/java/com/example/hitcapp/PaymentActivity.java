package com.example.hitcapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ImageButton btnBack = findViewById(R.id.btnBackFromPayment);
        Button btnPayNow = findViewById(R.id.btnPayNow);

        btnBack.setOnClickListener(v -> finish());

        btnPayNow.setOnClickListener(v -> {
            Toast.makeText(this, "Thanh toán thành công! Cảm ơn bạn.", Toast.LENGTH_LONG).show();
            // Quay về màn hình chính
            finishAffinity();
            android.content.Intent intent = new android.content.Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}