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
    center = 0
    end = 1
    length = len(input_str)
    result = input_str[0]
    while end < length:
        center += 0.5
        if center % 1 == 0.5:
            start = int(center - 0.5)
            end = int(center + 0.5)
        else:
            start = int(center - 1)
            end = int(center + 1)
        while start >= 0 and end < length:
            if input_str[start] == input_str[end]:
                substring = input_str[int(start):int(end)+1]
                if len(substring) > len(result):
                    result = substring
                end += 1
                start -= 1
            else:
                break
    return result


if __name__ == '__main__':
    unittest.main()
