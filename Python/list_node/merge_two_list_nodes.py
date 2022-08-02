import unittest
from typing import Optional

from parameterized import parameterized

from algorithms.list_node.list_node import ListNode


def params():
    return [
        (create_node([1, 2, 4]), create_node([1, 3, 4]), create_node([1, 1, 2, 3, 4, 4])),
        (create_node([1]), create_node([2]), create_node([1, 2])),
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


class MyTestCase(unittest.TestCase):

    @parameterized.expand(params())
    def test_merge_iterative(self, list_node1, list_node2, expected):
        merged = merge_iterative(list_node1, list_node2)
        self.assertEqual(expected, merged)

    @parameterized.expand(params())
    def test_merge_sorting(self, list_node1, list_node2, expected):
        merged = merge_sorting(list_node1, list_node2)
        self.assertEqual(expected, merged)


def merge_iterative(list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    if list1 is not None and list2 is not None:
        value1 = list1.value
        value2 = list2.value
        if value1 < value2:
            head = ListNode(value1, None)
            list1 = list1.next
        else:
            head = ListNode(value2, None)
            list2 = list2.next
    elif list2 is None:
        return list1
    else:
        return list2
    res = head
    while list1 is not None or list2 is not None:
        if list1 is not None and list2 is not None:
            if list1.value < list2.value:
                res.next = ListNode(list1.value, None)
                res = res.next
                list1 = list1.next
            else:
                res.next = ListNode(list2.value, None)
                res = res.next
                list2 = list2.next
        elif list1 is None:
            res.next = list2
            list2 = None
        else:
            res.next = list1
            list1 = None
    return head


def merge_sorting(node1: Optional[ListNode], node2: Optional[ListNode]) -> Optional[ListNode]:
    list = []
    while node1 is not None:
        list.append(node1.value)
        node1 = node1.next
    while node2 is not None:
        list.append(node2.value)
        node2 = node2.next
    length = len(list)
    if length != 0:
        list.sort()
        head = ListNode(list[0], None)
        pointer = head
        for i in range(1, length):
            pointer.next = ListNode(list[i], None)
            pointer = pointer.next
    else:
        head = None
    return head


if __name__ == '__main__':
    unittest.main()