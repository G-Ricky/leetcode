package com.leetcode.solution.problem33;

/**
 * 搜索旋转排序数组
 *
 * @author Ricky
 * @date 2021-03-29 23:03:49
 */
class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return find(nums, 0, nums.length - 1, target);
    }

    private int find(int[] nums, int start, int end, int target) {
        if (end - start == 1) {
            return nums[start] == target
                ? start
                : (nums[end] == target ? end : -1);
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (start == mid || mid == end) {
            return nums[mid] == target
                ? mid
                : -1;
        }
        if (nums[start] < nums[mid]) {
            if (nums[start] <= target && target <= nums[mid]) {
                return find(nums, start, mid - 1, target);
            } else {
                return find(nums, mid + 1, end, target);
            }
        } else {
            if (nums[mid] <= target && target <= nums[end]) {
                return find(nums, mid + 1, end, target);
            } else {
                return find(nums, start, mid - 1, target);
            }
        }
    }
}
