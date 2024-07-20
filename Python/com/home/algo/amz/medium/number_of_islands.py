import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def numIslands_dfs(self, grid: List[List[str]]) -> int:
    res = 0
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            if grid[i][j] == '1':
                res = res + 1
                dfs(grid, i, j)
    return res


def dfs(grid, r, c):
    prev_row = r - 1
    prev_col = c - 1
    next_row = r + 1
    next_col = c + 1
    if prev_row >= 0 and grid[prev_row][c] == '1':
        grid[prev_row][c] = '0'
        dfs(grid, prev_row, c)
    if prev_col >= 0 and grid[r][prev_col] == '1':
        grid[r][prev_col] = '0'
        dfs(grid, r, prev_col)
    if next_row < len(grid) and grid[next_row][c] == '1':
        grid[next_row][c] = '0'
        dfs(grid, next_row, c)
    if next_col < len(grid[0]) and grid[r][next_col] == '1':
        grid[r][next_col] = '0'
        dfs(grid, r, next_col)


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([["1", "1", "1", "1", "0"],
          ["1", "1", "0", "1", "0"],
          ["1", "1", "0", "0", "0"],
          ["0", "0", "0", "0", "0"]], 1),
        ([["1", "1", "0", "0", "0"],
          ["1", "1", "0", "0", "0"],
          ["0", "0", "1", "0", "0"],
          ["0", "0", "0", "1", "1"]], 3)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_dfs(self, grid, expected):
        actual = numIslands_dfs(self, grid)
        self.assertEqual(expected, actual)
