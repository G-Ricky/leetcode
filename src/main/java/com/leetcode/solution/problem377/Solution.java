package com.leetcode.solution.problem377;

import java.util.*;

/**
 * 组合总和 Ⅳ
 *
 * @author Ricky
 * @date 2021-04-24 14:04:03
 */
class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        return cs4(nums, target);
    }

    private int cs4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            int newTarget = target - nums[i];
            if (!map.containsKey(newTarget)) {
                map.put(newTarget, cs4(nums, newTarget));
            }
            count += map.get(newTarget);
        }
        return count;
    }

}