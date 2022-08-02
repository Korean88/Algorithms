import unittest

from parameterized import parameterized

from algorithms.list_node.list_node import ListNode


def params():
    return [
        (create_node(["1", "2", "4"]), False),
        (create_node(["1", "2", "1"]), True),
        (create_node(["1", "2", "2", "2", "1"]), True),
        (create_node(["1", "3", "2", "3", "1"]), True),
        (create_node(["1", "4", "2", "3", "1"]), False),
        (create_node(["1"]), True),
        (create_node(["wa", "ba"]), False),
        (create_node(["ae", "ae"]), True),
        (create_node(["ae", "ea"]), False),
        (None, False)
    ]


def create_node(args):
    head = None
    if args is not None:
        length = len(args)
        if length != 0:
            head = ListNode(args[0], None)
            pointer = head
            if length > 1:
                for i in range(1, length):
                    pointer.next = ListNode(args[i], None)
                    pointer = pointer.next
    return head


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_palindrome(self, list_node, expected):
        is_palindrome = check_palindrome(list_node)
        self.assertEqual(expected, is_palindrome)


def check_palindrome(node):
    if node is None:
        return False
    node2 = node
    stack = [node.value]
    while node.next is not None:
        node = node.next
        stack.append(node.value)
    half_size = round(len(stack) / 2)
    for i in range(half_size):
        if stack.pop() != node2.value:
            return False
        node2 = node2.next
    return True
