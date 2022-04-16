package com.leetcode.solution.problem479;

/**
 * 最大回文数乘积
 *
 * @author Ricky
 * @date 2022-04-16 21:04:03
 */
public class Solution {

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        long palindromeLeft = (long) Math.pow(10, n) - 1;
        for (long num = palindromeLeft; num >= 0; --num) {
            long palindrome = getPalindrome(num);
            for (long leftNum = palindromeLeft; leftNum * leftNum >= palindrome; --leftNum) {
                if (palindrome % leftNum == 0) {
                    return  (int) (palindrome % 1337);
                }
            }
        }
        throw new RuntimeException("result not exists.");
    }

    private long getPalindrome(long left) {
        long right = 0;
        long temp = left;
        int i = 0;
        do {
            right = right * 10 + (temp % 10);
            ++i;
        } while ((temp /= 10) > 0);
        return left * (long) Math.pow(10, i) + right;
    }
}
