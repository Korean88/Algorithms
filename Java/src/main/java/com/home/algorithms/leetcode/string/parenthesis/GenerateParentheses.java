package com.home.algorithms.leetcode.string.parenthesis;

import java.util.*;

public class GenerateParentheses {

    public List<String> generateParentheses(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        String s = "";
        List<String> resSet = new ArrayList<>();
        generateRecursive(s, resSet, 0, 0, n);
        return resSet;
    }

    private void generateRecursive(String s, List<String> existing, int opening, int closing, int n) {
        if (opening + closing == n * 2) {
            existing.add(s);
            return;
        }
        if (opening == n) {
            s += ")";
            generateRecursive(s, existing, opening, ++closing, n);
        } else if (opening > closing) {
            String s1 = s + "(";
            generateRecursive(s1, existing, ++opening, closing, n);
            String s2 = s + ")";
            generateRecursive(s2, existing, --opening, ++closing, n);
        } else if (opening == closing) {
            s += "(";
            generateRecursive(s, existing, ++opening, closing, n);
        }
    }

}
