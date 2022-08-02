import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def params():
    return [
        ([1, 2, 3], [1, 3, 2]),
        ([1, 3, 2], [2, 1, 3]),
        ([2, 1, 3], [2, 3, 1]),
        ([2, 3, 1], [3, 1, 2]),
        ([3, 1, 2], [3, 2, 1]),
        ([3, 2, 1], [1, 2, 3]),
        ([2, 4, 3, 1], [3, 1, 2, 4]),
        ([2, 4, 4, 3, 1], [3, 1, 2, 4, 4]),
        ([], []),
        ([2], [2]),
        (None, [])
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_next_permutation(self, given, expected):
        actual = nextPermutation(given)
        self.assertEqual(expected, actual)


def nextPermutation(nums: List[int]) -> List[int]:
    if nums is None or len(nums) == 0:
        return []
    i = len(nums) - 1
    j = len(nums) - 1
    # find 1st number which is not in descending order
    while i and nums[i] <= nums[i - 1]:
        i -= 1
    if i == 0:
        # if all in descending order swap all
        nums[:] = nums[::-1]
    else:
        # find 1st number from the right of A[i-1] that is > A[i-1]
        while nums[j] <= nums[i - 1]:
            j -= 1
        # swap A[j] and A[i-1]
        nums[j], nums[i - 1] = nums[i - 1], nums[j]
        # reverse all numbers to the right of A[i-1] so that they are in ascending order
        nums[i:] = nums[i:][::-1]
    return nums


if __name__ == '__main__':
    unittest.main()
