import unittest
from collections import deque
from typing import Optional
from unittest import TestCase

from parameterized import parameterized

from com.home.algo.tree.TreeNode import TreeNode


def traverse(root: Optional[TreeNode]) -> Optional[list[list[int]]]:
    if not root:
        return [[]]
    q = deque()
    q.appendleft(root)
    q.appendleft(None)
    res = []
    current_row = []
    while q:
        current_node = q.pop()
        if current_node:
            current_row.append(current_node.val)
            if current_node.left:
                q.appendleft(current_node.left)
            if current_node.right:
                q.appendleft(current_node.right)
        else:
            if q:
                q.appendleft(None)
            res.append(current_row)
            current_row = []
    return res


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        (TreeNode.create_tree_node([2,1,3]), [[2],[1,3]]),
        (TreeNode.create_tree_node([5, 1, 4, None, None, 3, 6]), [[5],[1,4], [3,6]]),
        (TreeNode.create_tree_node([3,9,20,None,None,15,7]), [[3],[9,20],[15,7]]),
        (TreeNode.create_tree_node([1]), [[1]]),
        (TreeNode.create_tree_node([]), [[]])
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_traverse(self, root, expected):
        actual = traverse(root)
        self.assertEqual(expected, actual)
