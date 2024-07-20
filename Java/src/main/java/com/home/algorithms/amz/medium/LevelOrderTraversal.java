package com.home.algorithms.amz.medium;

import com.home.algorithms.amz.model.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(BinaryTree root) {
        var res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<BinaryTree> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        var current = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            BinaryTree currentNode = q.poll();
            if (currentNode != null) {
                current.add(currentNode.val);
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            } else {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                res.add(current);
                current = new ArrayList<>();
            }
        }
        return res;
    }
}
