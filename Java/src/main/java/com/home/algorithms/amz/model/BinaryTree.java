package com.home.algorithms.amz.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    public int val;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree() {
    }

    public BinaryTree(int val) {
        this.val = val;
    }

    public BinaryTree(int val, BinaryTree left, BinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static BinaryTree createFromList(List<Integer> ints) {
        BinaryTree res = null;
        if (ints != null && !ints.isEmpty()) {
            Iterator<Integer> iterator = ints.iterator();
            Queue<BinaryTree> q = new LinkedList<>();
            BinaryTree head = new BinaryTree(iterator.next());
            res = head;
            q.add(head);
            while (!q.isEmpty()) {
                BinaryTree current = q.poll();
                if (current != null) {
                    if (iterator.hasNext()) {
                        Integer left = iterator.next();
                        if (left != null) {
                            BinaryTree leftNode = new BinaryTree(left);
                            current.left = leftNode;
                            q.add(leftNode);
                        }
                    }
                    if (iterator.hasNext()) {
                        Integer right = iterator.next();
                        if (right != null) {
                            BinaryTree rightNode = new BinaryTree(right);
                            current.right = rightNode;
                            q.add(rightNode);
                        }
                    }
                }
            }
        }
        return res;
    }
}
