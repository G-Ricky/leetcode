package com.leetcode.solution.problem338;

import com.leetcode.serializer.IntArraySerializer;
import com.leetcode.serializer.Serializer;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-24 13:46:52
 */
public class SolutionTestFactory {

    public static Stream<Object[]> test() {
        return Stream.of(
            new Object[]{"[0,1,1]", 2},
            new Object[]{"[0,1,1,2,1,2]", 5},
            new Object[]{"[0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2]", 20}
        );
    }
}
