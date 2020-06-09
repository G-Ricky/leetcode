package com.leetcode.problem703;

/**
 * @author Ricky
 * @date 2020-06-07 00:25:51
 */
public class TestCases2 {

    public static void test() {
        int[] arr = {4,5,8,2};
        KthLargest2 kthLargest2 = new KthLargest2(3, arr);
        assert kthLargest2.add(3) == 4;
        assert kthLargest2.add(5) == 5;
        assert kthLargest2.add(10) == 5;
        assert kthLargest2.add(9) == 8;
        assert kthLargest2.add(4) == 8;
    }
}
