package com.leetcode.solution.problem1365;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 有多少小于当前数字的数字
 *
 * @author Ricky
 * @date 2020-10-26 01:23:23
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums.length <= 1) {
            return new int[nums.length];
        }
        Map<Integer, Integer> firstIndexMap = new TreeMap<>();
        for (int num : nums) {
            int count = firstIndexMap.computeIfAbsent(num, k -> 0);
            firstIndexMap.put(num, count + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : firstIndexMap.entrySet()) {
            int val = entry.getValue();
            entry.setValue(sum);
            sum += val;
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = firstIndexMap.get(nums[i]);
        }
        return ans;
    }
}
