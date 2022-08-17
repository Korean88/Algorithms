import unittest

from parameterized import parameterized


def params():
    return [
        ("abc", "cbaa", True),
        ("qwe", "abwczbreqqq", True),
        ("", "", False),
        ("asd", "", False),
        (None, "asd", False),
        ("asd", None, False),
        ("tyu", "abcdef", False),
        ("tyu", "abcdefty", False),
        ("tyu", "abcdeftyu", True)
    ]


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_palindrome(self, note, magazine, expected):
        self.assertEqual(expected, can_assemble_ransom_note(note, magazine))


def can_assemble_ransom_note(ransomNote, magazine):
    if ransomNote is None or len(ransomNote) == 0 or magazine is None or len(magazine) == 0 or len(magazine) < len(ransomNote):
        return False
    dictionary = []
    for i in range(26):
        dictionary.append(0)
    a = ord("a")
    for l in magazine:
        dictionary[ord(l) - a] += 1
    for l in ransomNote:
        dictionary[ord(l) - a] -= 1
        if dictionary[ord(l) - a] < 0:
            return False
    return True


if __name__ == '__main__':
    unittest.main()
