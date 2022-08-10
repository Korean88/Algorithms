import unittest

from parameterized import parameterized


def params():
    return [
        ("aqwertpapeiu", 7),
        ("aqwebbtapbiu", 6),
        ("aqwerbyabnmdfa", 7),
        ("abcdebfc", 5),
        ("abcdecopdqwrtyui", 12),
        ("abcaecopdaec", 6),
        ("abcaecaopdbcq", 7),
        ("aabbcc", 2),
        ("a", 1),
        ("aa", 1),
        ("aaa", 1),
        ("", 0),
        (None, 0)
    ]


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_longest_substring(self, input_text, expected):
        self.assertEqual(expected, longest_size(input_text))


def longest_size(input_str):
    if input_str is None or len(input_str) == 0:
        return 0
    length = len(input_str)
    start, end, max_count = 0, 0, 0
    while end < length:
        letters = input_str[start:end]
        if letters.count(input_str[end]) > 0:
            start += 1
        else:
            end += 1
        current_count = end - start
        max_count = max(current_count, max_count)
    return max_count


if __name__ == '__main__':
    unittest.main()
