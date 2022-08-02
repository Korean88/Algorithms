import unittest

from parameterized import parameterized


def params():
    return [
        ("abc", "a1b1c1"),
        ("aabc", "a2b1c1"),
        ("aabcc", "a2b1c2"),
        ("aabbc", "a2b2c1"),
        ("aabbcc", "a2b2c2"),
        ("a", "a1"),
        ("aa", "a2"),
        ("", ""),
        (None, ""),
    ]


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_compress(self, input_text, expected):
        self.assertEqual(expected, compress(input_text))


def compress(input_str):
    if input_str is None or len(input_str) == 0:
        return ""
    length = len(input_str)
    if length == 1:
        return input_str + "1"
    count = 1
    res = ""
    for i in range(length - 1):
        if input_str[i] == input_str[i + 1]:
            count += 1
            if i == length - 2:
                res += input_str[i] + str(count)
        elif i == length - 2:
            res = res + input_str[i] + str(count) + input_str[i+1] + "1"
        else:
            res = res + input_str[i] + str(count)
            count = 1
    return res


if __name__ == '__main__':
    unittest.main()
