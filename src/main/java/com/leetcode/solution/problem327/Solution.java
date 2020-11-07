package com.leetcode.solution.problem327;

/**
 * 区间和的个数
 *
 * @author Ricky
 * @date 2020-11-07 16:58:00
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        long prev = 0;
        long current;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i; j < nums.length; ++j) {
                if (i == j) {
                    current = nums[j];
                } else {
                    current = prev + nums[j];
                }
                if (current >= lower && current <= upper) {
                    ++count;
                }
                prev = current;
            }
        }
        return count;
    }
}
