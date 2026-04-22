package com.example.hitcapp;

public class UserManager {
    private static String registeredUser = "admin";
    private static String registeredPass = "123456";

    public static void registerUser(String username, String password) {
        registeredUser = username;
        registeredPass = password;
    }

    public static boolean checkLogin(String username, String password) {
        return username.equals(registeredUser) && password.equals(registeredPass);
    }
}