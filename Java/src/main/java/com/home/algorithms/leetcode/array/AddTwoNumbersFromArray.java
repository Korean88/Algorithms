package com.home.algorithms.leetcode.array;

import java.util.Objects;

public class AddTwoNumbersFromArray {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String listNodeAsString1 = stringFromListNode(l1);
        String listNodeAsString2 = stringFromListNode(l2);
        int numberOfElementsMin;
        int lengthL1 = listNodeAsString1.length();
        int lengthL2 = listNodeAsString2.length();
        numberOfElementsMin = Math.min(lengthL1, lengthL2);
        StringBuilder resultStringBuilder = new StringBuilder();
        int add = 0;
        for (int i = 0; i < numberOfElementsMin; i++) {
            int sum = fromChar(listNodeAsString1.charAt(i)) + fromChar(listNodeAsString2.charAt(i)) + add;
            add = sum < 10 ? 0 : 1;
            resultStringBuilder.append(sum % 10);
        }

        if (lengthL1 > lengthL2) {
            add = handleDifferentLengths(listNodeAsString1, lengthL1, lengthL2, resultStringBuilder, add);
        } else if (lengthL2 > lengthL1) {
            add = handleDifferentLengths(listNodeAsString2, lengthL2, lengthL1, resultStringBuilder, add);
        }

        if (add == 1) {
            resultStringBuilder.append(1);
        }

        ListNode first = new ListNode(fromChar(resultStringBuilder.charAt(0)));
        listNodeFromString(first, resultStringBuilder.toString(), 1);
        return first;
    }

    private int handleDifferentLengths(String listNodeAsString, int lengthL1, int lengthL2,
                                        StringBuilder resultStringBuilder, int add) {
        for (int i = lengthL2; i < lengthL1; i++) {
            int sum = add + fromChar(listNodeAsString.charAt(i));
            add = sum < 10 ? 0 : 1;
            resultStringBuilder.append(sum % 10);
        }
        return add;
    }

    private void listNodeFromString(ListNode first, String string, int index) {
        if (index == string.length()) return;
        ListNode next = new ListNode(fromChar(string.charAt(index)));
        first.next = next;
        listNodeFromString(next, string, ++index);
    }

    public ListNode addTwoNumbersBruteForce(ListNode l1, ListNode l2) {
        String firstReversed = stringFromListNode(l1);
        int first = reverseString(firstReversed);
        String secondReversed = stringFromListNode(l2);
        int second = reverseString(secondReversed);

        int sum = first + second;
        String sumString = Integer.toString(sum);

        ListNode firstNode = new ListNode(fromChar(sumString.charAt(sumString.length() - 1)));
        if (sumString.length() > 1) {
            listNodeFromInverseString(firstNode, sumString, sumString.length() - 2);
        }
        return firstNode;
    }

    private String stringFromListNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        ListNode current = listNode;
        sb.append(current.val);
        while (current.next != null) {
            sb.append(current.next.val);
            current = current.next;
        }
        return sb.toString();
    }

    private int reverseString(String intInReverseOrder) {
        StringBuilder intInOrder = new StringBuilder();
        for (int i = intInReverseOrder.length() - 1; i >= 0; i--) {
            intInOrder.append(intInReverseOrder.charAt(i));
        }
        return Integer.parseInt(intInOrder.toString());
    }

    private void listNodeFromInverseString(ListNode first, String inverse, int i) {
        if (i < 0) return;
        ListNode second = new ListNode(fromChar(inverse.charAt(i)));
        first.next = second;
        listNodeFromInverseString(second, inverse, --i);
    }

    private int fromChar(char c) {
        return Integer.parseInt(Character.toString(c));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

}
