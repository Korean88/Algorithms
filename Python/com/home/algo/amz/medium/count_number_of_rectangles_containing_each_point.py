import sys
import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def countRectangles(self, rectangles: List[List[int]], points: List[List[int]]) -> List[int]:
    h_to_l = {}
    for i in range(len(rectangles)):
        if not h_to_l.get(rectangles[i][1]):
            lengths = []
            h_to_l[rectangles[i][1]] = lengths
        h_to_l[rectangles[i][1]].append(rectangles[i][0])
    for k, v in h_to_l.items():
        v = sorted(v)
        h_to_l[k] = v

    def find_closest_index(lengths, x):
        left = 0
        right = len(lengths) - 1
        if lengths[left] > x:
            return 0
        if lengths[right] < x:
            return len(lengths)
        mid = int(right / 2)
        closest = mid
        while left <= right:
            if lengths[mid] == x:
                return mid
            if lengths[mid] < x:
                closest = right + 1
                left = mid + 1
            else:
                closest = mid
                right = mid - 1
            mid = int((right + left) / 2)
        return closest

    res = []
    for p in points:
        y = p[1]
        current = 0
        for i in range(y, 101):
            lengths = h_to_l.get(i)
            if lengths:
                ind = find_closest_index(lengths, p[0])
                current += (len(lengths) - ind)
        res.append(current)
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([[1, 2], [2, 3], [2, 5]], [[2, 1], [1, 4]], [2, 1]),
        ([[1, 1], [2, 2], [3, 3]], [[1, 3], [1, 1]], [1, 3]),
        ([[1, 1], [2, 2], [3, 3], [4, 1], [3, 1]], [[1, 3], [1, 1]], [1, 5]),
        ([[81, 69], [85, 18], [4, 89], [2, 23], [29, 25],
          [19, 98], [77, 74], [100, 98], [61, 5],
          [11, 57], [23, 4], [2, 55], [8, 77], [23, 79],
          [4, 69], [4, 33], [44, 69], [93, 47], [77, 4],
          [44, 91], [11, 54], [35, 67], [59, 90], [34, 59],
          [16, 25], [93, 6], [37, 14], [88, 51], [13, 69],
          [16, 26], [77, 7], [6, 63], [3, 41], [90, 89],
          [97, 35], [75, 49], [96, 94], [80, 16], [96, 59]], [[26, 16], [58, 70], [64, 58], [52, 2], [85, 98],
                                                              [75, 93], [12, 3], [2, 25], [79, 90], [36, 35],
                                                              [45, 40], [12, 34], [2, 71], [63, 88], [74, 91],
                                                              [78, 90], [73, 19], [95, 92], [43, 7], [9, 28]], [18, 5, 6, 17, 1, 2, 29, 30, 2, 13, 10, 18, 10, 3, 2, 2, 10, 2, 16, 20])
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, rectangles: List[List[int]], points: List[List[int]], expected: List[int]):
        actual = countRectangles(self, rectangles, points)
        self.assertEqual(expected, actual)
