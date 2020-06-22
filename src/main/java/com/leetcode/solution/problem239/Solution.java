package com.leetcode.solution.problem239;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 滑动窗口最大值
 *
 * @author Ricky
 * @date 2020-06-07 18:34:20
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int[] ans = new int[nums.length - k + 1];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; ++i) {
            queue.add(nums[i]);
        }

        for (int i = 0; i < ans.length; ++i) {
            ans[i] = queue.peek();
            if (i < ans.length - 1) {
                queue.remove(nums[i]);
                queue.add(nums[i + k]);
            }
        }

        return ans;
    }
}
