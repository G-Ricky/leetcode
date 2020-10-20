package com.leetcode.solution.problem143;

import com.leetcode.ListNode;
import com.leetcode.serializer.IntArraySerializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.stream.Stream;

import static com.leetcode.utils.ListNodeUtils.link;

/**
 * @author Ricky
 * @date 2020-10-20 23:45:42
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(ListNode expected, ListNode head) {
        new Solution().reorderList(head);
        Assertions.assertTrue(Objects.equals(expected, head));
    }

    static Stream<Arguments> testSource() {
        Serializer<int[]> serializer = new IntArraySerializer();
        return Stream.of(
            Arguments.of(
                toList(serializer.deserialize("[1,10,2,9,3,8,4,7,5,6]")),
                toList(serializer.deserialize("[1,2,3,4,5,6,7,8,9,10]")))
        );
    }

    static ListNode toList(int[] arr) {
        ListNode[] nodes = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            nodes[i] = new ListNode(num);
        }
        return link(nodes, 0, arr.length);
    }
}
