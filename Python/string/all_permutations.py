import unittest

from parameterized import parameterized


def params():
    return [
        ("abc", ["abc", "acb", "bac", "bca", "cab", "cba"]),
        ("cba", ["cba", "abc", "acb", "bac", "bca", "cab"]),
        ("aba", ["aba", "baa", "aab"]),
        ("aabc", ["aabc", "aacb", "abac", "abca", "acab", "acba", "baac", "baca", "bcaa", "caab", "caba", "cbaa"]),
        ("a", ["a"]),
        ("ab", ["ab", "ba"]),
        ("", []),
        (None, [])
    ]


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_compress(self, input_text, expected):
        self.assertEqual(expected, collect_permutations(input_text))


def collect_permutations(str):
    res = []
    if str is None or len(str) == 0:
        return res
    res.append(str)
    next_permutation = find_next(str)
    while res.count(next_permutation) == 0:
        res.append(next_permutation)
        next_permutation = find_next(next_permutation)
    return res


def find_next(str):
    array = list(str)
    i = len(str) - 1
    while i and str[i] <= str[i-1]:
        i -= 1
    if i == 0:
        res = "".join(array[::-1])
    else:
        j = len(str) - 1
        if str[j] <= str[i-1]:
            while str[j] <= str[i-1]:
                j -= 1
        array[i-1], array[j] = array[j], array[i-1]
        array[i:] = array[i:][::-1]
        res = "".join(array)
    return res


if __name__ == '__main__':
    unittest.main()