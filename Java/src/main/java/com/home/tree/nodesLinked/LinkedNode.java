package com.home.tree.nodesLinked;

import java.util.Objects;

public class LinkedNode {
    String value;
    LinkedNode left, right, next;

    public LinkedNode(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedNode that = (LinkedNode) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(left, that.left) &&
                Objects.equals(right, that.right) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right, next);
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "value='" + value + '\'' +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}
