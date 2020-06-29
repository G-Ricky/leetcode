package com.leetcode.solution.problem142;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-06-30 00:58:50
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem142.SolutionTestFactory#test")
    void testSolution(ListNode result, ListNode head) {
        Assertions.assertSame(result, new Solution().detectCycle(head));
    }

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.problem142.SolutionTestFactory#test")
    void testFloydSolution(ListNode result, ListNode head) {
        Assertions.assertSame(result, new Solution().detectCycle(head));
    }
}
