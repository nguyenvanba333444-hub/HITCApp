package com.example.hitcapp;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private static final String PREF_NAME = "UserPrefs";
    private static final String KEY_USER = "username";
    private static final String KEY_PASS = "password";

    // Lưu tài khoản vào bộ nhớ máy (vĩnh viễn)
    public static void registerUser(Context context, String username, String password) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(KEY_USER, username);
        editor.putString(KEY_PASS, password);
        editor.apply();
    }

    // Kiểm tra đăng nhập từ bộ nhớ máy
    public static boolean checkLogin(Context context, String username, String password) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String savedUser = pref.getString(KEY_USER, "admin"); // Mặc định là admin
        String savedPass = pref.getString(KEY_PASS, "123456"); // Mặc định là 123456
        
        return username.equals(savedUser) && password.equals(savedPass);
    }
}