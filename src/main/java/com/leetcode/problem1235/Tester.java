package com.leetcode.problem1235;

public class Tester {

    public static void test() {
        Solution solution = new Solution();

        int[] startTime1 = new int[]{1, 2, 3, 3},
            endTime1 = new int[]{3, 4, 5, 6},
            profit1 = new int[]{50, 10, 40, 70};

        int[] startTime2 = new int[]{1, 2, 3, 4, 6},
            endTime2 = new int[]{3, 5, 10, 6, 9},
            profit2 = new int[]{20, 20, 100, 70, 60};

        int[] startTime3 = new int[]{1, 1, 1},
            endTime3 = new int[]{2, 3, 4},
            profit3 = new int[]{5, 6, 4};

        assert solution.jobScheduling(startTime1, endTime1, profit1) == 120;
        assert solution.jobScheduling(startTime2, endTime2, profit2) == 150;
        assert solution.jobScheduling(startTime3, endTime3, profit3) == 6;
    }
}
