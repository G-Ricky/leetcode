package com.leetcode.solution.problem37;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解数独
 *
 * @author Ricky
 * @date 2020-06-17 00:08:07
 */
public class Solution {

    private final int SIZE = 9;

    private final Queue<Position> queue = new LinkedList<>();

    private final boolean[][][] flags = new boolean[SIZE][SIZE][SIZE];

    private final int[][] lengths = new int[SIZE][SIZE];

    private char[][] board;

    public void solveSudoku(char[][] board) {

        this.board = board;

        // 初始化标记数组
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                // 设置全部值为可取
                if (board[i][j] == '.') {
                    for (int k = 0; k < SIZE; ++k) {
                        flags[i][j][k] = true;
                    }
                    lengths[i][j] = SIZE;
                    // 设置仅当前值为可取
                } else {
                    int val = board[i][j] - '1';
                    flags[i][j][val] = true;
                    lengths[i][j] = 1;
                    queue.add(new Position(val, i, j));
                }
            }
        }

        // 预处理
        while (!queue.isEmpty()) {
            Position position = queue.poll();

            process(position.row, position.col, position.val);
        }

        // TODO 未完 ...
    }

    private void process(int row, int col, int val) {
        for (int i = 0; i < SIZE; ++i) {
            // 不等于自身所在的行
            if (i != row) {
                setImpossible(i, col, val);
            }
            // 不等于自身所在的列
            if (i != col) {
                setImpossible(row, i, val);
            }

            int r = row / 3 * 3 + i / 3;
            int c = col / 3 * 3 + i % 3;
            // 不等于自身所在的位置
            if (r != row || c != col) {
                setImpossible(r, c, val);
            }
        }
    }

    private void setImpossible(int row, int col, int val) {
        assert lengths[row][col] >= 1;
        if (flags[row][col][val] && lengths[row][col] > 1) {
            // 排除该值
            flags[row][col][val] = false;
            --lengths[row][col];
            // 发现值
            if (lengths[row][col] == 1) {
                int singleValue = getSingleValue(flags[row][col]);
                board[row][col] = (char) (singleValue + '1');
                queue.add(new Position(singleValue, row, col));
            }
        }
    }

    private int getSingleValue(boolean[] valueFlag) {
        int value = -1;
        for (int i = 0; i < SIZE; ++i) {
            if (valueFlag[i]) {
                assert value == -1;
                value = i;
            }
        }
        assert value != -1;

        return value;
    }

    static class Position {
        public int val;

        public int row;

        public int col;

        public Position(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {

        char[][] input1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] input2 = {
            {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
            {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
            {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
            {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
            {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
            {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };

        Solution solution = new Solution();
        solution.solveSudoku(input1);
        solution.solveSudoku(input2);
    }
}
