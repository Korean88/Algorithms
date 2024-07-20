import unittest
from unittest import TestCase

from parameterized import parameterized


def solution(n, k, target):
    MOD = 10 ** 9 + 7
    current_arr = [0] * target
    for i in range(target):
        if i < k:
            current_arr[i] = 1

    def calc_sum(arr, cur_ind):
        res = 0
        counter = 0
        for i in range(cur_ind - 1, -1, -1):
            if counter == k:
                break
            res = (res + arr[i]) % MOD
            counter += 1
        return res

    dice = 1
    while dice < n:
        dice += 1
        next_arr = [0] * target
        for i in range(dice - 1, target):
            next_arr[i] = calc_sum(current_arr, i)
        current_arr = next_arr
    return current_arr[target - 1]


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        (2, 3, 6, 1),
        (2, 6, 7, 6),
        (2, 6, 6, 5),
        (2, 6, 5, 4),
        (3, 6, 5, 6),
        (3, 6, 6, 10),
        (3, 6, 7, 15),
        (3, 3, 6, 7),
        (3, 3, 7, 6)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, n, k, target, expected):
        actual = solution(n, k, target)
        self.assertEqual(expected, actual)
