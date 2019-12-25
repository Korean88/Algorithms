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
            char first = input.charAt(i);
            counter++;
            if (i+1 == input.length() || input.charAt(i + 1) != first) {
                sb.append(first).append(counter);
                counter = 0;
            }
        }
        return sb.toString();
    }
}
