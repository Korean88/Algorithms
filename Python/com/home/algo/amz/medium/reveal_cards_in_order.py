import unittest
from typing import List
from unittest import TestCase

from parameterized import parameterized


def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
    sorted_deck = sorted(deck)
    res = [0] * len(deck)
    skip = False
    ind = 0
    i = 0
    while i < len(deck):
        if res[ind] == 0:
            if not skip:
                res[ind] = sorted_deck[i]
                i += 1
            skip = not skip
        ind = (ind + 1) % len(deck)
    return res

    
if __name__ == '__main__':
    unittest.main()


def params():
    return [
        ([17, 13, 11, 2, 3, 5, 7], [2, 13, 3, 11, 5, 17, 7]),
        ([1, 1000], [1, 1000])
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, deck: List[int], expected: List[int]):
        actual = deckRevealedIncreasing(self, deck)
        self.assertEqual(expected, actual)
