import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def longestValidSubstring(self, word: str, forbidden: List[str]) -> int:
    right = len(word)
    forbidden_set = set(forbidden)
    res = 0
    for left in range(len(word) - 1, -1, -1):
        for k in range(left+1, min(left+10, right+1)):
            if word[left:k] in forbidden_set:
                right = k-1
                break
        res = max(res, right - left)
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ("cbaaaabc", ["aaa", "cb"], 4),
        ("leetcode", ["de", "le", "e"], 4),
        ("cabba", ["aaba", "abba", "acabb", "cabb"], 3),
        ("bcbcb", ["cbbbb", "bcbcb", "cbc", "bcb"], 2),
        ("abaca", ["aca", "aba", "acc", "aba"], 3),
        ("bcccccc", ["bcaca", "bbaca", "ccc", "cccc"], 3),
        ("acabcab", ["bbcbb", "acac", "cab", "abcab"], 4)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, word: str, forbidden: List[str], expected: int):
        actual = longestValidSubstring(self, word, forbidden)
        self.assertEqual(expected, actual)
