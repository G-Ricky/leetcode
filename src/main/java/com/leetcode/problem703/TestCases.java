package com.leetcode.problem703;

/**
 * @author Ricky
 * @date 2020-06-07 00:25:51
 */
public class TestCases {

    public static void test() {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        assert kthLargest.add(3) == 4;
        assert kthLargest.add(5) == 5;
        assert kthLargest.add(10) == 5;
        assert kthLargest.add(9) == 8;
        assert kthLargest.add(4) == 8;
    }
}
