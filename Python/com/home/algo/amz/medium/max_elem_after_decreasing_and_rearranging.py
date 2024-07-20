import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def solution(self, nums: List[int]) -> int:
    sorted_arr = sorted(nums)
    res = 1
    for i in range(1, len(sorted_arr)):
        if sorted_arr[i] >= res + 1:
            res += 1
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([1,2,2,2,5,14,17], 5),
        ([1,2,2,5,14,17], 5),
        ([1,1,1,1,4,1,1], 2)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, nums: List[int], expected: int):
        actual = solution(self, nums)
        self.assertEqual(expected, actual)
