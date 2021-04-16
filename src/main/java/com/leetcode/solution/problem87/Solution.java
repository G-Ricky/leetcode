package com.leetcode.solution.problem87;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 扰乱字符串
 *
 * @author Ricky
 * @date 2021-04-16 22:04:15
 */
class Solution {

    private final Map<String, Boolean> history = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if (len == 0) {
            return true;
        }
        if (len == 1) {
            return s1.equals(s2);
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        return isScramble(str1, 0, len - 1, str2, 0, len - 1);
    }

    private boolean isScramble(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
        if (start1 == end1) {
            return str1[start1] == str2[start2];
        }
        String key = start1 + "|" + end1 + "|" + start2 + "|" + end2;
        if (history.containsKey(key)) {
            return history.get(key);
        }
        history.put(key, doCompute(str1, start1, end1, str2, start2, end2));
        return history.get(key);
    }

    private boolean doCompute(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
        int i = start1;
        int j = start2;
        int[] countMap = new int[26];
        while (i < end1) {
            char ch1 = str1[i];
            int idx1 = ch1 - 'a';
            countMap[idx1]++;
            char ch2 = str2[j];
            int idx2 = ch2 - 'a';
            countMap[idx2]--;
            if (isAllZero(countMap)) {
                if (isScramble(str1, start1, i, str2, start2, j)
                    && isScramble(str1, i + 1, end1, str2, j + 1, end2)) {
                    return true;
                }
            }
            i++;
            j++;
        }
        i = start1;
        j = end2;
        Arrays.fill(countMap, 0);
        while (i < end1) {
            char ch1 = str1[i];
            int idx1 = ch1 - 'a';
            countMap[idx1]++;
            char ch2 = str2[j];
            int idx2 = ch2 - 'a';
            countMap[idx2]--;
            if (isAllZero(countMap)) {
                if (isScramble(str1, start1, i, str2, j, end2)
                    && isScramble(str1, i + 1, end1, str2, start2, j - 1)) {
                    return true;
                }
            }
            i++;
            j--;
        }
        return false;
    }

    private boolean isAllZero(int[] map) {
        for (int i = 0; i < map.length; ++i) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}