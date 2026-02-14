package com.app.hw16;

public class StringListProcessor {
    public static Integer countUppercase(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                count++;
            }
        }
        return count;
    }
}
