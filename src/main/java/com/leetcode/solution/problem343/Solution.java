package com.leetcode.solution.problem343;

/**
 * 整数拆分
 *
 * @author Ricky
 * @date 2020-07-30 00:39:20
 */
public class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; ++i) {
            for (int j = 2; j <= i - 2; ++j) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }

        return dp[n];
    }
}
