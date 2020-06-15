package com.leetcode.problem8;

/**
 * 字符串转换整数 (atoi)
 * @author Ricky
 * @date 2020-06-16 00:18:45
 */
public class Solution {

    private final int START = 0;

    private final int DIGIT = 1;

    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int state = START;
        int num = 0;
        int lower = -(Integer.MIN_VALUE / 10);
        int upper = Integer.MAX_VALUE / 10;
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);

            switch (state) {
                case START:
                    if (ch == '+' || ch == '-') {
                        sign = str.charAt(i) == '+'
                            ? 1
                            : -1;
                        state = DIGIT;
                    } else if (ch >= '0' && ch <= '9') {
                        sign = 1;
                        state = DIGIT;
                        num += ch - '0';
                    } else if (ch != ' ') {
                        return 0;
                    }
                    // space
                    break;
                case DIGIT:
                    if (ch >= '0' && ch <= '9') {
                        if (sign > 0 && (num > upper || num == upper && ch > '7')) { // 检查上界
                            return Integer.MAX_VALUE;
                        } else if (sign < 0 && (num > lower || num == lower && ch > '8')) { // 检查下界
                            return Integer.MIN_VALUE;
                        }
                        num *= 10;
                        num += ch - '0';
                    } else {
                        return num * sign;
                    }
                    break;
                default:
                    return 0;
            }
        }

        return num * sign;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
    }
}
