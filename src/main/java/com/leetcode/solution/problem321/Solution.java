package com.leetcode.solution.problem321;

/**
 * 拼接最大数
 * @author Ricky
 * @date 2020-12-02 00:12:09
 */
public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int a = -1;
        int b = -1;
        int needed = k;
        int[] result = new int[k];
        while (true) {
            int max1 = Integer.MIN_VALUE;
            int maxIndex1 = -1;
            for (int i = a + 1; i < nums1.length; ++i) {
                int remaining1 = nums1.length - i;
                int remaining2 = nums2.length - b - 1;
                int remaining = remaining1 + remaining2;
                if (needed <= remaining) {
                    if (nums1[i] > max1) {
                        max1 = nums1[i];
                        maxIndex1 = i;
                    }
                }
            }
            int max2 = Integer.MIN_VALUE;
            int maxIndex2 = -1;
            for (int i = b + 1; i < nums2.length; ++i) {
                int remaining1 = nums1.length - a - 1;
                int remaining2 = nums2.length - i;
                int remaining = remaining1 + remaining2;
                if (needed <= remaining) {
                    if (nums2[i] > max2) {
                        max2 = nums2[i];
                        maxIndex2 = i;
                    }
                }
            }
            if (max1 > max2) {
                a = maxIndex1;
                result[k - needed] = max1;
            } else {
                b = maxIndex2;
                result[k - needed] = max2;
            }
            needed--;
            if (needed == 0) {
                return result;
            }
        }
    }
}
