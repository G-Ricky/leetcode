package com.leetcode.solution.problem67;

/**
 * 二进制求和
 *
 * @author Ricky
 * @date 2020-06-23 02:15:40
 */
public class Solution {
    public String addBinary(String a, String b) {

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        char[] sum = new char[Math.max(i, j) + 2];
        int index = sum.length - 1;

        while (i >= 0 || j >= 0) {
            int bitA = i >= 0
                ? a.charAt(i) - '0'
                : 0;
            int bitB = j >= 0
                ? b.charAt(j) - '0'
                : 0;
            int s = bitA + bitB + carry;
            sum[index--] = (char) ((s & 1) + '0');
            carry = (s >> 1) & 1;

            --i;
            --j;
        }
        // 退出循环时 index 一定为 0
        sum[0] = (char) (carry + '0');

        return new String(sum, index + 1 - carry, sum.length - index - 1 + carry);
    }
}
