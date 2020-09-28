package com.leetcode.solution.problem117;

import com.leetcode.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-09-28 23:34:27
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(Node root) {
        new Solution().connect(root);
        Assertions.assertTrue(true);
    }

    static Stream<Arguments> testSource() {
        Node[] nodes = new Node[6];
        nodes[5] = new Node(7, null, null, null);
        nodes[4] = new Node(5, null, null, null);
        nodes[3] = new Node(4, null, null, null);
        nodes[2] = new Node(3, null, nodes[5], null);
        nodes[1] = new Node(2, nodes[3], nodes[4], null);
        nodes[0] = new Node(1, nodes[1], nodes[2], null);
        return Stream.of(
            Arguments.of(nodes)
        );
    }
}
