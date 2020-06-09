package com.leetcode.problem239;

import java.util.Arrays;

/**
 * @author Ricky
 * @date 2020-06-07 20:00:51
 */
public class TestCases2 {

    public static void test() {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] ans1 = {3, 3, 5, 5, 6, 7};
        int[] nums2 = {7, 2, 4};
        int k2 = 2;
        int[] ans2 = {7, 4};

        Solution2 solution = new Solution2();
        assert Arrays.equals(solution.maxSlidingWindow(nums1, k1), ans1);
        assert Arrays.equals(solution.maxSlidingWindow(nums2, k2), ans2);
    }
}
