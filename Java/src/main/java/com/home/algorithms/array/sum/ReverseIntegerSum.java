package com.home.algorithms.array.sum;

public class ReverseIntegerSum {

    public static class Node {
        int val;
        Node next;

        public Node(int x) {
            val = x;
        }
    }

    Node sum(Node n1, Node n2) {
        int overflown = 0;
        Node res = new Node(0);
        Node head = res;
        while (n1 != null || n2 != null) {
            int a;
            int currentSum = (n1 != null ? n1.val : 0) + (n2 != null ? n2.val : 0) + overflown;
            a = currentSum % 10;
            overflown = currentSum / 10;
            n1 = n1 == null ? null : n1.next;
            n2 = n2 == null ? null : n2.next;
            head.next = new Node(a);
            head = head.next;
        }
        if (overflown > 0) {
            head.next = new Node(overflown);
        }
        return res.next;
    }

}
