import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def find_duplicates(self, nums: List[int]) -> List[int]:
    res = []
    for i in nums:
        val = abs(i)
        if nums[val - 1] < 0:
            res.append(val)
        else:
            nums[val - 1] *= -1
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([4, 3, 2, 7, 8, 2, 3, 1], [2, 3]),
        ([1, 1, 2], [1]),
        ([1], []),
        ([2, 2], [2])
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, nums: List[int], expected: List[int]):
        actual = find_duplicates(self, nums)
        self.assertEqual(len(expected), len(actual))
        for i in actual:
            self.assertIn(i, expected)
