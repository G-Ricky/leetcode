package com.leetcode.solution.problem1002;

import java.util.*;

/**
 * 查找常用字符
 *
 * @author Ricky
 * @date 2020-10-14 21:47:56
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> cmpMap = new HashMap<>();
        int len = 0;
        boolean isFirst = true;
        for (String a : A) {
            Map<Character, Integer> currentMap = new HashMap<>();
            for (int i = 0; i < a.length(); ++i) {
                char ch = a.charAt(i);
                int count = currentMap.computeIfAbsent(ch, k -> 0);
                currentMap.put(ch, count + 1);
                if (isFirst) {
                    len++;
                }
            }
            if (isFirst) {
                cmpMap.putAll(currentMap);
                isFirst = false;
                continue;
            }
            Iterator<Map.Entry<Character, Integer>> iterator;
            for (iterator = cmpMap.entrySet().iterator(); iterator.hasNext(); ){
                Map.Entry<Character, Integer> entry = iterator.next();
                Integer currentCount = currentMap.get(entry.getKey());
                Integer cmpCount = entry.getValue();
                if (currentCount == null) {
                    len -= cmpCount;
                    iterator.remove();
                } else if (currentCount < cmpCount) {
                    len -= cmpCount - currentCount;
                    entry.setValue(currentCount);
                }
            }
        }
        List<String> result = new ArrayList<>(len > 0 ? len : 1);
        for (Map.Entry<Character, Integer> entry : cmpMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); ++i) {
                result.add(String.valueOf(entry.getKey()));
            }
        }
        return result;
    }
}