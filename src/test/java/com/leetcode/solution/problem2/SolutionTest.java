package com.leetcode.solution.problem2;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.leetcode.utils.ListNodeUtils.link;

/**
 * @author Ricky
 * @date 2020-10-04 20:30:20
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(ListNode expect, ListNode l1, ListNode l2) {
        ListNode result = new Solution2().addTwoNumbers(l1, l2);
        Assertions.assertEquals(expect, result);
    }

    static Stream<Arguments> testSource() {
        ListNode[] nodes = new ListNode[9];
        nodes[0] = new ListNode(2);
        nodes[1] = new ListNode(4);
        nodes[2] = new ListNode(3);
        nodes[3] = new ListNode(5);
        nodes[4] = new ListNode(6);
        nodes[5] = new ListNode(4);
        nodes[6] = new ListNode(7);
        nodes[7] = new ListNode(0);
        nodes[8] = new ListNode(8);
        link(nodes, 0, 3);
        link(nodes, 3, 6);
        link(nodes, 6, 9);
        return Stream.of(
            Arguments.of(nodes[6], nodes[0], nodes[3])
        );
    }
}
