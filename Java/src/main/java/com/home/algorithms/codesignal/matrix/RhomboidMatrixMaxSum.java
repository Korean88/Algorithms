package com.home.algorithms.codesignal.matrix;

public class RhomboidMatrixMaxSum {

    int solution(int[][] matrix, int radius) {
        var res = 0;
        for (int r = radius - 1; r < matrix.length - radius + 1; r++) {
            for (int c = radius - 1; c < matrix[0].length - radius + 1; c++) {
                var currentSum = calculateSum(matrix, r, c, radius);
                if (currentSum > res) {
                    res = currentSum;
                }
            }
        }
        return res;
    }

    private int calculateSum(int[][] matrix, int r, int c, int radius) {
        var centerLineSum = 0;
        for (int i = c - radius + 1; i <= c + radius - 1; i++) {
            centerLineSum += matrix[r][i];
        }

        int res = centerLineSum;
        int linesLeft = radius - 1;
        int rowUp = r - 1;
        int rowDown = r + 1;
        int dCol = 2;
        while (linesLeft > 0) {
            linesLeft--;
            int sumUp = 0;
            int sumDown = 0;
            for (int i = c - radius + dCol; i <= c + radius - dCol; i++) {
                sumUp += matrix[rowUp][i];
                sumDown += matrix[rowDown][i];
            }
            res = res + sumUp + sumDown;
            rowUp--;
            rowDown++;
            dCol++;
        }
        return res;
    }


}
