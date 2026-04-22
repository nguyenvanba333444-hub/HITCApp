package com.example.hitcapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() { return productList.size(); }

    @Override
    public Object getItem(int position) { return productList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        }

        Product product = productList.get(position);

        ImageView img = convertView.findViewById(R.id.img_product);
        TextView name = convertView.findViewById(R.id.tv_name);
        TextView price = convertView.findViewById(R.id.tv_price);
        ImageButton btnAddFast = convertView.findViewById(R.id.btn_add_fast);

        img.setImageResource(product.getImageResId());
        name.setText(product.getName());
        price.setText(product.getPrice());

        // Xử lý nút "Mua nhanh" ngay trong Adapter
        btnAddFast.setOnClickListener(v -> {
            Toast.makeText(context, "Đã thêm " + product.getName() + " vào giỏ!", Toast.LENGTH_SHORT).show();
            // Có thể chuyển thẳng sang Cart nếu muốn
            // Intent intent = new Intent(context, CartActivity.class);
            // context.startActivity(intent);
        });

        // Bấm vào cả dòng sẽ vào Detail
        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            // Gửi dữ liệu sang (tùy chọn)
            intent.putExtra("product_name", product.getName());
            context.startActivity(intent);
        });

        return convertView;
    }
}