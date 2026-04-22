package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ProductAdapter adapter;
    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_sanpham);
        rv.setLayoutManager(new GridLayoutManager(this, 2));

        findViewById(R.id.btnGoToCart).setOnClickListener(v -> startActivity(new Intent(this, CartActivity.class)));
        findViewById(R.id.btnProfile).setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        findViewById(R.id.btnProfileBottom).setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));

        // Gọi API từ fakestoreapi.com
        fetchProductsFromApi();
    }

    private void fetchProductsFromApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/") 
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    productList = response.body();
                    adapter = new ProductAdapter(MainActivity.this, productList);
                    rv.setAdapter(adapter);
                } else {
                    loadLocalData();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                loadLocalData();
                Toast.makeText(MainActivity.this, "Lỗi kết nối API fakestore", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadLocalData() {
        productList.clear();
        productList.add(new Product("Samsung S24 Ultra", "22.500.000 VNĐ", R.drawable.img_2));
        productList.add(new Product("iPhone 15 Pro", "29.990.000 VNĐ", R.drawable.img_3));
        adapter = new ProductAdapter(this, productList);
        rv.setAdapter(adapter);
    }
}