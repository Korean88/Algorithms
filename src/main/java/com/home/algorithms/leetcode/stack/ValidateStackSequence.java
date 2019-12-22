package com.home.algorithms.leetcode.stack;

import java.util.Stack;

public class ValidateStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }

        Stack<Integer> tempStack = new Stack<>();
        int poppedIdx = 0;
        for (int i=0; i<pushed.length; i++) {
            tempStack.push(pushed[i]);
            if (tempStack.peek() == popped[poppedIdx]) {
                tempStack.pop();
                poppedIdx = checkPrevious(tempStack, popped, ++poppedIdx);
            } else if (poppedIdx == popped.length - 1) {
                return false;
            }
        }
        return true;
    }

    private int checkPrevious(Stack<Integer> tempStack, int[] popped, int poppedIdx) {
        while (tempStack.size() != 0) {
            if (popped[poppedIdx] == tempStack.peek()) {
                tempStack.pop();
                poppedIdx++;
            } else {
                return poppedIdx;
            }
        }
        return poppedIdx;
    }
}
