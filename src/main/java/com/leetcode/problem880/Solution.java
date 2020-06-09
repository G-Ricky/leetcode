package com.leetcode.problem880;

class Solution {

    public String decodeAtIndex(String S, int K) {
        long decodedLen = 0;

        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) >= '2' && S.charAt(i) <= '9') {
                decodedLen *= S.charAt(i) - '0';
            } else {
                decodedLen++;
            }

            if (decodedLen > K) {
                break;
            }
        }

        throw new RuntimeException();
    }
}
