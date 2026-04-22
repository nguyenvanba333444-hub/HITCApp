package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Ánh xạ các View mới
        ImageButton btnBack = findViewById(R.id.btnBackDetail);
        Button btnAdd = findViewById(R.id.btnAddToCartDetail);
        Button btnBuy = findViewById(R.id.btnBuyNow);
        ImageView imgProduct = findViewById(R.id.imgProductDetail);
        TextView tvName = findViewById(R.id.tvDetailName);

        // Nhận dữ liệu từ Intent (từ MainActivity truyền sang)
        String productName = getIntent().getStringExtra("product_name");
        if (productName != null) {
            tvName.setText(productName);
            // Bạn có thể xử lý đổi ảnh tương ứng với tên sản phẩm ở đây
            if (productName.contains("Samsung")) {
                imgProduct.setImageResource(R.drawable.img_2);
            } else if (productName.contains("iPhone")) {
                imgProduct.setImageResource(R.drawable.img_3);
            }
        }

        // Xử lý nút Back
        btnBack.setOnClickListener(v -> finish());

        // Xử lý nút Thêm vào giỏ
        btnAdd.setOnClickListener(v -> {
            Toast.makeText(this, "Đã thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
        });

        // Xử lý nút Mua ngay -> Chuyển sang màn hình Cart
        btnBuy.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}