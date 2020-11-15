package com.leetcode.solution.problem402;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 移掉K位数字
 *
 * @author Ricky
 * @date 2020-11-15 16:29:23
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        Deque<Character> stack = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < num.length(); ++i) {
            char ch = num.charAt(i);
            while (j < k && !stack.isEmpty()) {
                char top = stack.peek();
                if (top > ch) {
                    stack.pop();
                    ++j;
                } else {
                    break;
                }
            }
            stack.push(ch);
        }
        while (j < k && !stack.isEmpty()) {
            stack.pop();
            ++j;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        char[] ans = new char[stack.size()];
        int i = ans.length - 1;
        int nonZero = i;
        while (!stack.isEmpty()) {
            char val = stack.pop();
            if (val != '0') {
                nonZero = i;
            }
            ans[i--] = val;
        }
        return String.valueOf(ans, nonZero, ans.length - nonZero);
    }
}
