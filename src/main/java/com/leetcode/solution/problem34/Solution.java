package com.leetcode.solution.problem34;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author Ricky
 * @date 2020-12-01 00:12:20
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                int leftLow = low;
                int leftHigh = mid;
                while (leftLow <= leftHigh) {
                    int leftMid = leftLow + (leftHigh - leftLow) / 2;
                    if (nums[leftMid] < target) {
                        leftLow = leftMid + 1;
                        // 等于
                    } else {
                        leftHigh = leftMid - 1;
                    }
                }
                int rightLow = mid;
                int rightHigh = high;
                while (rightLow <= rightHigh) {
                    int rightMid = rightLow + (rightHigh - rightLow) / 2;
                    if (nums[rightMid] > target) {
                        rightHigh = rightMid - 1;
                        // 等于
                    } else {
                        rightLow = rightMid + 1;
                    }
                }
                return new int[] {leftLow, rightHigh};
            }
        }
        return new int[] {-1, -1};
    }
}
