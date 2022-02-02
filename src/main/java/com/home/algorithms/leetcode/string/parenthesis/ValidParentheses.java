package com.home.algorithms.leetcode.string.parenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            Character currentChar = s.charAt(i);
            if (!stack.isEmpty() && map.get(currentChar) != null) {
                if (stack.pop() != map.get(currentChar)) {
                    return false;
                }
            } else {
                stack.add(currentChar);
            }
        }
        return stack.isEmpty();
    }

}
