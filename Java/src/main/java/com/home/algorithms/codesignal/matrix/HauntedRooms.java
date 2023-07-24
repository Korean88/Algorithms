package com.home.algorithms.codesignal.matrix;

public class HauntedRooms {
    int solution(int[][] matrix) {
        int s = 0;
        for (int c = 0; c < matrix[0].length; ++c)
            for (int r = 0; r < matrix.length; ++r) {
                if (matrix[r][c] > 0)
                    s+=matrix[r][c];
                else break;
            }
        return s;
    }
}
