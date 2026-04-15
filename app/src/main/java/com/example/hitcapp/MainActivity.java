package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Xử lý tràn viền (Insets)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Ánh xạ ListView từ XML
        ListView lv = findViewById(R.id.lv_sanpham);

        // 2. Tạo dữ liệu mẫu
        String[] data = {
                "Gói thanh toán Cơ bản",
                "Gói thanh toán Nâng cao",
                "Gói thanh toán Premium",
                "Gói thanh toán Đặc biệt"
        };

        // 3. Tạo Adapter để đổ dữ liệu vào ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );

        // 4. Gán Adapter cho ListView
        lv.setAdapter(adapter);

        // 5. Xử lý sự kiện khi nhấn vào từng dòng để sang trang Detail
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Chuyển sang trang DetailActivity (file detail.java hoặc DetailActivity.java của bạn)
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}