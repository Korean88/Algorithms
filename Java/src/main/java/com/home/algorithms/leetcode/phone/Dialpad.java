package com.home.algorithms.leetcode.phone;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dialpad {

    /*
    Constraints:
    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].
     */

    private static final Map<Integer, String[]> DIALPAD = initDialpad();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            int currentDigit = Integer.parseInt(Character.toString(c));
            res = combine(res, currentDigit);
        }
        return res;
    }

    private List<String> combine(List<String> list, int digit) {
        String[] characters = DIALPAD.get(digit);
        List<String> res = new ArrayList<>();
        if (list.isEmpty()) {
            return Stream.of(characters)
                    .collect(Collectors.toList());
        }
        for (String s : list) {
            for (String c : characters) {
                res.add(s + c);
            }
        }
        return res;
    }

    private static Map<Integer, String[]> initDialpad() {
        Map<Integer, String[]> dialpad = new HashMap<>();
        dialpad.put(2, new String[]{"a", "b", "c"});
        dialpad.put(3, new String[]{"d", "e", "f"});
        dialpad.put(4, new String[]{"g", "h", "i"});
        dialpad.put(5, new String[]{"j", "k", "l"});
        dialpad.put(6, new String[]{"m", "n", "o"});
        dialpad.put(7, new String[]{"p", "q", "r", "s"});
        dialpad.put(8, new String[]{"t", "u", "v"});
        dialpad.put(9, new String[]{"w", "x", "y", "z"});
        return dialpad;
    }

}
