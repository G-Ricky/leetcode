package com.leetcode.solution.problem1013;

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;

        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
        }

        if (sum % 3 != 0) {
            return false;
        }

        Integer s1 = null, s2 = null;
        int size = sum / 3;
        int part = 0;
        for (int i = 0; i < A.length; ++i) {
            part += A[i];
            if (part == size) {
                part = 0;
                if (s1 == null) {
                    s1 = i;
                } else {
                    s2 = i;
                    if (s2 == A.length - 1) {
                        return false;
                    }
                    break;
                }
            }
        }

        return s1 != null && s2 != null;
    }
}
