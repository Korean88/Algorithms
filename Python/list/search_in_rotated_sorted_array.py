import unittest
from unittest import TestCase

from parameterized import parameterized


def params():
    return [
        ([4, 5, 6, 7, 0, 1, 2], 0, 4),
        ([4, 5, 6, 7, 0, 1, 2], 3, -1),
        ([5, 6, 7, 0, 1, 2, 3, 4], 0, 3),
        ([5, 6, 7, 0, 1], 1, 4),
        ([1, 3], 1, 0),
        ([1], 0, -1),
        ([1], 1, 0),
        ([], 0, -1),
        (None, 0, -1)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_search(self, array, target, expected):
        actual = search(array, target)
        self.assertEqual(expected, actual)


def search(arr, target):
    if arr is None or len(arr) == 0:
        return -1
    start = 0
    end = len(arr) - 1
    while start <= end:
        mid = int((end - start) / 2) + start
        if arr[mid] == target:
            return mid
        if arr[start] <= arr[mid]:
            if arr[start] <= target < arr[mid]:
                end = mid - 1
            else:
                start = mid + 1
        else:
            if arr[mid] < target <= arr[end]:
                start = mid + 1
            else:
                end = mid - 1
    return -1


if __name__ == '__main__':
    unittest.main()
