package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ProductAdapter adapter;
    private List<Product> productList = new ArrayList<>();
    private ProgressBar progressBar;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_sanpham);
        progressBar = findViewById(R.id.progressBar);
        etSearch = findViewById(R.id.etSearch); 

        rv.setLayoutManager(new GridLayoutManager(this, 2));

        findViewById(R.id.btnGoToCart).setOnClickListener(v -> startActivity(new Intent(this, CartActivity.class)));
        findViewById(R.id.btnProfile).setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        findViewById(R.id.btnProfileBottom).setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));

        setupSearch();
        fetchProductsFromApi();
    }

    private void setupSearch() {
        if (etSearch != null) {
            etSearch.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    filterProducts(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }
    }

    private void filterProducts(String query) {
        if (productList == null) return;
        List<Product> filteredList = new ArrayList<>();
        String lowerQuery = query.toLowerCase().trim();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(lowerQuery)) {
                filteredList.add(product);
            }
        }
        if (adapter != null) {
            adapter.updateList(filteredList);
        }
    }

    private void fetchProductsFromApi() {
        progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getApiService().getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                progressBar.setVisibility(View.GONE);
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
                progressBar.setVisibility(View.GONE);
                loadLocalData();
                Toast.makeText(MainActivity.this, "Lỗi kết nối API", Toast.LENGTH_SHORT).show();
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