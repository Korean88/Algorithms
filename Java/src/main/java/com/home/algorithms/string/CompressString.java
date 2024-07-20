package com.home.algorithms.string;

public class CompressString {

    public String compress(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        if (input.length() == 1) {
            return input + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length();) {
            char first = input.charAt(i);
            int count = 0;
            while (i < input.length() && input.charAt(i) == first) {
                count++;
                i++;
            }
            sb.append(first).append(count);
        }
        return sb.toString();
    }
}
