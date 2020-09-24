package com.leetcode.solution.problem501;

import com.leetcode.TreeNode;
import com.leetcode.serializer.IntArraySerializer;
import com.leetcode.serializer.Serializer;
import com.leetcode.serializer.TreeSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-09-24 22:16:09
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int[] expected, TreeNode root) {
        int[] result = new Solution().findMode(root);
        Arrays.sort(result);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, result);
    }

    static Stream<Arguments> testSource() {
        Serializer<TreeNode> serializer = new TreeSerializer();
        Serializer<int[]> serializer1 = new IntArraySerializer();
        return Stream.of(
            Arguments.of(serializer1.deserialize("[2]"), serializer.deserialize("[1,null,2,2]")),
            Arguments.of(serializer1.deserialize("[2147483647]"), serializer.deserialize("[2147483647]")),
            Arguments.of(serializer1.deserialize("[2,1]"), serializer.deserialize("[1,null,2]"))
        );
    }
}
