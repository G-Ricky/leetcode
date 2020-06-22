package com.leetcode.solution.problem22;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 *
 * @author Ricky
 * @date 2020-06-13 00:26:05
 */
public class Solution {

    private int size;

    private final List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Collections.singletonList("()");
        }
        if (n == 2) {
            return Arrays.asList("(())", "()()");
        }

        size = n << 1;
        char[] parenthesis = new char[size];

        getParenthesis(parenthesis, '(', n - 1, n, 0);

        return result;
    }

    private void getParenthesis(char[] parenthesis, char p, int left, int right, int level) {
        if (level >= size) {
            return;
        }

        parenthesis[level] = p;

        if (level == size - 1) {
            result.add(new String(parenthesis));
            return;
        }

        if (right >= left && left > 0) {
            getParenthesis(parenthesis, '(', left - 1, right, level + 1);
        }

        if (left < right && right > 0) {
            getParenthesis(parenthesis, ')', left, right - 1, level + 1);
        }
    }
}
