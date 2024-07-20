package com.home.algorithms.amz.medium;

import com.home.algorithms.amz.model.BinaryTree;

public class PseudoPalindromicPaths {

    int count = 0;

    public int pseudoPalindromicPaths(BinaryTree root) {
        traverse(root, 0);
        return count;
    }

    private void traverse(BinaryTree root, int path) {
        path = path ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            if (isPseudoPalindromic(path)) {
                count++;
            }
        } else {
            if (root.left != null) {
                traverse(root.left, path);
            }
            if (root.right != null) {
                traverse(root.right, path);
            }
        }
    }

    private boolean isPseudoPalindromic(int path) {
        return (path & (path - 1)) == 0;
    }
}
