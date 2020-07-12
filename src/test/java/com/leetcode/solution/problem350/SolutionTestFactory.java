package com.leetcode.solution.problem350;

import com.leetcode.serializer.IntArraySerializer;
import com.leetcode.serializer.Serializer;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-07-13 00:28:45
 */
public class SolutionTestFactory {

    static Stream<Arguments> test() {
        Serializer<int[]> serializer = new IntArraySerializer();
        return Stream.of(
            Arguments.of(
                serializer.deserialize("[2,2]"),
                serializer.deserialize("[1,2,2,1]"),
                serializer.deserialize("[2,2]")
            ),
            Arguments.of(
                serializer.deserialize("[4,9]"),
                serializer.deserialize("[4,9,5]"),
                serializer.deserialize("[9,4,9,8,4]")
            ),
            Arguments.of(
                serializer.deserialize("[4,6,5,6,3,1,2,6,5]"),
                serializer.deserialize("[4,6,4,5,6,3,2,1,6,6,5]"),
                serializer.deserialize("[6,8,5,4,6,8,3,1,2,5,1,6]")
            )
        );
    }
}
