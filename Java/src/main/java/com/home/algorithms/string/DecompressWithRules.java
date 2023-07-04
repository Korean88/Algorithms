package com.home.algorithms.string;

import java.util.*;

//Qualtrics task

public class DecompressWithRules {

    public String decompress(char symbol, List<String> compositionRules, List<String> generationRules) {
        Map<String, String> compositionRulesMap = rulesToMap(compositionRules);
        Map<String, String> generationRulesMap = rulesToMap(generationRules);
        String compositionString = fromCompositionRules(compositionRulesMap, Character.toString(symbol));
        StringBuilder sb = new StringBuilder();
        for (String c : compositionString.split("")) {
            sb.append(generationRulesMap.getOrDefault(c, ""));
        }
        return sb.toString();
    }

    private String fromCompositionRules(Map<String, String> compositionRulesMap, String symbol) {
        Queue<String> queue = new LinkedList<>();
        queue.add(symbol);
        int size = queue.size();
        int i = 0;
        boolean modifiedQueue = false;
        while (modifiedQueue || i < size) {
            String poll = queue.poll();
            if (compositionRulesMap.containsKey(poll)) {
                String mapValue = compositionRulesMap.get(poll);
                queue.addAll(Arrays.asList(mapValue.split("")));
                modifiedQueue = true;
            } else {
                queue.add(poll);
            }
            i++;
            if (i == size && modifiedQueue) {
                size = queue.size();
                i = 0;
                modifiedQueue = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }


    private Map<String, String> rulesToMap(List<String> rules) {
        Map<String, String> map = new HashMap<>();
        for (String r : rules) {
            map.put(r.substring(0, 1), r.substring(2));
        }
        return map;
    }
}
