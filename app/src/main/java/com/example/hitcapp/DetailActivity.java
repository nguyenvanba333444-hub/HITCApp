package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private int quantity = 1;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageButton btnBack = findViewById(R.id.btnBackDetail);
        Button btnAdd = findViewById(R.id.btnAddToCartDetail);
        Button btnBuy = findViewById(R.id.btnBuyNow);
        ImageView imgProduct = findViewById(R.id.imgProductDetail);
        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvPrice = findViewById(R.id.tvDetailPrice);

        ImageButton btnMinus = findViewById(R.id.btnMinus);
        ImageButton btnPlus = findViewById(R.id.btnPlus);
        TextView tvQuantity = findViewById(R.id.tvQuantity);

        // Nhận đối tượng Product từ Intent
        product = (Product) getIntent().getSerializableExtra("product_obj");

        if (product != null) {
            tvName.setText(product.getName());
            tvPrice.setText(product.getPrice());
            
            if (product.getImageUrl() != null && !product.getImageUrl().isEmpty()) {
                Glide.with(this).load(product.getImageUrl()).into(imgProduct);
            } else {
                imgProduct.setImageResource(product.getImageResId());
            }
        }

        if (btnPlus != null && tvQuantity != null) {
            btnPlus.setOnClickListener(v -> {
                quantity++;
                tvQuantity.setText(String.valueOf(quantity));
            });
        }

        if (btnMinus != null && tvQuantity != null) {
            btnMinus.setOnClickListener(v -> {
                if (quantity > 1) {
                    quantity--;
                    tvQuantity.setText(String.valueOf(quantity));
                }
            });
        }

        btnBack.setOnClickListener(v -> finish());

        btnAdd.setOnClickListener(v -> {
            if (product != null) {
                for (int i = 0; i < quantity; i++) {
                    CartManager.addProduct(product);
                }
                Toast.makeText(this, "Đã thêm " + quantity + " sản phẩm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
            }
        });

        btnBuy.setOnClickListener(v -> {
            if (product != null) {
                CartManager.addProduct(product);
                startActivity(new Intent(DetailActivity.this, CartActivity.class));
            }
        });
    }
}