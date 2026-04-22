package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ GridView
        GridView gv = findViewById(R.id.gv_sanpham);

        // 2. Cập nhật dữ liệu với các hình ảnh mới bạn vừa thêm
        List<Product> productList = new ArrayList<>();
        
        // img_2 là Samsung S24 Ultra bạn vừa gửi
        productList.add(new Product("Samsung S24 Ultra", "22.500k", R.drawable.img_2));
        
        // Phân bổ các ảnh còn lại cho các sản phẩm khác
        productList.add(new Product("iPhone 15 Pro", "29.990k", R.drawable.img_3));
        productList.add(new Product("MacBook Air M3", "32.000k", R.drawable.img_4));
        productList.add(new Product("Sony WH-1000XM5", "7.500k", R.drawable.img_5));
        productList.add(new Product("Apple Watch S9", "10.200k", R.drawable.img_6));
        productList.add(new Product("iPad Pro M2", "21.900k", R.drawable.img_7));
        productList.add(new Product("AirPods Pro 2", "5.400k", R.drawable.img_3));
        productList.add(new Product("Logitech MX Master", "2.100k", R.drawable.img_4));

        // 3. Thiết lập Adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);
        gv.setAdapter(adapter);

        // 4. Click vào sản phẩm để xem chi tiết
        gv.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
        });
        
        // 5. Nút Giỏ hàng
        findViewById(R.id.btnGoToCart).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}