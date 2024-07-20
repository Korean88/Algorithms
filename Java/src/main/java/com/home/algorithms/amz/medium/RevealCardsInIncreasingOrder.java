package com.home.algorithms.amz.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {

    //2 3 5 7 11 13 17
    //0 5 1 4
    //2 13 3 11 5 17 7
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            q.offer(i);
        }
        var res = new int[deck.length];
        int i = 0;
        while (!q.isEmpty()) {
            int index = q.poll();
            res[index] = deck[i++];
            if (q.size() > 1) {
                q.offer(q.poll());
            }
        }
        return res;
    }
}
