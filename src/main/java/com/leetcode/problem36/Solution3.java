package com.leetcode.problem36;

/**
 * @author Ricky
 * @date 2020-06-16 23:18:04
 */
public class Solution3 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] cells = new boolean[9][9];


        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (rows[num][i]) {
                        return false;
                    } else {
                        rows[num][i] = true;
                    }

                    if (cols[num][j]) {
                        return false;
                    } else {
                        cols[num][j] = true;
                    }

                    int cellIndex = (i / 3) * 3 + (j / 3);
                    if (cells[num][cellIndex]) {
                        return false;
                    } else {
                        cells[num][cellIndex] = true;
                    }
                }
            }
        }

        return true;
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

        Solution3 solution = new Solution3();
        System.out.println(solution.isValidSudoku(input1));
    }
}
