package com.home.algorithms.crackingbook.array;

public class ZeroMatrix {

    int[][] nullifyMatrix(int[][] matrix) {
        if (matrix == null) {
            return new int[][]{};
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] zeroRowIndexes = new boolean[rows];
        boolean[] zeroColIndexes = new boolean[cols];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (matrix[i][j]==0) {
                    zeroRowIndexes[i] = true;
                    zeroColIndexes[j] = true;
                }
            }
        }
        for (int i=0; i<zeroRowIndexes.length; i++) {
            if (zeroRowIndexes[i]) {
                for (int j=0; j<cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i=0; i<zeroColIndexes.length; i++) {
            if(zeroColIndexes[i]) {
                for (int j=0; j< rows; j++) {
                    matrix[j][i]=0;
                }
            }
        }
        return matrix;
    }
}
