package com.leetcode.solution.problem386;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典序排数
 *
 * @author Ricky
 * @date 2022-04-18 23:04:03
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
//        result.add(1);
//        int i = 0;
//        int low = 0; // 最低位
//        int high = 1; // 最高位
//        while (i < n) {
//            int curr = result.get(i);
//            int next = curr * 10 + low;
//            if (next <= n) {
//                result.add(next);
//            }
//            if (next > n || low >= 10) {
//                ++i;
//                low = 0;
//            } else {
//                low++;
//            }
//            if (i == result.size()) {
//                high++;
//                if (high > 9) {
//                    break;
//                }
//                result.add(high);
//            }
//        }
        return result;
    }
}
