import unittest
from typing import List, LiteralString
from unittest import TestCase

from parameterized import parameterized


def generateParenthesis(self, n: int) -> List[str]:
    res = []

    def recurse(left, right, current):
        if len(current) == n * 2:
            res.append(current)
            return
        if left < n:
            recurse(left + 1, right, current + ")")
        if right < left:
            recurse(left, right + 1, current + "(")

    recurse(0, 0, "")
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        (3, ["((()))", "(()())", "(())()", "()(())", "()()()"]),
        (1, ["()"])
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_recursive(self, n: int, expected: List[LiteralString]):
        actual = generateParenthesis(self, n)
        self.assertEqual(len(expected), len(actual))
        for s in actual:
            self.assertIn(s, actual)
