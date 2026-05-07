package com.example.hitcapp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Product implements Serializable {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String name;
    
    @SerializedName("price")
    private double priceValue;
    
    @SerializedName("image")
    private String imageUrl;

    @SerializedName("description")
    private String description;

    private int quantity = 1;
    private int imageResId; // Dùng cho dữ liệu local dự phòng

    // Constructor cho dữ liệu mẫu (Local)
    public Product(String name, String price, int imageResId) {
        this.name = name;
        try {
            this.priceValue = Double.parseDouble(price.replace(".", "").replace(" VNĐ", "").replace("k", "000"));
        } catch (Exception e) {
            this.priceValue = 0;
        }
        this.imageResId = imageResId;
        this.quantity = 1;
    }

    public int getId() { return id; }

    public String getName() { 
        return name != null ? name : "Sản phẩm không tên"; 
    }
    
    public double getPriceInVnd() {
        if (priceValue > 0 && priceValue < 10000) {
            // Chuyển đổi từ USD sang VNĐ (tỷ giá giả định 25.000)
            return priceValue * 25000;
        }
        return priceValue;
    }

    public String getPrice() { 
        return java.text.NumberFormat.getInstance().format(getPriceInVnd()).replace(",", ".") + " VNĐ";
    }
    
    public int getImageResId() { return imageResId; }
    
    public String getImageUrl() { return imageUrl; }

    public String getDescription() { return description; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setImageResId(int imageResId) { this.imageResId = imageResId; }
}