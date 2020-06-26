package com.leetcode.solution.problem41;

/**
 * 缺失的第一个正数
 *
 * @author Ricky
 * @date 2020-06-27 01:08:34
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= 0) {
                nums[i] = -1;
            } else {
                min = Math.min(min, nums[i]);
            }
        }

        if (min != 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != -1 && nums[i] != i + 1) {
                if (nums[i] <= 0 || nums[i] > nums.length) {
                    nums[i] = -1;
                    break;
                }
                int idx = nums[i] - 1;
                if (nums[i] == nums[idx]) {
                    nums[i] = -1;
                }
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }
        }

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == -1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
