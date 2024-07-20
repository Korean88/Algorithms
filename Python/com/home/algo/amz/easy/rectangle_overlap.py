import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def solution(self, rec1: List[int], rec2: List[int]) -> bool:
    top = rec1[3] <= rec2[1]
    bottom = rec1[1] >= rec2[3]
    left = rec1[0] >= rec2[2]
    right = rec1[2] <= rec2[0]
    is_line = rec1[0] == rec1[2] or rec1[1] == rec1[3] or rec2[0] == rec2[2] or rec2[1] == rec2[3]
    return not top and not bottom and not left and not right and not is_line


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([0, 0, 2, 2], [1, 1, 3, 3], True),
        ([0, 0, 1, 1], [1, 0, 2, 1], False),
        ([0, 0, 1, 1], [2, 2, 3, 3], False),
        ([2, 17, 6, 20], [3, 8, 6, 20], True),
        ([1, 1, 3, 1], [0, 0, 4, 2], False)  # first rectangle is a line
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, rec1: List[int], rec2: List[int], expected: bool):
        actual = solution(self, rec1, rec2)
        self.assertEqual(expected, actual)
