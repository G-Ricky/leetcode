package com.leetcode.solution.interview0201;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-06-26 17:52:00
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.solution.interview0201.SolutionTestFactory#test")
    void test(ListNode result, ListNode head) {
        Assertions.assertEquals(result, new Solution().removeDuplicateNodes(head));
    }
}
