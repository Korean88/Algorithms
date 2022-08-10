import unittest
from unittest import TestCase

from parameterized import parameterized


def params():
    return [
        ([0, 4, 8, -1000, 2000, 5000, 8000, 9000], 4),
        ([1, 2, 3, 4, 5, 6, 8, 7, 9, 10], 6),
        ([1, 3, 6, 10, 11], 2),
        ([1, 2, 3, 5, 7, 9], 4),
        ([1, 1, 1], 3),
        ([6, 5, 4, 2, 1, 0, -1], 4),
        ([1, 1, 1, 2, 3, 4, 7, 18, 29, 40, 51], 5),
        ([1, 2, 3], 3),
        ([3, 2, 1], 3),
        ([1, 3], 2),
        ([1], 1),
        ([], 0),
        (None, 0)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_same_spacing(self, given, expected):
        actual = count_same_spacing(given)
        self.assertEqual(expected, actual)


def count_same_spacing(arr):
    if arr is None:
        return 0
    if len(arr) < 3:
        return len(arr)
    space = arr[1] - arr[0]
    current_count, max_count = 2, 2
    index = 1
    while index + 1 < len(arr):
        if arr[index + 1] - arr[index] != space:
            current_count = 2
            space = arr[index + 1] - arr[index]
        else:
            current_count += 1
            max_count = max(max_count, current_count)
        index += 1
    return max_count


if __name__ == '__main__':
    unittest.main()