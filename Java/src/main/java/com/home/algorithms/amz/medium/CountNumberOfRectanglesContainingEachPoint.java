package com.home.algorithms.amz.medium;

import java.util.Arrays;
import java.util.Comparator;

public class CountNumberOfRectanglesContainingEachPoint {

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int [][] pointsWithIndex = new int [points.length][3];
        for (int i=0;i<points.length;i++) {
            pointsWithIndex[i][0]=points[i][0];
            pointsWithIndex[i][1]=points[i][1];
            pointsWithIndex[i][2]=i;
        }
        Arrays.sort(rectangles, Comparator.comparing(r -> r[0]));
        Arrays.sort(pointsWithIndex, Comparator.comparing(p -> p[0]));

        int [] heights = new int [101];
        for (int [] rectangle : rectangles) {
            heights[rectangle[1]]++;
        }

        int [] ans = new int [points.length];
        int recIndex=0;
        for (int[] pointIndex : pointsWithIndex) {
            int x = pointIndex[0];
            int y = pointIndex[1];
            while (recIndex < rectangles.length && rectangles[recIndex][0] < x) {
                heights[rectangles[recIndex][1]]--;
                recIndex++;
            }
            if (recIndex == rectangles.length) break;
            for (int h = y; h <= 100; h++) {
                ans[pointIndex[2]] += heights[h];
            }
        }
        return ans;
    }
}
