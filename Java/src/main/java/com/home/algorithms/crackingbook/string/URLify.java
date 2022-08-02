package com.home.algorithms.crackingbook.string;

public class URLify {

    char[] perform(char[] chars, int trueLength) {
        if (chars==null || chars.length == 0) {
            return new char[]{};
        }
        if (trueLength == chars.length) {
            return chars;
        }

        int spaceCount = 0;
        for (int i=0; i<trueLength; i++) {
            if (chars[i]==' ') {
                spaceCount++;
            }
        }
        int resultLength = trueLength + spaceCount*2;
        int reverseCharIndex = trueLength-1;
        int index = resultLength-1;
        while (index>=0) {
            if (chars[reverseCharIndex] == ' ') {
                chars[index] = '0';
                chars[index-1] = '2';
                chars[index-2] = '%';
                index = index - 3;
            } else {
                chars[index] = chars[reverseCharIndex];
                index--;
            }
            reverseCharIndex--;
        }
        return chars;
    }
}
