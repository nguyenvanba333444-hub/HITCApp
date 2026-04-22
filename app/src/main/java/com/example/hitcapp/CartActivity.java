package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity implements CartAdapter.OnCartChangeListener {
    private RecyclerView rvCart;
    private CartAdapter adapter;
    private TextView tvTotalPrice;
    private LinearLayout emptyCartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCart = findViewById(R.id.rvCart);
        tvTotalPrice = findViewById(R.id.tvTotalPriceCart);
        emptyCartView = findViewById(R.id.emptyCartView);
        ImageButton btnBack = findViewById(R.id.btnBackCart);
        Button btnCheckout = findViewById(R.id.btnProceedCheckout);

        rvCart.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter(this, CartManager.getCartList(), this);
        rvCart.setAdapter(adapter);

        updateCartUI();

        btnBack.setOnClickListener(v -> finish());
        btnCheckout.setOnClickListener(v -> {
            if (!CartManager.getCartList().isEmpty()) {
                Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateCartUI() {
        if (CartManager.getCartList().isEmpty()) {
            emptyCartView.setVisibility(View.VISIBLE);
            rvCart.setVisibility(View.GONE);
        } else {
            emptyCartView.setVisibility(View.GONE);
            rvCart.setVisibility(View.VISIBLE);
        }
        tvTotalPrice.setText(CartManager.getTotalPrice());
    }

    @Override
    public void onCartChanged() {
        updateCartUI();
    }
}