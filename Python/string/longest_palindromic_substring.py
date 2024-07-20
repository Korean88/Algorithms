import unittest

from parameterized import parameterized


def params():
    return [
        ("abcabbaecdee", "abba"),
        ("abcabtbaecdee", "abtba"),
        ("abacdfgdcaba", "aba"),
        ("a", "a"),
        ("ac", "a"),
        ("aaaa", "aaaa"),
        ("", ""),
        (None, "")
    ]


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_longest_palindrome(self, input_text, expected):
        self.assertEqual(expected, longest_palindrome(input_text))


def longest_palindrome(input_str):
    if input_str is None or len(input_str) == 0:
        return ""
    length = len(input_str)
    if length == 1:
        return input_str
    center = 0.5
    res = input_str[0]
    while center < length - 1:
        left = int(center - 0.5)
        if center % 1 > 0:
            right = int(center + 0.5)
        else:
            right = int(center + 1)
        while input_str[left] == input_str[right]:
            current = input_str[left:right + 1]
            if len(res) < len(current):
                res = current
            left -= 1
            right += 1
            if left < 0 or right > length - 1:
                break
        center += 0.5
    return res


if __name__ == '__main__':
    unittest.main()
