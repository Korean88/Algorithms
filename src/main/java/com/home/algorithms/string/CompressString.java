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
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            counter++;
            char current = input.charAt(i);
            if (i == input.length()-1 || input.charAt(i + 1) != current) {
                sb.append(current).append(counter);
                counter = 0;
            }
        }
        return sb.toString();
    }
}
