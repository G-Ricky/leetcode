package com.leetcode.solution.problem1030;

/**
 * 距离顺序排列矩阵单元格
 *
 * @author Ricky
 * @date 2020-11-17 23:51:42
 */
public class Solution {

//    private int R;
//
//    private int C;
//
//    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
//        this.R = R;
//        this.C = C;
//        int[][] res = new int[R * C][2];
//        res[0] = new int[] {r0, c0};
//        int count = R * C;
//        int distance = 1;
//        int index = 1;
//        while (index < count) {
//            int left = Math.max(0, c0 - distance);
//            int right = Math.min(C - 1, c0 + distance);
//            int top = Math.max(0, r0 - distance);
//            int bottom = Math.min(R - 1, r0 + distance);
//            int leftDistance = c0 - left;
//            int rightDistance = right - c0;
//            int rightTop = r0 + (rightDistance - distance);
//            int rightBottom = r0 - (rightDistance - distance);
//            int i = r0 - (distance - left);
//            int j = left;
//            while (i > 0 && j < c0) {
//                res[index++] = new int[] {i, j};
//                --i;
//                ++j;
//            }
//            i = top;
//            j = c0 + (distance - top);
//            while (i < r0 && j < C) {
//                res[index++] = new int[] {i, j};
//                ++i;
//                ++j;
//            }
//            i = distance - (right - 1 - c0);
//            j = right - 1;
//        }
//        return res;
//    }
}
