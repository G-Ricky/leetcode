package com.leetcode.problem1071;

public class Solution {

    public String gcdOfStrings(String str1, String str2) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
            sb.append(str1.charAt(i));
            ++i;
        }

        if (i == 0) {
            return "";
        }

        return "";
    }
}
