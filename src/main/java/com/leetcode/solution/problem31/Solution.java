package com.leetcode.solution.problem31;

/**
 * 下一个排列
 *
 * @author Ricky
 * @date 2020-11-10 22:53:21
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        if (len == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        int i = len - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            --i;
        }
        if (i != -1) {
            int j = len - 1;
            while (j >= i) {
                if (nums[j] > nums[i]) {
                    break;
                }
                --j;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        int k = i + 1;
        int l = len - 1;
        while (k < l) {
            int temp = nums[k];
            nums[k] = nums[l];
            nums[l] = temp;
            ++k;
            --l;
        }
    }
}
