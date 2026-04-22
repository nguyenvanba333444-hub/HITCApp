package com.example.hitcapp;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static List<Product> cartList = new ArrayList<>();

    public static void addProduct(Product product) {
        cartList.add(product);
    }

    public static List<Product> getCartList() {
        return cartList;
    }

    public static void removeProduct(int position) {
        if (position >= 0 && position < cartList.size()) {
            cartList.remove(position);
        }
    }

    public static void clearCart() {
        cartList.clear();
    }

    public static String getTotalPrice() {
        long total = 0;
        for (Product p : cartList) {
            String priceStr = p.getPrice().replace(".", "").replace(" VNĐ", "").replace("k", "000");
            try {
                total += Long.parseLong(priceStr);
            } catch (Exception e) {}
        }
        return java.text.NumberFormat.getInstance().format(total).replace(",", ".") + " VNĐ";
    }
}