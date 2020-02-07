package com.home.algorithms.crackingbook.linkedlist;

import java.util.Objects;

public class LinkedListNode {
    char value;
    LinkedListNode next;

    public LinkedListNode(char value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListNode that = (LinkedListNode) o;
        return value == that.value &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
