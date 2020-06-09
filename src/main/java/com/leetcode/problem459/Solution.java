package com.leetcode.problem459;

public class Solution {

    public boolean repeatedSubstringPattern(String s) {

        int maxIndex = 0;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(maxIndex) == s.charAt(i)) {
                maxIndex++;
            } else {
                maxIndex = 0;
            }
        }

        return false;
    }
}
