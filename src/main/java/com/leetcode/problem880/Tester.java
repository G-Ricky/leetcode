package com.leetcode.problem880;

public class Tester {

    public static void test() {
        String input1 = "leet2code3",
            input2 = "ha22",
            input3 = "a2345678999999999999999";
        int K1 = 10,
            K2 = 5,
            K3 = 1;

        Solution solution = new Solution();

        assert "o".equals(solution.decodeAtIndex(input1, K1));
        assert "h".equals(solution.decodeAtIndex(input2, K2));
        assert "a".equals(solution.decodeAtIndex(input3, K3));
    }
}
