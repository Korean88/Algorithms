package com.home.algorithms.crackingbook.linkedlist;

import java.util.Stack;

public class LinkedListPalindrome {

    boolean isPalindrome(LinkedListNode head) {
        if (head == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        LinkedListNode node = head;
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }
        int size = stack.size();
        int counter = 0;
        while (counter <= size/2) {
            if (!stack.pop().equals(head.value)) {
                return false;
            }
            head = head.next;
            counter++;
        }
        return true;
    }
}
