package com.leetcode.solution.problem435;

import java.util.Arrays;

/**
 * 无重叠区间
 *
 * @author Ricky
 * @date 2023-01-31 21:01:08
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return o1[1] > o2[1]
                    ? 1
                    : (o1[1] < o2[1] ? -1 : 0);
            }
        });
        int n = intervals.length;
        int[] dp = new int[n];
        int max = 1;
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return n - max;
    }
}
