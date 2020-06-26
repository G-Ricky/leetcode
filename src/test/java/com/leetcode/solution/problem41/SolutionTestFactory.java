package com.leetcode.solution.problem41;

import com.leetcode.serializer.IntArraySerializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-27 01:09:47
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        Serializer<int[]> serializer = new IntArraySerializer();
        return Stream.of(
            Arguments.of(3, serializer.deserialize("[1,2,0]")),
            Arguments.of(2, serializer.deserialize("[3,4,-1,1]")),
            Arguments.of(1, serializer.deserialize("[7,8,9,11,12]")),
            Arguments.of(11, serializer.deserialize("[10,9,8,7,6,5,4,3,2,1]")),
            Arguments.of(2, serializer.deserialize("[1,1]")),
            Arguments.of(2, serializer.deserialize("[1]")),
            Arguments.of(1, serializer.deserialize("[2]")),
            Arguments.of(1, serializer.deserialize("[2,3]")),
            Arguments.of(1, serializer.deserialize("[-2,-3]"))

        );
    }
}
