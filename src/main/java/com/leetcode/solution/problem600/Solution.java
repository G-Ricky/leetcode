package com.leetcode.solution.problem600;

import java.util.HashMap;
import java.util.Map;

/**
 * 不含连续1的非负整数
 *
 * @author Ricky
 * @date 2021-09-11 17:09:27
 */
public class Solution {

    public Map<Integer, Integer> map = new HashMap<>();

    public int findIntegers(int n) {
        map.put(0, 0);
        map.put(1, 0);
        return n - find(n) + 1;
    }

    private int find(int num) {
        Integer c = map.get(num);
        if (c != null) {
            return c;
        }
        int secondBit = getBit(num, 1);
        if (secondBit == 1) {
            int prev = onlyHighBit(removeHighBit(num)) - 1 + (1 << (getBitCount(num) - 1));
            c = find(prev) + num - prev;
        } else {
            int prev = onlyHighBit(num) - 1;
            c = find(prev) + find(removeHighBit(num));
        }
        map.put(num, c);
        return c;
    }

    // 获取二进制位数
    public int getBitCount(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num >>> 1;
        }
        return count;
    }

    // 获取第 pos 位（左到右）的二进制值
    public int getBit(int num, int pos) {
        int count = getBitCount(num);
        for (int i = pos; i < count - 1; ++i) {
            num = num >>> 1;
        }
        return num & 1;
    }

    public int onlyHighBit(int num) {
        num |= num >>> 16;
        num |= num >>> 8;
        num |= num >>> 4;
        num |= num >>> 2;
        num |= num >>> 1;
        return (num + 1) >>> 1;
    }

    public int removeHighBit(int num) {
        int count = getBitCount(num);
        if (count <= 1) {
            return 0;
        }
        return (0xFFFFFFFF >>> (33 - count)) & num;
    }
}
