package com.leetcode.solution.problem125;

/**
 * 验证回文串
 *
 * @author Ricky
 * @date 2020-06-19 00:56:58
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (!isLetterOrDigit(s.charAt(i))) {
                if (i >= j) {
                    return true;
                }
                ++i;
            }
            while (!isLetterOrDigit(s.charAt(j))) {
                if (j <= i) {
                    return true;
                }
                --j;
            }

            if (!letterEquals(s.charAt(i++), s.charAt(j--))) {
                return false;
            }
        }

        return true;
    }

    private boolean isLetterOrDigit(char ch) {
        return ch >= '0' && ch <= '9' || isLetter(ch);
    }

    private boolean isLetter(char ch) {
        return ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z';
    }

    private boolean letterEquals(char letter1, char letter2) {
        return (letter1 == letter2 || isLetter(letter1) && isLetter(letter2) &&  Math.abs(letter1 - letter2) == 'a' - 'A');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assert true == solution.isPalindrome("1b1");
        assert true == solution.isPalindrome("A man, a plan, a canal: Panama");
        assert false == solution.isPalindrome("race a car");
        assert true == solution.isPalindrome("a");
        assert true == solution.isPalindrome(".");
        assert true == solution.isPalindrome(".........................");
    }
}
