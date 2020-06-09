package com.leetcode;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String pattern = "abaabcac";

        int[] next = getNext(pattern);

        System.out.println(Arrays.toString(next));
    }

    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length() + 1];
        int j = 1, k = 0;
        next[1] = 0;

        while(j < pattern.length()) {
            if (k == 0 || pattern.charAt(j) == pattern.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
