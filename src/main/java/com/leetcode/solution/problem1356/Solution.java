package com.leetcode.solution.problem1356;

import java.util.Arrays;

/**
 * 根据数字二进制下 1 的数目排序
 *
 * @author Ricky
 * @date 2020-11-06 00:45:32
 */
public class Solution {

    public int[] sortByBits(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int[] countArray = new int[33];
        int[] bitCountCache = new int[arr.length];
        // 各个 bit 数字的个数
        for (int i = 0; i < arr.length; ++i) {
            int num = arr[i];
            int bitCount = 0;
            while (num > 0) {
                num = num & (num - 1);
                ++bitCount;
            }
            bitCountCache[i] = bitCount;
            countArray[bitCount]++;
        }

        // 计算具有 countArray[i] 位的数字集合的在结果集的起始下标
        int[] beginIndexArray = new int[countArray.length];
        int sum = 0;
        for (int i = 0; i < countArray.length; ++i) {
            if (countArray[i] > 0) {
                beginIndexArray[i] = sum;
                sum += countArray[i];
            }
        }

        // 将输入数组的元素填充到结果集相应的区间中
        int[] result = new int[arr.length];
        int[] indexArray = new int[countArray.length];
        for (int i = 0; i < arr.length; ++i) {
            int bitCount = bitCountCache[i];
            int index = indexArray[bitCount] + beginIndexArray[bitCount];
            result[index] = arr[i];
            ++indexArray[bitCount];
        }

        // 对结果集的每一个区间进行区间内排序
        for (int i = 0; i < countArray.length; ++i) {
            if (countArray[i] > 0) {
                Arrays.sort(result, beginIndexArray[i], beginIndexArray[i] + countArray[i]);
            }
        }

        return result;
    }
}
