import sys
import unittest
from unittest import TestCase

from parameterized import parameterized


def knightDialer(self, n: int) -> int:
    sys.setrecursionlimit(6000)
    moves_map = [[4, 6], [6, 8], [7, 9], [4, 8],
                 [0, 3, 9], [], [0, 1, 7],
                 [2, 6], [1, 3], [2, 4]]
    cache = {}

    def rec(left, position):
        rec_res = 0
        if left == 0:
            return 1
        moves = moves_map[position]
        for m in moves:
            if cache.get(str(left - 1) + "." + str(m)):
                cur = cache[str(left - 1) + "." + str(m)]
            else:
                cur = rec(left - 1, m)
                cache[str(left - 1) + "." + str(m)] = cur
            rec_res += cur
            rec_res = rec_res % (10 ** 9 + 7)
        return rec_res

    res = 0
    for i in range(10):
        res += rec(n-1, i)
    return res % (10 ** 9 + 7)


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        (1, 10),
        (2, 20),
        (3131, 136006598)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, n: int, expected: int):
        actual = knightDialer(self, n)
        self.assertEqual(expected, actual)
