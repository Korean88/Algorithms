package com.home.algorithms.goldmansachs.string;

public class ExcelCols {

    String excelColumnName(int number) {
        StringBuilder sb = new StringBuilder();
        while (number>0) {
            number--;
            int integerPart = number / 26;
            int residue = number % 26;
            sb.append((char)('A'+residue));
            number = integerPart;
        }
        return sb.reverse().toString();
    }
}
