import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def params():
    return [
        ([1, 8, 6, 2, 5, 4, 8, 3, 7], 49),
        ([8, 10, 6, 2, 5, 4, 8, 3, 7], 56),
        ([5, 5], 5),
        ([4], 0),
        ([0], 0),
        ([0, 0], 0),
        ([5, 0], 0),
        ([0, 5], 0),
        ([], 0),
        (None, 0)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_max_area(self, given, expected):
        actual = max_area(given)
        self.assertEqual(expected, actual)


def max_area(height: List[int]) -> int:
    if height is None or len(height) < 2:
        return 0
    max_water = 0
    start = 0
    end = len(height) - 1
    while start < end:
        max_water = max(max_water, min(height[start], height[end]) * (end - start))
        if height[start] <= height[end]:
            start += 1
        else:
            end -= 1
    return max_water


if __name__ == '__main__':
    unittest.main()
