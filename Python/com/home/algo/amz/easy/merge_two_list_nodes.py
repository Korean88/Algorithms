import unittest
from typing import Optional

from parameterized import parameterized

from list_node.list_node import ListNode


def params():
    return [
        (create_node([1, 2, 4]), create_node([1, 3, 4]), create_node([1, 1, 2, 3, 4, 4])),
        (create_node([1]), create_node([2]), create_node([1, 2])),
        (create_node([1]), create_node([2, 3]), create_node([1, 2, 3])),
        (create_node([1, 2]), create_node([3]), create_node([1, 2, 3])),
        (create_node([-2, 0, 1, 3, 5]), create_node([-3, -1, 0, 2, 4]), create_node([-3, -2, -1, 0, 0, 1, 2, 3, 4, 5])),
        (None, create_node([-3, -1, 0, 2, 4]), create_node([-3, -1, 0, 2, 4])),
        (create_node([-3, -1, 0, 2, 4]), None, create_node([-3, -1, 0, 2, 4])),
        (None, None, None)
    ]


def create_node(args):
    head = None
    if args is not None:
        length = len(args)
        if length != 0:
            head = ListNode(args[0], None)
            res = head
            if length > 1:
                for i in range(1, length):
                    res.next = ListNode(args[i], None)
                    res = res.next
    return head


if __name__ == '__main__':
    unittest.main()


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_merge_iterative(self, list_node1, list_node2, expected):
        merged = merge_iterative(list_node1, list_node2)
        self.assertEqual(expected, merged)

    @parameterized.expand(params())
    def test_merge_recursive(self, list_node1, list_node2, expected):
        merged = merge_recursive(list_node1, list_node2)
        self.assertEqual(expected, merged)


def merge_iterative(list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    dummy_head = current = ListNode()
    while list1 and list2:
        if list1.value < list2.value:
            current.next = list1
            list1 = list1.next
        else:
            current.next = list2
            list2 = list2.next
        current = current.next
    current.next = list1 or list2
    return dummy_head.next


def merge_recursive(list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    if list1 and list2:
        if list1.value < list2.value:
            list1.next = merge_recursive(list1.next, list2)
            return list1
        else:
            list2.next = merge_recursive(list1, list2.next)
            return list2
    else:
        return list1 or list2


if __name__ == '__main__':
    unittest.main()
