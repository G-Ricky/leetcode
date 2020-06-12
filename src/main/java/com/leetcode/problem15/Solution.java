package com.leetcode.problem15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三数之和
 *
 * @author Ricky
 * @date 2020-06-12 19:48:15
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        Integer prev = null;
        for (int i = 0; i < nums.length - 2; ++i) {
            if (prev != null && prev.equals(nums[i])) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            Integer prevJ = null;
            Integer prevK = null;
            while (j != k) {
                int sum = nums[j] + nums[k];
                if (sum > -nums[i]) {
                    prevK = nums[k];
                    --k;
                } else if (sum < -nums[i]) {
                    prevJ = nums[j];
                    ++j;
                } else {
                    if (prevJ == null || !prevJ.equals(nums[j]) && (prevK == null || !prevK.equals(nums[k]))) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    prevJ = nums[j];
                    ++j;
                    prev = nums[i];
                }
            }
        }

        return result;
    }
}
