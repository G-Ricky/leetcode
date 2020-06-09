package com.leetcode.problem128;

import java.util.Set;
import java.util.TreeSet;

/**
 * 最长连续序列
 *
 * @author Ricky
 * @date 2020-06-06 16:36:55
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Set<Integer> set = new TreeSet<>();

        for (int value : nums) {
            set.add(value);
        }

        int max = 1;
        int len = 1;
        Integer next = null;
        for (Integer num : set) {
            if (num.equals(next)) {
                len++;
            } else {
                if (len > max) {
                    max = len;
                }
                len = 1;
            }
            next = num + 1;
        }
        if (len > max) {
            max = len;
        }

        return max;
    }
}
