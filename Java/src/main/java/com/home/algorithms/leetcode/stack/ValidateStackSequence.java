package com.home.algorithms.leetcode.stack;

import java.util.Stack;

public class ValidateStackSequence {

    boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        int poppedIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            poppedIndex = checkPushedElementsInStack(stack, popped, poppedIndex);
        }
        return stack.isEmpty();
    }

    private int checkPushedElementsInStack(Stack<Integer> stack, int[] popped, int poppedIndex) {
        while (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
            stack.pop();
            poppedIndex++;
        }
        return poppedIndex;
    }

}
