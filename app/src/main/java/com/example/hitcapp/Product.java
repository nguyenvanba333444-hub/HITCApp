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
    }

    public String getName() { return name; }
    
    public String getPrice() { 
        if (priceValue > 1000) {
             return java.text.NumberFormat.getInstance().format(priceValue).replace(",", ".") + " VNĐ";
        }
        return String.format("%.2f $", priceValue); 
    }
    
    public int getImageResId() { return imageResId; }
    
    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setImageResId(int imageResId) { this.imageResId = imageResId; }
}