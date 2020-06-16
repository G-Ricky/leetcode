package com.leetcode.problem36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有效的数独
 *
 * @author Ricky
 * @date 2020-06-16 22:14:13
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> cells = new HashMap<>();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';

                    if (!rows.computeIfAbsent(num, k -> new HashSet<>()).add(i)) {
                        return false;
                    }

                    if (!cols.computeIfAbsent(num, k -> new HashSet<>()).add(j)) {
                        return false;
                    }

                    if (!cells.computeIfAbsent(num, k -> new HashSet<>()).add((i / 3) * 3 + (j / 3))) {
                        return false;
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

        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(input1));
    }
}
