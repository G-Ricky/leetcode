package com.leetcode.interview29;

/**
 * 顺时针打印矩阵
 *
 * @author Ricky
 * @date 2020-06-05 00:21:45
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        int row_length = matrix.length;
        if (row_length == 0) {
            return new int[]{};
        }
        int col_length = matrix[0].length;
        if (col_length == 0) {
            return new int[]{};
        }
        if (row_length == 1) {
            return matrix[0];
        }
        int[] ans = new int[row_length * col_length];
        if (col_length == 1) {
            for (int i = 0; i < row_length; ++i) {
                ans[i] = matrix[i][0];
            }
            return ans;
        }

        int i_min = 0;
        int i_max = row_length - 1;
        int j_min = 0;
        int j_max = col_length - 1;
        // 0=右 1=下 2=左 3=上
        int direction = 0;

        int i = 0;
        int j = 0;
        int k = 0;
        while (i >= i_min && i <= i_max && j >= j_min && j <= j_max) {
            ans[k++] = matrix[i][j];
            switch (direction) {
                case 0:
                    if (j == j_max) {
                        direction = 1;
                        i_min++;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case 1:
                    if (i == i_max) {
                        direction = 2;
                        j_max--;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case 2:
                    if (j == j_min) {
                        direction = 3;
                        i_max--;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                default:
                    if (i == i_min) {
                        direction = 0;
                        j_min++;
                        j++;
                    } else {
                        i--;
                    }
                    break;
            }
        }

        return ans;
    }
}
