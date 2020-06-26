package com.leetcode.serializer;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-06-26 17:54:02
 */
public class ListNodeSerializerTest {

    @ParameterizedTest
    @MethodSource("com.leetcode.serializer.ListNodeSerializerTestFactory#testSerialize")
    void testSerialize(String result, ListNode root) {
        Assertions.assertEquals(result, new ListNodeSerializer().serialize(root));
    }

    @ParameterizedTest
    @MethodSource("com.leetcode.serializer.ListNodeSerializerTestFactory#testDeserialize")
    void testDeserialize(ListNode result, String text) {
        Assertions.assertEquals(result, new ListNodeSerializer().deserialize(text));
    }
}
