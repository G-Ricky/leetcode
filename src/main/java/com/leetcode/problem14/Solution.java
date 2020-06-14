package com.leetcode.problem14;

/**
 * 最长公共前缀
 *
 * @author Ricky
 * @date 2020-06-15 01:25:39
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; ++i) {
            if (strs[i].length() == 0) {
                return "";
            }
            if (min > strs[i].length()) {
                min = strs[i].length();
            }
        }
        int i = 0;
        outer:
        for (; i < min; ++i) {
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    break outer;
                }
            }
        }

        return strs[0].substring(0, i);
    }
}
