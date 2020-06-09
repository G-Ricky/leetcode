package com.leetcode.problem703;

import java.util.PriorityQueue;

/**
 * 数据流中的第K大元素
 *
 * @author Ricky
 * @date 2020-06-06 23:06:22
 */
public class KthLargest2 {

    private final PriorityQueue<Integer> queue;

    private final int k;

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            queue.add(nums[i]);
        }
    }

    public int add(int val) {
        queue.add(val);

        while (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }
}
