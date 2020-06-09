package com.leetcode.problem1013;

public class Tester {

    public static void test() {
        int[] input1 = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        int[] input2 = new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        int[] input3 = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        int[] input4 = new int[]{1, -1, 1, -1};

        Solution solution = new Solution();

        assert solution.canThreePartsEqualSum(input1) == true;
        assert solution.canThreePartsEqualSum(input2) == false;
        assert solution.canThreePartsEqualSum(input3) == true;
        assert solution.canThreePartsEqualSum(input4) == false;
    }
}
