package com.leetcode.solution.interview29;

import java.util.Arrays;

/**
 * @author Ricky
 * @date 2020-06-05 00:22:20
 */
public class Tester {

    public static void test() {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix3 = new int[][]{{3}, {2}};

        Solution solution = new Solution();
        assert Arrays.equals(
            solution.spiralOrder(matrix1),
            new int[]{1,2,3,6,9,8,7,4,5}
        );

        assert Arrays.equals(
            solution.spiralOrder(matrix2),
            new int[] {1,2,3,4,8,12,11,10,9,5,6,7}
        );

        assert Arrays.equals(
            solution.spiralOrder(matrix3),
            new int[] {3, 2}
        );

    }
}
