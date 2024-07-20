import unittest
from collections import deque
from typing import Optional
from unittest import TestCase

from parameterized import parameterized

from com.home.algo.tree.TreeNode import TreeNode

digits_used = []


def isValidBST(self, root: Optional[TreeNode]) -> bool:
    stack = []
    ordered_list = deque()
    while root or stack:
        while root:
            stack.append(root)
            root = root.left
        root = stack.pop()
        ordered_list.append(root.val)
        root = root.right

    print(ordered_list)
    smallest = ordered_list.popleft()
    while ordered_list:
        current = ordered_list.popleft()
        if current < smallest:
            return False
        smallest = current
    return True


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        (TreeNode.create_tree_node([2, 1, 3]), True),
        (TreeNode.create_tree_node([5, 1, 4, None, None, 3, 6]), False),
        (TreeNode.create_tree_node([100, 50, None, 25, 75, None, 27, 70, 80, None, None, None, 72, 79]), True)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_validate_bst(self, input_list, expected):
        actual = isValidBST(self, input_list)
        self.assertEqual(expected, actual)
