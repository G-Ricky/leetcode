package com.leetcode.solution.problem50;

/**
 * Pow(x, n)
 * @author Ricky
 * @date 2020-06-15 22:59:50
 */
public class Solution {

    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        } else if (x == -1) {
            return (n & 1) == 0
                ? 1
                : -1;
        } else if (n > 0) {
            return myPow2(x, n, 1);
        } else if (n == 0x80000000) {
            return 0;
        } else if (n < 0) {
            return 1 / myPow2(x, -n, 1);
        } else {
            return 1;
        }
    }

    private double myPow2(double x, int n, double extra) {
        if (n <= 1) {
            return x * extra;
        }

        if (n % 2 == 1) {
            extra *= x;
        }

        return myPow2(x * x, n / 2, extra);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, 10));
        System.out.println(solution.myPow(2, -2));
        System.out.println(solution.myPow(2.1, 3));
        System.out.println(solution.myPow(2, -2147483648));
        System.out.println(-2147483648 & 1);
    }
}
