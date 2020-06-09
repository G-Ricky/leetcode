package com.leetcode.problem239;

/**
 * 滑动窗口最大值
 *
 * @author Ricky
 * @date 2020-06-07 18:34:20
 */
public class Solution2 {

    private int max = 0;

    private int maxIndex = -1;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < ans.length; ++i) {
            int newValueIndex = i + k - 1;
            int newValue = nums[newValueIndex];
            // 最大值不在窗口内
            if (maxIndex < i || maxIndex >= i + k) {
                updateWindowMax(nums, i, k);
            } else if (newValue > max) {
                max = newValue;
                maxIndex = newValueIndex;
            }

            ans[i] = nums[maxIndex];
        }

        return ans;
    }

    public void updateWindowMax(int[] nums, int startIndex, int windowSize) {
        maxIndex = -1;
        for (int i = 0; i < windowSize; ++i) {
            int index = i + startIndex;
            // maxIndex < 0 为未初始化的情况
            if (maxIndex < 0 || nums[index] >= max) {
                maxIndex = index;
                max = nums[maxIndex];
            }
        }
    }
}
