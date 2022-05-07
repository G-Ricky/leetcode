package com.leetcode.solution.problem433;

import com.leetcode.serializer.Serializer;
import com.leetcode.serializer.StringArrayDeserializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2022-05-07 23:05:47
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int expected, String start, String end, String[] bank) {
        Assertions.assertEquals(expected, new Solution().minMutation(start, end, bank));
    }

    static Stream<Arguments> testSource() {
        Serializer<String[]> deserializer = new StringArrayDeserializer();
        return Stream.of(
            Arguments.of(1, "AACCGGTT", "AACCGGTA", deserializer.deserialize("[\"AACCGGTA\"]")),
            Arguments.of(2, "AACCGGTT", "AAACGGTA", deserializer.deserialize("[\"AACCGGTA\",\"AACCGCTA\",\"AAACGGTA\"]")),
            Arguments.of(3, "AAAAACCC", "AACCCCCC", deserializer.deserialize("[\"AAAACCCC\",\"AAACCCCC\",\"AACCCCCC\"]")),
            Arguments.of(-1, "AAAAACCC", "CACCCCCC", deserializer.deserialize("[\"AAAACCCC\",\"AAACCCCC\",\"AACCCCCC\"]"))
        );
    }
}