package com.leetcode.problem739;

import java.util.Stack;

/**
 * 每日温度
 *
 * @author Ricky
 * @date 2020-06-11 01:35:37
 */
public class Solution {

    public int[] dailyTemperatures(int[] T) {
        int[] D = new int[T.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                Integer prev;
                while (!stack.isEmpty()) {
                    prev = stack.peek();
                    if (T[i] > T[prev]) {
                        D[prev] = i - prev;
                        stack.pop();
                        System.out.println(T[prev]);
                    } else {
//                        stack.push(i);
                        break;
                    }
                }
                stack.push(i);
            }
        }

        return D;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
