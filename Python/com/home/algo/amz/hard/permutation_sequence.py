import unittest
from unittest import TestCase

from parameterized import parameterized


def getPermutation(self, n: int, k: int) -> str:
    res_list = []
    used = [False] * n

    def recurse(s):
        if len(res_list) == k:
            return
        if len(s) == n:
            res_list.append(s)
        else:
            for i in range(n):
                if not used[i]:
                    used[i] = True
                    recurse(s + str(i + 1))
                    used[i] = False

    recurse("")
    return res_list.pop()


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        (3, 3, "213"),
        (4, 9, "2314"),
        (3, 1, "123"),
        (3, 2, "132"),
        (4, 14, "3142")
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_permutation_seq(self, n, k, expected):
        actual = getPermutation(self, n, k)
        self.assertEqual(expected, actual)
