package com.leetcode.serializer;

import com.leetcode.ListNode;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-26 18:05:22
 */
public class ListNodeSerializerTestFactory {

    static Stream<Arguments> testSerialize() {
        ListNode[] nodes = new ListNode[16];
        nodes[0] = new ListNode(1);
        nodes[1] = new ListNode(2);
        nodes[2] = new ListNode(3);
        nodes[3] = new ListNode(3);
        nodes[4] = new ListNode(2);
        nodes[5] = new ListNode(1);

        nodes[6] = new ListNode(1);
        nodes[7] = new ListNode(2);
        nodes[8] = new ListNode(3);

        nodes[9] = new ListNode(1);
        nodes[10] = new ListNode(1);
        nodes[11] = new ListNode(1);
        nodes[12] = new ListNode(1);
        nodes[13] = new ListNode(2);

        nodes[14] = new ListNode(1);
        nodes[15] = new ListNode(2);

        return Stream.of(
            Arguments.of("[1,2,3,3,2,1]", link(nodes, 0, 6)),
            Arguments.of("[1,2,3]", link(nodes, 6, 9)),
            Arguments.of("[1,1,1,1,2]", link(nodes, 9, 14)),
            Arguments.of("[1,2]", link(nodes, 14, 16))
        );
    }

    static Stream<Arguments> testDeserialize() {
        ListNode[] nodes = new ListNode[16];
        nodes[0] = new ListNode(1);
        nodes[1] = new ListNode(2);
        nodes[2] = new ListNode(3);
        nodes[3] = new ListNode(3);
        nodes[4] = new ListNode(2);
        nodes[5] = new ListNode(1);

        nodes[6] = new ListNode(1);
        nodes[7] = new ListNode(2);
        nodes[8] = new ListNode(3);

        nodes[9] = new ListNode(1);
        nodes[10] = new ListNode(1);
        nodes[11] = new ListNode(1);
        nodes[12] = new ListNode(1);
        nodes[13] = new ListNode(2);

        nodes[14] = new ListNode(1);
        nodes[15] = new ListNode(2);

        return Stream.of(
            Arguments.of(link(nodes, 0, 6), "[1,2,3,3,2,1]"),
            Arguments.of(link(nodes, 6, 9), "[1,2,3]"),
            Arguments.of(link(nodes, 9, 14), "[1,1,1,1,2]"),
            Arguments.of(link(nodes, 14, 16), "[1,2]")
        );
    }

    private static ListNode link(ListNode[] nodes, int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new IllegalArgumentException();
        }
        if (endIndex > nodes.length) {
            throw new IllegalArgumentException();
        }
        if (beginIndex >= endIndex) {
            throw new IllegalArgumentException();
        }

        for (int i = beginIndex + 1; i < endIndex; ++i) {
            nodes[i - 1].next = nodes[i];
        }

        return nodes[beginIndex];
    }
}
