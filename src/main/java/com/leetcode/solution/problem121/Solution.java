package com.leetcode.solution.problem121;

class Solution {

    public int maxProfit(int[] prices) {

        int max = 0;

        for (int i = 0; i < prices.length - 1; ++i) {
            for (int j = i + 1; j < prices.length; ++j) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                }
            }
        }

        return max;
    }
}
