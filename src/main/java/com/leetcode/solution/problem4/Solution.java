package com.leetcode.solution.problem4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int index = 0;
        int mod = total % 2;
        int target = total / 2;
        int i = 0, j = 0;

        while (index <= target) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    ++i;
                } else {
                    ++j;
                }
            } else if (i < nums1.length) {
                ++i;
            } else if (j < nums2.length) {
                ++j;
            }

            ++index;
        }

        return 0;
    }
}
