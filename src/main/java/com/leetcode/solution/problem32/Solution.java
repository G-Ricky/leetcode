package com.leetcode.solution.problem32;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 *
 * @author Ricky
 * @date 2020-07-04 21:03:58
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        boolean[] flags = new boolean[s.length()];

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                // ')'
                if (!stack.isEmpty()) {
                    Integer currentMatch = stack.pop();
                    flags[i] = true;
                    flags[currentMatch] = true;
                }
            }
        }

        int maxLength = 0;
        int length = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (flags[i]) {
                ++length;
            } else {
                maxLength = Math.max(maxLength, length);
                length = 0;
            }
        }

        return Math.max(maxLength, length);
    }
}
