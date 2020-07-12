package com.leetcode.solution.problem350;

import java.util.Arrays;

/**
 * 两个数组的交集 II（先排序）
 *
 * @author Ricky
 * @date 2020-07-13 00:55:58
 */
public class SortedSolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersection[index++] = nums1[i];
                ++i;
                ++j;
            } else if (nums1[i] < nums2[j]) {
                ++i;
            } else {
                ++j;
            }
        }

        return Arrays.copyOf(intersection, index);
    }
}
