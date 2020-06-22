package com.leetcode.solution.problem238;

import java.util.Arrays;

/**
 * @author Ricky
 * @date 2020-06-04 23:52:12
 */
public class Tester {

    public static void test() {
        int[] nums = new int[] {1, 2, 3, 4};
        int[] ans = new int[] {24, 12, 8, 6};

        Solution solution = new Solution();
        assert Arrays.equals(solution.productExceptSelf(nums), ans) ;
    }
}
