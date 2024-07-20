import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def solution(self, s: str) -> List[str]:
    res = []

    def rec(current, i):
        if len(current) == len(s):
            res.append(current)
        else:
            while not s[i].isalpha():
                current += s[i]
                i += 1
                if len(current) == len(s):
                    res.append(current)
                    return
            rec(current + s[i], i + 1)
            rec(current + s[i].swapcase(), i + 1)

    rec("", 0)
    return res

if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ("a1b2", ["a1b2","a1B2","A1b2","A1B2"]),
        ("3z4", ["3z4","3Z4"]),
        ("z", ["z","Z"]),
        ("1", ["1"]),
        ("12", ["12"]),
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, s: str, expected: List[str]):
        actual = solution(self, s)
        self.assertEqual(len(expected), len(actual))
        for s in actual:
            self.assertTrue(s in expected)
