package com.leetcode.solution.problem350;

import java.util.*;

/**
 * 两个数组的交集 II
 *
 * @author Ricky
 * @date 2020-07-13 00:27:31
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int[] larger;
        int[] smaller;
        if (nums1.length > nums2.length) {
            larger = nums1;
            smaller = nums2;
        } else {
            larger = nums2;
            smaller = nums1;
        }

        Map<Integer, Integer> map = new HashMap<>(32);
        for (int value : smaller) {
            int times = map.computeIfAbsent(value, k -> 0);
            map.put(value, times + 1);
        }

        List<Integer> result = new LinkedList<>();
        for (int value : larger) {
            int times;
            if (map.containsKey(value) && (times = map.get(value)) > 0) {
                result.add(value);
                map.put(value, times - 1);
            }
        }

        int[] res = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            res[i++] = num;
        }

        return res;
    }
}
