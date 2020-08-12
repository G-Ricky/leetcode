package com.leetcode.solution.problem133;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-08-12 00:56:15
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(Node node) {
        Node copy = new Solution().cloneGraph(node);
        Assertions.assertTrue(deepEqualsNotSame(node, copy));
    }

    @ParameterizedTest
    @MethodSource("testSource")
    void testStandard(Node node) {
        Node copy = new StandardSolution().cloneGraph(node);
        Assertions.assertTrue(deepEqualsNotSame(node, copy));
    }

    boolean deepEqualsNotSame(Node expected, Node provided) {
        return deepEqualsNotSame(expected, provided, new HashSet<>());
    }

    boolean deepEqualsNotSame(Node expected, Node provided, Set<Integer> visited) {
        if (expected.val != provided.val || expected.neighbors.size() != provided.neighbors.size() || expected == provided) {
            return false;
        }
        visited.add(expected.val);
        Map<Integer, Node> neighborMap = new HashMap<>();
        for (Node neighbor : expected.neighbors) {
            neighborMap.put(neighbor.val, neighbor);
        }

        for (Node neighbor : provided.neighbors) {
            Node cmp = neighborMap.get(neighbor.val);
            if (cmp == null || cmp.val != neighbor.val || cmp == neighbor) {
                return false;
            }
            neighborMap.remove(neighbor.val);
        }

        if (!neighborMap.isEmpty()) {
            return false;
        }

        for (Node neighbor : expected.neighbors) {
            if (!visited.contains(neighbor.val)) {
                neighborMap.put(neighbor.val, neighbor);
            }
        }

        for (Node neighbor : provided.neighbors) {
            if (!visited.contains(neighbor.val)) {
                if (!deepEqualsNotSame(neighborMap.get(neighbor.val), neighbor, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    static Stream<Arguments> testSource() {
        Node[] nodes = new Node[4];
        nodes[0] = new Node(1, new ArrayList<>(2));
        nodes[1] = new Node(2, new ArrayList<>(2));
        nodes[2] = new Node(3, new ArrayList<>(2));
        nodes[3] = new Node(4, new ArrayList<>(2));
        nodes[0].neighbors.addAll(Arrays.asList(nodes[1], nodes[3]));
        nodes[1].neighbors.addAll(Arrays.asList(nodes[0], nodes[2]));
        nodes[2].neighbors.addAll(Arrays.asList(nodes[1], nodes[3]));
        nodes[3].neighbors.addAll(Arrays.asList(nodes[0], nodes[2]));

        return Stream.of(
            Arguments.of(nodes[0])
        );
    }
}
