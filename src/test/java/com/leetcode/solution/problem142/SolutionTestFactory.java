package com.leetcode.solution.problem142;

import com.leetcode.ListNode;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.leetcode.utils.ListNodeUtils.*;

/**
 * @author Ricky
 * @date 2020-06-30 00:59:21
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        ListNode[] nodes = new ListNode[7];
        nodes[0] = new ListNode(3);
        nodes[1] = new ListNode(2);
        nodes[2] = new ListNode(0);
        nodes[3] = new ListNode(-4);
        nodes[4] = new ListNode(1);
        nodes[5] = new ListNode(2);
        nodes[6] = new ListNode(1);

        link(nodes, 0, 4);
        link(nodes, 4, 6);

        nodes[3].next = nodes[1];
        nodes[5].next = nodes[4];

        return Stream.of(
            Arguments.of(nodes[1], nodes[0]),
            Arguments.of(nodes[4], nodes[4]),
            Arguments.of(null, nodes[6])
        );
    }
}
