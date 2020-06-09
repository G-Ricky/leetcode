package com.leetcode.problem121;

public class Tester {

    public static void test() {
        Solution solution = new Solution();

        int [] input1 = new int[] {7, 1, 5, 3, 6, 4};
        int [] input2 = new int[] {7, 6, 4, 3, 1};

        assert solution.maxProfit(input1) == 5;
        assert solution.maxProfit(input2) == 0;
    }

    public static void testStandard() {
        StandardSolution solution = new StandardSolution();

        int [] input1 = new int[] {7, 1, 5, 3, 6, 4};
        int [] input2 = new int[] {7, 6, 4, 3, 1};

        assert solution.maxProfit(input1) == 5;
        assert solution.maxProfit(input2) == 0;
    }
}
