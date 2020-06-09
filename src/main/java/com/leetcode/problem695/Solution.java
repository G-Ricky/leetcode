package com.leetcode.problem695;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, area(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    private int area(int[][] grid, int row, int col) {
        grid[row][col] = 0;

        int res = 1;

        int newRow = row - 1;
        if (newRow >= 0 && grid[newRow][col] == 1) {
            res += area(grid, newRow, col);
        }

        newRow = row + 1;
        if (newRow < grid.length && grid[newRow][col] == 1) {
            res += area(grid, newRow, col);
        }

        int newCol = col - 1;
        if (newCol >= 0 && grid[row][newCol] == 1) {
            res += area(grid, row, newCol);
        }

        newCol = col + 1;
        if (newCol < grid[0].length && grid[row][newCol] == 1) {
            res += area(grid, row, newCol);
        }

        return res;
    }
}
