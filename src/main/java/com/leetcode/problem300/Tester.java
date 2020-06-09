package com.leetcode.problem300;

public class Tester {

    public static void test() {
        int[] input1 = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        Solution solution = new Solution();

        assert solution.lengthOfLIS(input1) == 4;
    }
}
