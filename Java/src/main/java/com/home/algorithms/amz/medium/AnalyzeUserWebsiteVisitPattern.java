package com.home.algorithms.amz.medium;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        var visitTreeSet = new TreeSet<Visit>(Comparator.comparing(Visit::getTime));
        for (int i = 0; i < username.length; i++) {
            visitTreeSet.add(new Visit(timestamp[i], username[i], website[i]));
        }
        var map = new HashMap<String, List<String>>();
        for (var v : visitTreeSet) {
            var list = map.getOrDefault(v.user, new ArrayList<String>());
            list.add(v.site);
            map.put(v.user, list);
        }
        var maxScore = 0;
        String thePattern = null;
        var patternCount = new HashMap<String, Integer>();
        for (var l : map.values()) {
            if (l.size() >= 3) {
                var uniquePatternForCurUser = new HashSet<String>();
                for (int i = 0; i < l.size() - 2; i++) {
                    for (int j = i + 1; j < l.size() - 1; j++) {
                        for (int k = j + 1; k < l.size(); k++) {
                            var pattern = new StringBuilder()
                                    .append(l.get(i))
                                    .append(".")
                                    .append(l.get(j))
                                    .append(".")
                                    .append(l.get(k))
                                    .toString();
                            if (!uniquePatternForCurUser.add(pattern)) {
                                continue;
                            }
                            var curCount = patternCount.getOrDefault(pattern, 0) + 1;
                            patternCount.put(pattern, curCount);
                            if (curCount == maxScore) {
                                if (thePattern == null || thePattern.compareTo(pattern) > 0) {
                                    thePattern = pattern;
                                }
                            } else if (curCount > maxScore) {
                                thePattern = pattern;
                                maxScore = curCount;
                            }
                        }
                    }
                }
            }
        }
        if (thePattern != null) {
            var split = thePattern.split("\\.");
            return Arrays.asList(split);
        }
        return null;
    }

    private static class Visit {
        int time;
        String user;
        String site;
        Visit(int timestamp, String username, String website) {
            time = timestamp;
            user = username;
            site = website;
        }

        int getTime() {
            return time;
        }
    }

}
