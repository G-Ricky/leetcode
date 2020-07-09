package com.leetcode.solution.interview1713;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 恢复空格
 *
 * @author Ricky
 * @date 2020-07-09 22:50:58
 */
public class Solution {
    public int respace(String[] dictionary, String sentence) {
        if (dictionary.length == 0) {
            return sentence.length();
        }
        if (sentence.length() == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>(Arrays.asList(dictionary));

        int[] dp = new int[sentence.length() + 1];
        for (int i = 0; i < sentence.length(); ++i) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= i; ++j) {
                if (set.contains(sentence.substring(j, i + 1))) {
                    max = Math.max(max, dp[j] + i - j + 1);
                }
            }
            dp[i + 1] = Math.max(max, dp[i]);
        }

        return sentence.length() - dp[sentence.length()];
    }
}
