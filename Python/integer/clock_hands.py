import unittest

from parameterized import parameterized


def params():
    return [
        ((12, 0), 0),
        ((3, 0), 90),
        ((6, 0), 180),
        ((6, 2), 169),
        ((9, 0), 90),
        ((4, 0), 120),
        ((7, 0), 150),
        ((8, 0), 120),
        ((12, 30), 165),
        ((3, 30), 75),
        ((12, 1), 5.5)
    ]


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_calculate_angle(self, input_tuple, expected):
        self.assertEqual(expected, calculate_angle(input_tuple))


def calculate_angle(input_tuple):
    hours = input_tuple[0] % 12
    minutes = input_tuple[1]
    angle_h = hours * 30 + minutes * 0.5
    angle_m = minutes * 6
    angle_dif = abs(angle_m - angle_h)
    if angle_dif > 180:
        angle_dif = 360 - angle_dif
    return angle_dif


if __name__ == '__main__':
    unittest.main()
