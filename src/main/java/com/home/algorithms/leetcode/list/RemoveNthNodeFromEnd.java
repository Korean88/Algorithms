package com.home.algorithms.leetcode.list;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class RemoveNthNodeFromEnd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            ListNode listNode = this;
            StringBuilder sb = new StringBuilder("ListNode{");
            while (listNode != null) {
                sb.append(listNode.val).append("->");
                listNode = listNode.next;
            }
            sb.append("null}");
            return sb.toString();
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode copyHead = head;
        while (copyHead != null) {
            size++;
            copyHead = copyHead.next;
        }

        if (size - n == 0) {
            return head.next;
        }
        copyHead = head;
        for (int i=1;  i < size; i++) {
            if (n == size - i) {
                copyHead.next = copyHead.next.next;
                break;
            } else {
                copyHead = copyHead.next;
            }
        }
        return head;
    }

    public ListNode removeWithQueue(ListNode head, int n) {
        if (head == null) return null;
        Queue<Integer> queue = new LinkedList<>();
        ListNode copyHead = head;
        while (copyHead != null) {
            queue.add(copyHead.val);
            copyHead = copyHead.next;
        }
        int i = 0;
        int size = queue.size();
        int targetIndex = size - n;
        ListNode tempListNode = null;
        ListNode res = null;
        while (i < size) {
            int current;
            if (i == targetIndex) {
                queue.remove();
                i++;
                continue;
            } else {
                current = queue.poll();
            }
            if (tempListNode == null) {
                tempListNode = new ListNode(current);
                res = tempListNode;
            } else {
                tempListNode.next = new ListNode(current);
                tempListNode = tempListNode.next;
            }
            i++;
        }
        return res;
    }
}
