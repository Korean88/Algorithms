import unittest
from typing import Optional
from unittest import TestCase

from parameterized import parameterized

from com.home.algo.tree.TreeNode import TreeNode


def isSubtree(root: Optional[TreeNode], subroot: Optional[TreeNode]) -> bool:

    def is_identical(r, s):
        if not r or not s:
            return r == s
        return r.val == s.val and is_identical(r.left, s.left) and is_identical(r.right, s.right)

    if not root or not subroot:
        return root == subroot
    if is_identical(root, subroot):
        return True
    return isSubtree(root.left, subroot) or isSubtree(root.right, subroot)


if __name__ == '__main__':
    unittest.main()


def params():
    return [
        (TreeNode.create_tree_node([3, 4, 5, 1, 2]), TreeNode.create_tree_node([4, 1, 2]), True),
        (TreeNode.create_tree_node([3, 4, 5, 1, 2, None, None, None, None, 0]), TreeNode.create_tree_node([4, 1, 2]),
         False),
        (None, TreeNode.create_tree_node([4, 1, 2]), False)
    ]


class Test(TestCase):

    @parameterized.expand(params())
    def test_solution(self, root: TreeNode, subroot: TreeNode, expected: bool):
        actual = isSubtree(root, subroot)
        self.assertEqual(expected, actual)
