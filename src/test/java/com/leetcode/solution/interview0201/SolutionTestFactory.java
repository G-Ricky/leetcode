package com.leetcode.solution.interview0201;

import com.leetcode.ListNode;
import com.leetcode.serializer.ListNodeSerializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-26 17:52:23
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        Serializer<ListNode> serializer = new ListNodeSerializer();
        return Stream.of(
            Arguments.of(serializer.deserialize("[1, 2, 3]"), serializer.deserialize("[1, 2, 3, 3, 2, 1]")),
            Arguments.of(serializer.deserialize("[1, 2]"), serializer.deserialize("[1, 1, 1, 1, 2]"))
        );
    }
}
