import unittest
from unittest import TestCase

from parameterized import parameterized


def gcdOfStrings(self, str1: str, str2: str) -> str:
    if str2 + str1 != str1 + str2:
        return ""
    if len(str1) < len(str2):
        temp = str1
        str1 = str2
        str2 = temp
    len1 = len(str1)
    len2 = len(str2)
    while len2 > 0:
        if len1 % len2 == 0 and len(str2) % len2 == 0:
            return str2[0:len2]
        len2 -= 1
    return ""


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ("ABCABC", "ABC", "ABC"),
        ("ABABAB", "ABAB", "AB"),
        ("LEET", "CODE", ""),
        ("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXX")

    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, str1: str, str2: str, expected: str):
        actual = gcdOfStrings(self, str1, str2)
        self.assertEqual(expected, actual)
