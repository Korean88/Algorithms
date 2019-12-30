package com.home.algorithms.leetcode.string;

public class ZigZagConversion {

    String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 1) {
            return "";
        }
        if (numRows==1) {
            return s;
        }
        int stringLength=s.length();
        int diagCells = numRows-2;
        int numCols = countCols(stringLength, numRows, diagCells);
        char[][] matrix = new char[numCols][numRows];
        char[] chars = s.toCharArray();
        int currentCol=0, currentRow=0;
        boolean directionFwd=true;
        for (int i=0; i<chars.length; i++) {
            if (directionFwd) {
                matrix[currentCol][currentRow++]=chars[i];
            } else {
                matrix[++currentCol][--currentRow]=chars[i];
            }
            if (currentRow==0) {
                directionFwd=true;
                currentRow++;
            } else if (currentRow==numRows) {
                currentRow--;
                directionFwd=false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numRows; i++) {
            for (int j=0; j<numCols; j++) {
                if(matrix[j][i] != '\u0000') {
                    sb.append(matrix[j][i]);
                }
            }
        }
        return sb.toString();
    }

    private int countCols(int stringLength, int numRows, int diagCells) {
        int charsInSection = numRows+diagCells;
        int colsInSection = 1+diagCells;
        int fullSections = stringLength/charsInSection;
        int charsLeft = stringLength - fullSections*charsInSection;
        return (charsLeft > numRows ? charsLeft-numRows+1 : 1) + colsInSection * fullSections;
    }
}
