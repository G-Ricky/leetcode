package com.leetcode.solution.problem546;

import com.leetcode.serializer.IntArraySerializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-08-15 20:25:34
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int result, int[] boxes) {
        Assertions.assertEquals(result, new Solution().removeBoxes(boxes));
    }

    static Stream<Arguments> testSource() {
        Serializer<int[]> serializer = new IntArraySerializer();
        return Stream.of(
            Arguments.of(0, serializer.deserialize("[]")),
            Arguments.of(1, serializer.deserialize("[1]")),
            Arguments.of(4, serializer.deserialize("[1,1]")),
            Arguments.of(2, serializer.deserialize("[1,2]")),
            Arguments.of(9, serializer.deserialize("[1,1,1]")),
            Arguments.of(5, serializer.deserialize("[1,1,2]")),
            Arguments.of(5, serializer.deserialize("[1,2,1]")),
            Arguments.of(5, serializer.deserialize("[1,2,2]")),
            Arguments.of(3, serializer.deserialize("[1,2,3]")),
            Arguments.of(23, serializer.deserialize("[1,3,2,2,2,3,4,3,1]")),
            Arguments.of(23, serializer.deserialize("[1,3,2,2,2,3,4,3,2]"))
        );
    }
}
