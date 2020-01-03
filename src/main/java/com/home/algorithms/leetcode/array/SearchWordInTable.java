package com.home.algorithms.leetcode.array;

public class SearchWordInTable {

    boolean exists(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                if (find(i, j, board, word, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean find(int i, int j, char[][] board, String word, int currentCharIndex, boolean[][] visited) {
        if (word.charAt(currentCharIndex++) == board[i][j] && !visited[i][j]) {
            if (currentCharIndex == word.length()) return true;
            visited[i][j] = true;
            boolean adjacentFound = (i + 1 < board.length && find(i + 1, j, board, word, currentCharIndex, visited)) ||
                    (i - 1 >= 0 && find(i - 1, j, board, word, currentCharIndex, visited)) ||
                    (j + 1 < board[0].length && find(i, j + 1, board, word, currentCharIndex, visited)) ||
                    (j - 1 >= 0 && find(i, j - 1, board, word, currentCharIndex, visited));
            if (!adjacentFound) {
                visited[i][j] = false;
            }
            return adjacentFound;
        } else {
            return false;
        }
    }
}
