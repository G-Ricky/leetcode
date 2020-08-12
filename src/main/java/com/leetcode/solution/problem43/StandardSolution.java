package com.leetcode.solution.problem43;

/**
 * @author Ricky
 * @date 2020-08-13 02:22:54
 */
public class StandardSolution {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        char[] chars = new char[m + n];
        for (int i = m + n - 1; i >= 0; --i) {
            if (i != 0) {
                result[i - 1] += result[i] / 10;
            }
            chars[i] = (char) (result[i] % 10 + '0');
        }

        return chars[0] == '0'
            ? new String(chars, 1, chars.length - 1)
            : new String(chars);
    }
}
