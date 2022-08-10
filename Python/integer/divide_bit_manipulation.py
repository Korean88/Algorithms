import unittest

from parameterized import parameterized


def params():
    return [
        ((10, 3), 3),
        ((10, 4), 2),
        ((7, -3), -2),
        ((-7, -3), 2),
        ((0, -3), 0),
        ((-2 ** 31 - 1, 1), -2 ** 31),
        ((2 ** 31, 1), 2 ** 31 - 1)
    ]


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_divide_with_restriction(self, input_tuple, expected):
        self.assertEqual(expected, divide_using_bit_manipulations(input_tuple))


def divide_using_bit_manipulations(input_tuple):
    dividend = input_tuple[0]
    divisor = input_tuple[1]
    is_negative = (dividend < 0) != (divisor < 0)
    if dividend < 0:
        dividend *= -1
    if divisor < 0:
        divisor *= -1

    result = 0
    times_doubled = 1
    current_divisor = divisor
    while dividend >= divisor:
        if dividend >= current_divisor:
            dividend -= current_divisor
            result += times_doubled
            current_divisor = current_divisor << 1
            times_doubled = times_doubled << 1
        else:
            current_divisor = current_divisor >> 1
            times_doubled = times_doubled >> 1
    if is_negative:
        result = -1 * result
    if result > 2 ** 31 - 1:
        result = 2 ** 31 - 1
    elif result < -2 ** 31:
        result = -2 ** 31
    return result


if __name__ == '__main__':
    unittest.main()
