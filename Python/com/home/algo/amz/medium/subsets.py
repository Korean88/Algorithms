import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def find_subsets_recursive(self, nums: List[int]) -> List[List[int]]:
    res = []

    def backtrack(current_list, i):
        if i == len(nums):
            res.append(current_list)
            return
        current_list.append(nums[i])
        backtrack(current_list, i + 1)
        current_list.pop()
        backtrack(current_list, i + 1)

    backtrack([], 0)
    return res


def find_subsets_bit_manipulation(self, nums: List[int]) -> List[List[int]]:
    res = []
    for i in range(2 ** len(nums)):
        current = []
        for j in range(len(nums)):
            if i & (1 << j) == 1:
                current.append(nums[j])
        res.append(current)
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([1, 2], [[], [1], [2], [1, 2]]),
        ([1, 2, 3], [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]),
        ([0], [[], [0]]),
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_recursive(self, nums: List[int], expected: List[List[int]]):
        actual = find_subsets_recursive(self, nums)
        self.assertEqual(len(expected), len(actual))
        for subset in actual:
            self.assertIn(subset, expected)

    @parameterized.expand(params())
    def test_bit_manipulation(self, nums: List[int], expected: List[List[int]]):
        actual = find_subsets_bit_manipulation(self, nums)
        self.assertEqual(len(expected), len(actual))
        for subset in actual:
            self.assertIn(subset, expected)
