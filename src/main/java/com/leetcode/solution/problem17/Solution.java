package com.leetcode.solution.problem17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * @author Ricky
 * @date 2020-08-26 20:03:13
 */
public class Solution {
    private final char[][] keyBoard = new char[][] {
        {'a', 'b', 'c', '\0'},
        {'d', 'e', 'f', '\0'},
        {'g', 'h', 'i', '\0'},
        {'j', 'k', 'l', '\0'},
        {'m', 'n', 'o', '\0'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v', '\0'},
        {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        char[] chars = new char[digits.length()];
        int cap = 1;
        for (int i = 0; i < digits.length(); ++i) {
            char[] row = keyBoard[digits.charAt(i) - '2'];
            cap *= row[3] == '\0' ? 3 : 4;
        }
        List<String> result = new ArrayList<>(cap);
        dfs(chars, digits, result, 0);

        return result;
    }

    private void dfs(char[] chars, String digits, List<String> result, int i) {
        if (i == chars.length) {
            result.add(new String(chars));
        } else {
            int rowIndex = digits.charAt(i) - '2';
            char[] row = keyBoard[rowIndex];
            for (int k = 0; k < row.length; ++k) {
                if (row[k] == '\0') {
                    continue;
                }
                chars[i] = row[k];
                dfs(chars, digits, result, i + 1);
            }
        }
    }
}
