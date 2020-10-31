package com.leetcode.serializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 字符串数组反序列化测试
 *
 * @author Ricky
 * @date 2020-10-31 23:00:57
 */
public class StringArraySerializerTest {

    @MethodSource("testSource")
    @ParameterizedTest
    void test(String[] expected, String text) {
        Serializer<String[]> deserializer = new StringArrayDeserializer();
        Assertions.assertArrayEquals(expected, deserializer.deserialize(text));
    }

    static Stream<Arguments> testSource() {
        return Stream.of(
            Arguments.of(new String[] {"RandomizedCollection","insert","insert","insert","getRandom","remove","getRandom"}, "[\"RandomizedCollection\",\"insert\",\"insert\",\"insert\",\"getRandom\",\"remove\",\"getRandom\"]")
        );
    }
}
