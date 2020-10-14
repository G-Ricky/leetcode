package com.leetcode.solution.problem1002;

import java.util.*;

/**
 * 查找常用字符
 *
 * @author Ricky
 * @date 2020-10-14 21:47:56
 */
public class ArraySolution {
    public List<String> commonChars(String[] A) {
        int[] cmpMap = new int[26];
        int len = 0;
        boolean isFirst = true;
        for (String a : A) {
            int[] currentMap = new int[26];
            for (int i = 0; i < a.length(); ++i) {
                char ch = a.charAt(i);
                currentMap[ch - 'a']++;
                if (isFirst) {
                    len++;
                }
            }
            if (isFirst) {
                System.arraycopy(currentMap, 0, cmpMap, 0, currentMap.length);
                isFirst = false;
                continue;
            }
            for (int i = 0; i < cmpMap.length; i++) {
                if (cmpMap[i] == 0) {
                    continue;
                }
                len -= cmpMap[i] - currentMap[i];
                cmpMap[i] = Math.min(cmpMap[i], currentMap[i]);
            }
        }
        List<String> result = new ArrayList<>(len > 0 ? len : 1);
        for (int i = 0; i < cmpMap.length; i++) {
            for (int j = 0; j < cmpMap[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}