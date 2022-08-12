package com.home.algorithms.leetcode.listnode;

import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString() {
        ListNode ln = this;
        StringBuilder sb = new StringBuilder("[");
        while (ln != null) {
            sb.append(ln.val).append(",");
            ln = ln.next;
        }
        return sb.replace(sb.length() - 1, sb.length(), "").append("]").toString();
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
}
