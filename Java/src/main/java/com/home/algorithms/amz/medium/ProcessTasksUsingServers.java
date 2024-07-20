package com.home.algorithms.amz.medium;

import java.util.PriorityQueue;

public class ProcessTasksUsingServers {

    public int[] assignTasks(int[] servers, int[] tasks) {
        //So if we have a group of servers with their own next available time
        //if next avaibable time <= the execution time of the task, we need to choose the server with smallest weight
        //can we have 2 PQ, one is sorted by weight and index, this is currently avaiable pq
        //one is sorted by available time, this is currently used server pq
        //[weight, index, avaialbe_time]
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> (a[0] != b[0]) ? (a[0] - b[0]) : (a[1] - b[1]));
        PriorityQueue<int[]> usedQueue = new PriorityQueue<>((a, b)-> {
            int compRes;
            if (a[2] != b[2]) { //time
                compRes = a[2] - b[2];
            } else if (a[0] != b[0]) { //weight
                compRes = a[0] - b[0];
            } else {
                compRes = a[1] - b[1]; //index
            }
            return compRes;
        });
        int n = servers.length;
        int m = tasks.length;
        //O(nLogn)
        for (int i = 0; i < n; i++) {
            freeServers.add(new int[] {servers[i], i, 0}); //weight, index, time of availability
        }
        int[] res = new int[m];
        //O(m * Logn)
        for (int i = 0; i < m; i++) {
            int t = tasks[i];
            while (!usedQueue.isEmpty() && usedQueue.peek()[2] <= i) {
                freeServers.add(usedQueue.poll());
            }
            //If there is no free servers now, we can find the used server with smallest available time
            if (freeServers.isEmpty()) {
                int[] cur = usedQueue.poll();
                res[i] = cur[1];
                cur[2] += t;
                usedQueue.add(cur);
            } else {
                int[] cur = freeServers.poll();
                res[i] = cur[1];
                cur[2] = i + t;
                usedQueue.add(cur);
            }
        }
        return res;
    }
}
