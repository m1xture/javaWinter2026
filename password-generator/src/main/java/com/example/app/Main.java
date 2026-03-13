package com.example.app;


import com.java.winter.PasswordGenerator;

public class Main {
    public static void main(String[] args) {
        String password = PasswordGenerator.generatePassword(12);
        System.out.println("Згенерований пароль: " + password);
        System.out.println("Довжина: " + password.length());
    }
}