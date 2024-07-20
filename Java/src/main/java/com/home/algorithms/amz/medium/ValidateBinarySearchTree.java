package com.home.algorithms.amz.medium;

import com.home.algorithms.amz.model.BinaryTree;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public boolean isValidBST(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            } else {
                prev = root;
            }
            root = root.right;
        }
        return true;
    }

    public boolean recursive(BinaryTree root) {
        return rec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean rec(BinaryTree root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < max && root.val > min) {
            return rec(root.left, min, root.val) && rec(root.right, root.val, max);
        }
        return false;
    }
}
