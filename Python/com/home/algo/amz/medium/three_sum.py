import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def threeSum(self, nums: List[int]) -> List[List[int]]:
    res = []
    nums = sorted(nums)
    for i in range(len(nums) - 2):
        if i == 0 or nums[i] != nums[i - 1]:
            left = i+1
            right = len(nums) - 1
            while left < right:
                threesum = nums[i] + nums[left] + nums[right]
                if threesum == 0:
                    res.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while left < right:
                        if nums[left] == nums[left-1]:
                            left += 1
                        elif nums[right] == nums[right + 1]:
                            right -= 1
                        else:
                            break
                elif threesum < 0:
                    left += 1
                elif threesum > 0:
                    right -= 1
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([-1,0,1,2,-1,-4], [[-1,-1,2],[-1,0,1]]),
        ([0,1,1], []),
        ([0,0,0], [[0,0,0]]),
        ([0,0,0,0], [[0,0,0]]),
        ([-2, 0, 1, 1, 2], [[-2,0,2],[-2,1,1]]),
        ([34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49], [[-82,-11,93],[-82,13,69],[-82,17,65],[-82,21,61],[-82,26,56],[-82,33,49],[-82,34,48],[-82,36,46],[-70,-14,84],[-70,-6,76],[-70,1,69],[-70,13,57],[-70,15,55],[-70,21,49],[-70,34,36],[-66,-11,77],[-66,-3,69],[-66,1,65],[-66,10,56],[-66,17,49],[-49,-6,55],[-49,-3,52],[-49,1,48],[-49,2,47],[-49,13,36],[-49,15,34],[-49,21,28],[-43,-14,57],[-43,-6,49],[-43,-3,46],[-43,10,33],[-43,12,31],[-43,15,28],[-43,17,26],[-29,-14,43],[-29,1,28],[-29,12,17],[-14,-3,17],[-14,1,13],[-14,2,12],[-11,-6,17],[-11,1,10],[-3,1,2]])
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, nums: List[int], expected: List[List[int]]):
        actual = threeSum(self, nums)
        self.assertEqual(len(expected), len(actual))
        for s in actual:
            self.assertTrue(s in expected)
