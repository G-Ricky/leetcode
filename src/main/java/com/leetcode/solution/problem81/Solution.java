package com.leetcode.solution.problem81;

/**
 * 搜索旋转排序数组 II
 *
 * @author Ricky
 * @date 2021-04-07 23:04:28
 */
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // left -> right 不存在旋转的情况
            if (nums[left] < nums[right]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // left -> right 存在旋转的情况
            } else if (nums[left] > nums[right]) {
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                // left == right 如果中间值等于左右说明剩余元素dou
            } else {
                // 中间值小于左边值，说明升序序列在右边
                if (nums[mid] < nums[left]) {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                // 中间值大于左边值，说明升序序列在左边
                } else if (nums[mid] > nums[left]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                // 中间值等于左边值，说明升序序列位置不定，左右范围减一再测试
                } else {
                    left++;
                    right--;
                }
            }
        }
        return false;
    }
}