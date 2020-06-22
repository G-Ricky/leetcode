package com.leetcode.solution.problem238;

/**
 * 除自身以外数组的乘积
 *
 * @author Ricky
 * @date 2020-06-04 23:45:45
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1;i < nums.length; ++i) {
            left[i] = left[i - 1] * nums[i - 1];
            int j = nums.length - i - 1;
            right[j] = right[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
}
