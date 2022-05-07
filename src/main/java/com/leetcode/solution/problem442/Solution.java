package com.leetcode.solution.problem442;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数组中重复的数据
 *
 * @author Ricky
 * @date 2022-05-08 02:05:53
 */
public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        if (nums.length == 1) {
            return Collections.emptyList();
        }
        if (nums.length == 2 && nums[0] != nums[1]) {
            return Collections.emptyList();
        }
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1) {
                int target = nums[i] - 1;
                if (nums[i] == nums[target]) {
                    break;
                }
                int temp = nums[target];
                nums[target] = nums[i];
                nums[i] = temp;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j] - 1) {
                result.add(nums[j]);
            }
        }
        return result;
    }
}
