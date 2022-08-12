import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def params():
    return [
        ([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], 6),
        ([4, 2, 0, 3, 2, 5], 9),
        ([4, 2, 4], 2),
        ([0, 0, 0], 0),
        ([10, 20], 0),
        ([3, 3, 3, 3], 0),
        ([1, 2, 3, 4], 0),
        ([6, 5, 4, 3], 0),
        ([], 0),
        ([10], 0),
        (None, 0)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_trapping_water(self, given, expected):
        actual = trap(given)
        self.assertEqual(expected, actual)


def trap(height: List[int]) -> int:
    if height is None or len(height) < 3:
        return 0
    size = len(height)
    res = 0
    left_max = [None] * size
    right_max = [None] * size
    left_max[0] = height[0]
    right_max[size - 1] = height[size - 1]
    for i in range(1, size):
        left_max[i] = max(height[i], left_max[i - 1])
    for i in range(size - 2, -1, -1):
        right_max[i] = max(height[i], right_max[i + 1])
    for i in range(size):
        res += min(left_max[i], right_max[i]) - height[i]
    return res


if __name__ == '__main__':
    unittest.main()
