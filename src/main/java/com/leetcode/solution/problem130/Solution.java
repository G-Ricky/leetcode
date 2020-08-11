package com.leetcode.solution.problem130;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 被围绕的区域
 *
 * @author Ricky
 * @date 2020-08-12 00:07:15
 */
public class Solution {

    private int row;

    private int col;

    public void solve(char[][] board) {
        int row = board.length;
        if (row <= 2) {
            return;
        }
        int col = board[0].length;
        if (col <= 2) {
            return;
        }
        this.row = row;
        this.col = col;

        char[][] boardCopy = new char[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                boardCopy[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < row; ++i) {
            if (board[i][0] == 'O') {
                fill(board, i, 0);
            }

            if (board[i][col - 1] == 'O') {
                fill(board, i, col - 1);
            }
        }

        for (int j = 1; j < col - 1; ++j) {
            if (board[0][j] == 'O') {
                fill(board, 0, j);
            }

            if (board[row - 1][j] == 'O') {
                fill(board, row - 1, j);
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == boardCopy[i][j]) {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void fill(char[][] board, int i0, int j0) {
        Set<Position> current = new HashSet<>();
        Set<Position> next = new HashSet<>();

        current.add(new Position(i0, j0));
        while (!current.isEmpty()) {
            for (Position pos : current) {
                board[pos.i][pos.j] = 'X';
                int i = pos.i - 1;
                int j = pos.j;
                if (i >= 0 && board[i][j] == 'O') {
                    next.add(new Position(i, j));
                }
                i = pos.i + 1;
                j = pos.j;
                if (i <= row - 1 && board[i][j] == 'O') {
                    next.add(new Position(i, j));
                }
                i = pos.i;
                j = pos.j - 1;
                if (j >= 0 && board[i][j] == 'O') {
                    next.add(new Position(i, j));
                }
                i = pos.i;
                j = pos.j + 1;
                if (j <= col - 1 && board[i][j] == 'O') {
                    next.add(new Position(i, j));
                }
            }
            current.clear();
            Set<Position> temp = current;
            current = next;
            next = temp;
        }
    }

    static class Position {

        public int i;

        public int j;

        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Position)) {
                return false;
            }

            Position pos = (Position) o;

            return this.i == pos.i && this.j == pos.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
