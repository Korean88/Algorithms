package com.home.algorithms.string;

import java.util.*;

public class NameIndex {
    /*
    Input: Andrey
    1) aaaaaa
    2) aaaaad
    3) aaaaae
    ...
    n) andrey
    ...
    6^6) yyyyyy
     */

    public static int findIndex(String name) {
        List<String> uniqueLettersSorted = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            String s = String.valueOf(name.charAt(i));
            if (!uniqueLettersSorted.contains(s)) {
                uniqueLettersSorted.add(s);
            }
        }
        Collections.sort(uniqueLettersSorted);
        StringBuilder nameRepresentation = new StringBuilder();
        for (char c : name.toCharArray()) {
            String s = String.valueOf(c);
            nameRepresentation.append(uniqueLettersSorted.indexOf(s));
        }
        int currentPower = 0;
        int sum = 1;
        int base = uniqueLettersSorted.size();
        for (int i = nameRepresentation.length() - 1; i >= 0; i--) {
            int currentInt = Character.getNumericValue(nameRepresentation.charAt(i));
            double pow = Math.pow(base, currentPower++);
            sum += currentInt * pow;
        }
        return sum;
    }

}
