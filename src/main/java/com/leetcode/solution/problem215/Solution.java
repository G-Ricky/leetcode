package com.leetcode.solution.problem215;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数组中的第K个最大元素
 *
 * @author Ricky
 * @date 2020-06-29 22:33:43
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k + 1);

        for (int num : nums) {
            queue.offer(num);
            while (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
