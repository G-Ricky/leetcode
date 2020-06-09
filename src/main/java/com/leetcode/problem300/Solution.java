package com.leetcode.problem300;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxDp2 = 1;
        for (int i = 1; i < nums.length; ++i) {
            int maxDp = 1;
            boolean hasLesserNumber = false;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    maxDp = Math.max(maxDp, dp[j]);
                    hasLesserNumber = true;
                }
            }


            dp[i] = hasLesserNumber ? maxDp + 1 : 1;
            maxDp2 = Math.max(maxDp2, dp[i]);
        }

        return maxDp2;
    }
}
