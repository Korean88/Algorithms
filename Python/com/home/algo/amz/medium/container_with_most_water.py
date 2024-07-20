import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def maxArea(self, height: List[int]) -> int:
    res = 0
    left = 0;
    right = len(height) - 1
    while left < right:
        h = min(height[left], height[right])
        res = max(res, h * (right - left))
        if height[left] < height[right]:
            left += 1
        else:
            right -= 1
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([1,8,6,2,5,4,8,3,7], 49),
        ([1,1], 1)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, height: List[int], expected: int):
        actual = maxArea(self, height)
        self.assertEqual(expected, actual)
