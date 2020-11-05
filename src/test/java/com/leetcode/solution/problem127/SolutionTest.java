package com.leetcode.solution.problem127;

import com.leetcode.serializer.IntArraySerializer;
import com.leetcode.serializer.Serializer;
import com.leetcode.serializer.StringArrayDeserializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-11-05 23:32:52
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int expected, String beginWord, String endWord, List<String> wordList) {
        Assertions.assertEquals(expected, new Solution().ladderLength(beginWord, endWord, wordList));
    }

    static Stream<Arguments> testSource() {
        Serializer<String[]> serializer = new StringArrayDeserializer();
        return Stream.of(
            Arguments.of(5, "hit", "cog", Arrays.asList(serializer.deserialize("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]"))),
            Arguments.of(1, "hot", "hot", Arrays.asList(serializer.deserialize("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]"))),
            Arguments.of(0, "hot", "dog", Arrays.asList(serializer.deserialize("[\"hot\",\"dog\"]"))),
            Arguments.of(2, "hog", "cog", Arrays.asList(serializer.deserialize("[\"cog\"]")))
        );
    }
}
