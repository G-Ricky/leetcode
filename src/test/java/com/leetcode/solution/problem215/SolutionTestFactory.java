package com.leetcode.solution.problem215;

import com.leetcode.serializer.IntArraySerializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-29 22:35:28
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        Serializer<int[]> serializer = new IntArraySerializer();
        return Stream.of(
            Arguments.of(5, serializer.deserialize("[3,2,1,5,6,4]"), 2),
            Arguments.of(4, serializer.deserialize("[3,2,3,1,2,4,5,5,6]"), 4)
        );
    }
}
