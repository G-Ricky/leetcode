package com.leetcode.problem703;

import java.util.*;

/**
 * 数据流中的第K大元素
 *
 * @author Ricky
 * @date 2020-06-06 23:06:22
 */
public class KthLargest {

    private LinkedList<Integer> kArray = new LinkedList<>();

    private final int k;

    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        this.k = k;
        for (int i = nums.length - 1; i >= 0 && kArray.size() <= k; --i) {
            kArray.addFirst(nums[i]);
        }
    }

    public int add(int val) {
        if (kArray.isEmpty()) {
            kArray.addFirst(val);
            return val;
        }

        if (val > kArray.peekFirst() || kArray.size() < k) {
            ListIterator<Integer> iterator = kArray.listIterator();
            Integer next;
            boolean hasInserted = false;
            while (iterator.hasNext()) {
                next = iterator.next();
                if (val < next) {
                    iterator.previous();
                    iterator.add(val);
                    hasInserted = true;
                    break;
                }
            }

            if (!hasInserted) {
                iterator.add(val);
            }
        }

        while (kArray.size() > k) {
            kArray.pollFirst();
        }

        return kArray.peekFirst();
    }
}
