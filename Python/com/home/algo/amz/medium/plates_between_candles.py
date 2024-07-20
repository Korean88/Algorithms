import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def plates_between_candles(self, s: str, queries: List[List[int]]) -> List[int]:
    s_len = len(s)
    near_left = [-1] * s_len
    near_right = [-1] * s_len
    numbers = [0] * s_len
    cur_nearest = -1
    plates = 0
    for i in range(s_len):
        if s[i] == "|":
            cur_nearest = i
        near_left[i] = cur_nearest
        if s[i] == "*":
            plates += 1
        else:
            numbers[i] = plates
    cur_nearest = -1
    for i in range(s_len - 1, -1, -1):
        if s[i] == "|":
            cur_nearest = i
        near_right[i] = cur_nearest

    res = []
    for q in queries:
        left_plate = near_right[q[0]]
        right_plate = near_left[q[1]]
        if left_plate >= right_plate or left_plate < 0 or right_plate < 0:
            res.append(0)
        else:
            res.append(numbers[right_plate] - numbers[left_plate])
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ("**|**|***|", [[2,5],[5,9]], [2,3]),
        ("***|**|*****|**||**|*", [[1,17],[4,5],[14,17],[5,11],[15,16]], [9,0,0,0,0]),
        ("|*|*", [[3,3]], [0]),
        ("*|*||||**|||||||*||*||*||**|*|*||*", [[2,33],[2,32],[3,31],[0,33],[1,24],[3,20],[7,11],[5,32],[2,31],[5,31],[0,31],[3,28],[4,33],[6,29],[2,30],[2,28],[1,30],[1,33],[4,32],[5,30],[4,23],[0,30],[3,10],[5,28],[0,28],[4,28],[3,33],[0,27]], [9,9,9,10,6,4,0,9,9,9,10,7,9,8,8,7,9,10,9,8,5,9,2,7,8,7,9,8])
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, s: str, queries: List[List[int]], expected: List[int]):
        actual = plates_between_candles(self, s, queries)
        self.assertEqual(sorted(expected), sorted(actual))
