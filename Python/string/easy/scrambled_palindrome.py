import unittest

from parameterized import parameterized


def params():
    return [
        ("otorr", True),
        ("abc", False),
        ("bbbaabc", True),
        ("baba", True),
        ("127271", True),
        ("a", True),
        ("", False),
        (None, False)
    ]


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_palindrome(self, input_text, expected):
        self.assertEqual(expected, is_scrambled_palindrome(input_text))


def is_scrambled_palindrome(str):
    if str is None or len(str) == 0:
        return False
    map = {}
    for s in str:
        if map.get(s) is None:
            map[s] = 1
        else:
            map[s] = map[s] + 1
    odd = len(str) % 2 == 1
    for entry in map.items():
        if entry[1] % 2 == 1 and odd:
            odd = False
        elif entry[1] % 2 == 1:
            return False
    return True


if __name__ == '__main__':
    unittest.main()