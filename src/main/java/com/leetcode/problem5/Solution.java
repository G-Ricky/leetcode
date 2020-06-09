package com.leetcode.problem5;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 0) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); ++i) {
            int offset = 1;
            int len = 1;
            while (i - offset >= 0 && i + offset < s.length()) {
                if (s.charAt(i - offset) == s.charAt(i + offset)) {
                    len++;
                } else {
                    break;
                }
                offset++;
            }

            if (len > maxLen) {
                maxLen = len;
                maxStr = s.substring(i - offset + 1, i + offset);
            }
        }

        return maxStr;
    }
}
