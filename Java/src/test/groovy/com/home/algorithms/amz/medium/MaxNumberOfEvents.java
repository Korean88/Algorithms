package com.home.algorithms.amz.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxNumberOfEvents {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparing(e -> e[0]));
        int res = 0;
        Queue<Integer> q = new PriorityQueue<>();
        int i = 0;
        int day = -1;
        while (i < events.length || !q.isEmpty()) {
            if (q.isEmpty()) {
                day = events[i][0];
            }
            while (i < events.length && events[i][0] == day) {
                q.offer(events[i++][1]);
            }
            res++;
            q.poll();
            while (!q.isEmpty() && q.peek() == day) {
                q.poll();
            }
            day++;
        }
        return res;
    }

}
