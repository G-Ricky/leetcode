package com.leetcode.solution.problem767;

/**
 * 重构字符串
 * @author Ricky
 * @date 2020-11-30 01:11:31
 */
public class Solution {
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        char[] charArray = S.toCharArray();
        int[] charCount = new int[26];
        for (int i = 0; i < charArray.length; ++i) {
            int index = charArray[i] - 'a';
            charCount[index]++;
        }
        int minIndex;
        int min;
        char[] sortedChar = new char[26];
        int[] sortedCount = new int[26];
        int sortedCountSize = 0;
        do {
            minIndex = -1;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < charCount.length; ++i) {
                if (charCount[i] != 0 && charCount[i] < min) {
                    minIndex = i;
                    min = charCount[i];
                }
            }
            if (minIndex != -1) {
                sortedCount[sortedCountSize] = min;
                sortedChar[sortedCountSize] = (char) (minIndex + 'a');
                charCount[minIndex] = 0;
                sortedCountSize++;
            }
        } while (minIndex != -1);
        int sum = 0;
        for (int i = 0; i < sortedCountSize; ++i) {
            sum += sortedCount[i];
        }
        int lastCount = sortedCount[sortedCountSize - 1];
        if (lastCount > sum - lastCount + 1) {
            return "";
        }
        int head = 0;
        int tail = 0;
        int strSize = S.length();
        char[] res = new char[strSize];
        sum = 0;
        for (int i = 0; i < sortedCountSize; ++i) {
            for (int j = 0; j < sortedCount[i]; ++j) {
                res[tail++ % strSize] = sortedChar[i];
                if (i > 0 && j < sum) {
                    res[tail++ % strSize] = res[head++ % strSize];
                }
            }
            sum += sortedCount[i];
        }
        head %= strSize;
        tail %= strSize;
        if (head == 0) {
            return String.valueOf(res);
        } else {
            return String.valueOf(res, head, strSize - head) + String.valueOf(res, 0, tail);
        }
    }
}
