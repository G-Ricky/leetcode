package com.leetcode.problem36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Ricky
 * @date 2020-06-16 23:14:19
 */
public class Solution2 {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> cells = new HashMap<>();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';

                    Set<Integer> set = rows.get(num);
                    if (set == null) {
                        set = new HashSet<>();
                        rows.put(num, set);
                    }

                    if (!rows.get(num).add(i)) {
                        return false;
                    }

                    set = cols.get(num);
                    if (set == null) {
                        set = new HashSet<>();
                        rows.put(num, set);
                    }
                    if (!cols.get(num).add(j)) {
                        return false;
                    }


                    set = cells.get(num);
                    if (set == null) {
                        set = new HashSet<>();
                        rows.put(num, set);
                    }
                    if (!cells.get(num).add((i / 3) * 3 + (j / 3))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
