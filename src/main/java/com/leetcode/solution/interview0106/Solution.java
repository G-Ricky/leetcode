package com.leetcode.solution.interview0106;

class Solution {
    public String compressString(String S) {
        if (S.length() <= 1) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        char currentChar = S.charAt(0);
        int times = 1;
        sb.append(currentChar);

        for (int i = 1; i < S.length(); ++i) {
            if (currentChar == S.charAt(i)) {
                times++;
            } else {
                currentChar = S.charAt(i);
                sb.append(times)
                    .append(currentChar);
                times = 1;
            }
        }

        sb.append(times);

        return S.length() <= sb.length()
            ? S
            : sb.toString();
    }
}
