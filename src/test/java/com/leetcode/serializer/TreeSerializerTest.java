package com.leetcode.serializer;

import com.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Ricky
 * @date 2020-06-24 00:05:11
 */
public class TreeSerializerTest {

    static Serializer<TreeNode> serializer;

    @BeforeAll
    static void beforeAll() {
        serializer = new TreeSerializer();
    }

    @ParameterizedTest
    @MethodSource("com.leetcode.serializer.TreeSerializerTestFactory#illegal")
    void deserializeIllegal(final String serialized) {
        Assertions.assertThrows(
            DeserializeException.class,
            () -> serializer.deserialize(serialized)
        );
    }

    @Test
    void deserializeEmpty() {
        Assertions.assertNull(serializer.deserialize("[null]"));
    }

    @ParameterizedTest
    @MethodSource("com.leetcode.serializer.TreeSerializerTestFactory#normal")
    void deserializeNormal(TreeNode root, String serialized) {
        Assertions.assertEquals(root, serializer.deserialize(serialized));
    }

    @ParameterizedTest
    @MethodSource("com.leetcode.serializer.TreeSerializerTestFactory#bound")
    void deserializeBound(TreeNode root, String serialized) {
        Assertions.assertEquals(root, serializer.deserialize(serialized));
    }

    @ParameterizedTest
    @MethodSource("com.leetcode.serializer.TreeSerializerTestFactory#blank")
    void deserializeBlank(TreeNode root, String serialized) {
        Assertions.assertEquals(root, serializer.deserialize(serialized));
    }
}
