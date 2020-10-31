package com.leetcode.serializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 二维 int 数组解析测试
 *
 * @author Ricky
 * @date 2020-10-31 23:06:23
 */
public class IntArray2SerializerTest {

    @MethodSource("testSource")
    @ParameterizedTest
    void test(int[][] expected, String text) {
        Serializer<int[][]> deserializer = new IntArray2Serializer();
        Assertions.assertArrayEquals(expected, deserializer.deserialize(text));
    }

    static Stream<Arguments> testSource() {
        int[][] expected1 = new int[][]{
            {}, {1}, {1}, {2}, {}, {1}, {}
        };
        return Stream.of(
            Arguments.of(expected1, "[[],[1],[1],[2],[],[1],[]]")
        );
    }
}
