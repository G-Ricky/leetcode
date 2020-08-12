package com.leetcode.solution.problem43;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串相乘
 *
 * @author Ricky
 * @date 2020-08-13 01:48:36
 */
public class Solution {

    private Map<Character, int[]> cache = new HashMap<>(16);

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

        int[] result = new int[num1.length() + num2.length()];
        String large = num1.length() > num2.length()
            ? num1 : num2;
        String small = num1.length() > num2.length()
            ? num2 : num1;

        for (int i = 0; i < small.length(); ++i) {
            int[] temp = multiplyTo(large, small.charAt(i));
            int offset = small.length() - 1 - i;
            add(result, temp, offset);
        }

        char[] chars = new char[result.length];
        for (int i = 0; i < chars.length; ++i) {
            chars[i] = (char) (result[i] + '0');
        }

        return chars[0] == '0'
            ? new String(chars, 1, chars.length - 1)
            : new String(chars);
    }

    private int[] multiplyTo(String num, char digit) {
        return cache.computeIfAbsent(digit, k -> {
            int[] result = new int[num.length() + 1];
            int carry = 0;
            for (int i = result.length - 1; i >= 0; --i) {
                char ch = i > 0
                    ? num.charAt(i - 1)
                    : '0';
                int res = (ch - '0') * (digit - '0');
                int current = result[i] + res + carry;
                result[i] = current % 10;
                carry = current / 10;
            }
            // 可能会有前导 0
            return result;
        });
    }

    private void add(int[] result, int[] op, int offset) {
        int carry = 0;
        for (int i = result.length - 1 - offset; i >= 0; --i) {
            int index = i - (result.length - op.length - offset);
            int opVal = index >= 0
                ? op[index]
                : 0;
            int current = result[i] + opVal + carry;
            result[i] = current % 10;
            carry = current / 10;
        }
    }
}
