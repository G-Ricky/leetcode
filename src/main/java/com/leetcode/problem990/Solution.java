package com.leetcode.problem990;

import com.leetcode.LeetCode;

import java.util.*;

/**
 * 等式方程的可满足性
 *
 * @author Ricky
 * @date 2020-06-08 23:13:23
 */
@LeetCode
public class Solution {
    public boolean equationsPossible(String[] equations) {
        if (equations.length == 1) {
            return equations[0].charAt(0) != equations[0].charAt(3) || equations[0].charAt(1) != '!';
        }
        Map<Character, Set<Character>> nextMap = new HashMap<>();
        List<String> nonEqualList = new LinkedList<>();

        for (String equation : equations) {
            char left = equation.charAt(0);
            char right = equation.charAt(3);
            char operator = equation.charAt(1);
            if (operator == '=') {
                Set<Character> leftNext = nextMap.computeIfAbsent(left, k -> new HashSet<>());
                Set<Character> rightNext = nextMap.computeIfAbsent(right, k -> new HashSet<>());
                if (!Objects.equals(left, right)) {
                    leftNext.add(right);
                    rightNext.add(left);
                }
            } else {
                if (Objects.equals(left, right)) {
                    return false;
                }
                nonEqualList.add(equation);
            }
        }

        Set<Character> visiteds = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        for (String equation : nonEqualList) {
            char left = equation.charAt(0);
            char right = equation.charAt(3);
            queue.add(left);
            while (!queue.isEmpty()) {
                Character current = queue.poll();
                visiteds.add(current);
                Set<Character> next = nextMap.get(current);
                if (next != null && !next.isEmpty()) {
                    for (Character c : next) {
                        if (visiteds.contains(c)) {
                            continue;
                        }
                        if (c.equals(right)) { // left 与 right 互通，与 != 矛盾
                            return false;
                        }
                        queue.add(c);
                    }
                }
            }

            visiteds.clear();
        }

        return true;
    }
}
