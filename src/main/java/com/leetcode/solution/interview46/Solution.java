package com.leetcode.solution.interview46;

/**
 * 把数字翻译成字符串
 *
 * @author Ricky
 * @date 2020-06-09 21:58:16
 */
public class Solution {

    public int translateNum(int num) {
        int[] nums = new int[11];
        int i = 0;
        do {
            nums[i++] = num % 10;
        } while ((num /= 10) > 0);

        // 反转数组
        for (int j = 0; j < i / 2; ++j) {
            int temp = nums[j];
            nums[j] = nums[i - j - 1];
            nums[i - j - 1] = temp;
        }

        return f(nums, i - 1);
    }

    private int f(int[] nums, int i) {
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            if (nums[i - 1] == 1 || nums[i - 1] == 2 && nums[i] >= 0 && nums[i] <= 5) {
                return 2;
            } else {
                return 1;
            }
        } else {
            if (nums[i - 1] == 1 || nums[i - 1] == 2 && nums[i] >= 0 && nums[i] <= 5) {
                return f(nums, i - 1) + f(nums, i - 2);
            } else {
                return f(nums, i - 1);
            }
        }
    }
}
