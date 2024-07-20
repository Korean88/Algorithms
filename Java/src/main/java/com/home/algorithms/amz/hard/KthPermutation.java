package com.home.algorithms.amz.hard;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        List<String> allPerms = new ArrayList<>();
        recurse(used, allPerms, "", n, k);
        return allPerms.get(k - 1);
    }

    private void recurse(boolean[] used, List<String> allPerms, String currentPerm, int n, int k) {
        if (allPerms.size() == k) {
            return;
        }
        if (currentPerm.length() == n) {
            allPerms.add(currentPerm);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i-1]) {
                used[i-1]=true;
                recurse(used, allPerms, currentPerm + i, n, k);
                used[i-1] = false;
            }
        }
    }

}
