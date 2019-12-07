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
        int counter = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            char first = input.charAt(i);
            if (input.charAt(i + 1) == first) {
                counter++;
                if (i == input.length() - 2) {
                    sb.append(first).append(counter);
                }
            } else {
                sb.append(first).append(counter);
                counter = 1;
                if (i == input.length() - 2) {
                    sb.append(input.charAt(input.length()-1)).append(1);
                }
            }
        }
        return sb.toString();
    }
}
