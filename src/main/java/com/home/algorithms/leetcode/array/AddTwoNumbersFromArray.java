package com.home.algorithms.leetcode.array;

import java.util.Objects;

public class AddTwoNumbersFromArray {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String listNodeAsString1 = stringFromListNode(l1);
        String listNodeAsString2 = stringFromListNode(l2);
        //923
        //1234
        //329+4321=4650 -> 0564
        int numberOfElementsMin;
        if (listNodeAsString1.length() < listNodeAsString2.length()) {
            numberOfElementsMin = listNodeAsString1.length();
        } else {
            numberOfElementsMin = listNodeAsString2.length();
        }
        StringBuilder resultStringBuilder = new StringBuilder();
        int add = 0;
        for (int i=0; i<numberOfElementsMin; i++) {
            int sum = fromChar(listNodeAsString1.charAt(i))+fromChar(listNodeAsString2.charAt(i)) + add;
            add = sum < 10 ? 0 : 1;
            resultStringBuilder.append(sum % 10);
        }
        ListNode first = new ListNode(fromChar(resultStringBuilder.charAt(0)));
        rec(first, resultStringBuilder.toString(), resultStringBuilder.length()-1);
        return first;
    }

    public ListNode addTwoNumbersBruteForce(ListNode l1, ListNode l2) {
        String firstReversed = stringFromListNode(l1);
        int first = reverseString(firstReversed);
        String secondReversed = stringFromListNode(l2);
        int second = reverseString(secondReversed);

        int sum = first + second;
        String sumString = Integer.toString(sum);

        ListNode firstNode = new ListNode(fromChar(sumString.charAt(sumString.length()-1)));
        if (sumString.length() > 1) {
            rec(firstNode, sumString, sumString.length() - 2);
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
        for (int i=intInReverseOrder.length()-1; i>=0; i--) {
            intInOrder.append(intInReverseOrder.charAt(i));
        }
        return Integer.parseInt(intInOrder.toString());
    }

    private void rec(ListNode first, String inverse, int i) {
        if (i < 0) return;
        ListNode second = new ListNode(fromChar(inverse.charAt(i)));
        first.next = second;
        rec(second, inverse, --i);
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
