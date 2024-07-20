import unittest
from unittest import TestCase

from parameterized import parameterized


def change(self, amount: int, coins: list[int]) -> int:
    memo = [0] * amount
    for c in coins:
        if c > amount:
            continue
        for i in range(c - 1, amount):
            if i == c - 1:
                memo[i] = memo[i] + 1
            else:
                memo[i] = memo[i] + memo[i - c]
    return memo[amount - 1]


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        (5, [1, 2, 5], 4),
        (7, [2, 3, 5], 2),
        (3, [2], 0),
        (10, [10], 1)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_change(self, amount, coins, expected):
        actual = change(self, amount, coins)
        self.assertEqual(expected, actual)
