package com.home.algorithms.goldmansachs.tree;

public class HeightBalanced {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
    }

    boolean isHeightBalanced(TreeNode root) {
        int maxHeight = countMax(root, 0);
        int minHeight = countMin(root, 0);
        return maxHeight-minHeight<=1;
    }

    private int countMax(TreeNode treeNode, int count) {
        if (treeNode.left != null && treeNode.right != null) {
            return Integer.max(countMax(treeNode.left, count+1), countMax(treeNode.right, count+1));
        } else if (treeNode.left == null && treeNode.right != null) {
            return countMax(treeNode.right, count+1);
        } else if (treeNode.left != null && treeNode.right == null) {
            return countMax(treeNode.left, count+1);
        } else { //both nulls
            return count;
        }
    }

    private int countMin(TreeNode treeNode, int count) {
        if (treeNode.left != null && treeNode.right != null) {
            return Integer.min(countMin(treeNode.left, count+1), countMin(treeNode.right, count+1));
        } else {
            return count;
        }
    }
}
