import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def validSubarrays(self, nums: List[int]) -> int:
    res = 0
    stack = [0]
    for i in range(1, len(nums)):
        while stack and nums[i] < nums[stack[len(stack) - 1]]:
            res += (i - stack.pop())
        stack.append(i)
    while stack:
        res += (len(nums) - stack.pop())
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([1, 4, 2, 5, 3], 11),
        ([3, 2, 1], 3),
        ([3, 2, 1, 2, 3], 8)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, nums: List[int], expected: int):
        actual = validSubarrays(self, nums)
        self.assertEqual(expected, actual)
