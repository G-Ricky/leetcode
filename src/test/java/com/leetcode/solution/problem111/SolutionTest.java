package com.leetcode.solution.problem111;

import com.leetcode.TreeNode;
import com.leetcode.serializer.Serializer;
import com.leetcode.serializer.TreeSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-08-21 16:30:11
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(int result, TreeNode root) {
        Assertions.assertEquals(result, new Solution().minDepth(root));
    }

    static Stream<Arguments> testSource() {
        Serializer<TreeNode> serializer = new TreeSerializer();
        return Stream.of(
            Arguments.of(1, serializer.deserialize("[0]")),
            Arguments.of(2, serializer.deserialize("[1,2]")),
            Arguments.of(2, serializer.deserialize("[3,9,20,null,null,15,7]"))
        );
    }
}
