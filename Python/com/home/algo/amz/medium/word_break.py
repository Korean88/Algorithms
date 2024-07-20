import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    word_lengths = set()
    for w in wordDict:
        word_lengths.add(len(w))
    s_length = len(s)
    boundaries = [False] * (s_length + 1)
    boundaries[0] = True
    for i in range(s_length):
        if boundaries[i]:
            for l in word_lengths:
                max_ind = i + l
                if max_ind <= s_length:
                    current_word = s[i:max_ind]
                    if current_word in wordDict:
                        boundaries[i + l] = True
    return boundaries[s_length]


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ("abcde", ["a", "bc", "c", "de"], True),
        ("leetcode", ["leet", "code"], True),
        ("leetcode", ["code", "leet"], True),
        ("applepenapple", ["apple", "pen"], True),
        ("catsandog", ["cats", "dog", "sand", "and", "cat"], False),
        ("applelep", ["elep", "lep", "apple"], True),
        ("abcdefg", ["bcd", "abc", "def", "efg"], False),
        ("abcdefg", ["bcd", "abc", "def", "efg", "ab"], False)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_wordBreak(self, s, wordDict, expected):
        actual = wordBreak(self, s, wordDict)
        self.assertEqual(expected, actual)
