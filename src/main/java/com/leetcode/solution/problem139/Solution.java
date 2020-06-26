package com.leetcode.solution.problem139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 *
 * @author Ricky
 * @date 2020-06-26 17:11:22
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] isValid = new boolean[s.length() + 1];
        isValid[0] = true;

        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (!isValid[i]) {
                    isValid[i] = isValid[j] && wordSet.contains(s.substring(j, i));
                }
            }
        }

        return isValid[s.length()];
    }
}
