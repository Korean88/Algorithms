package com.home.algorithms.amz.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    q.offer(new int[]{i, j});
                    bfs(q, grid);
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, char[][] grid) {
        while (!q.isEmpty()) {
            int[] coords = q.poll();
            int row = coords[0];
            int col = coords[1];
            if (row != 0 && grid[row - 1][col] == '1') { //up
                grid[row-1][col] = '0';
                q.offer(new int[]{row-1, col});
            }
            if (row != grid.length - 1 && grid[row+1][col] == '1') { //down
                grid[row+1][col] = '0';
                q.offer(new int[]{row+1, col});
            }
            if (col != 0 && grid[row][col-1] == '1') { //left
                grid[row][col-1] = '0';
                q.offer(new int[]{row, col-1});
            }
            if (col != grid[0].length - 1 && grid[row][col+1] == '1') { //right
                grid[row][col+1] = '0';
                q.offer(new int[]{row, col+1});
            }
        }
    }

}
