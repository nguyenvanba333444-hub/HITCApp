package com.example.hitcapp;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static List<Product> cartList = new ArrayList<>();

    public static void addProduct(Product product, int quantity) {
        if (product == null) return;
        // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
        for (Product p : cartList) {
            // Dùng ID để so sánh nếu có, nếu không dùng Tên
            boolean isSameProduct = false;
            if (p.getId() != 0 && product.getId() != 0) {
                isSameProduct = (p.getId() == product.getId());
            } else {
                isSameProduct = p.getName().equals(product.getName());
            }

            if (isSameProduct) {
                p.setQuantity(p.getQuantity() + quantity);
                return;
            }
        }
        // Nếu chưa có, tạo bản sao và thêm vào giỏ
        product.setQuantity(quantity);
        cartList.add(product);
    }

    public static void addProduct(Product product) {
        addProduct(product, 1);
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
        double total = 0;
        for (Product p : cartList) {
            total += (p.getPriceInVnd() * p.getQuantity());
        }
        return java.text.NumberFormat.getInstance().format(total).replace(",", ".") + " VNĐ";
    }
    
    public static int getCartCount() {
        int count = 0;
        for (Product p : cartList) {
            count += p.getQuantity();
        }
        return count;
    }
}