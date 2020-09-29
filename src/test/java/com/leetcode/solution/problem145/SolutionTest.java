package com.leetcode.solution.problem145;

import com.leetcode.TreeNode;
import com.leetcode.serializer.Serializer;
import com.leetcode.serializer.TreeSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-09-29 23:04:19
 */
public class SolutionTest {

    @ParameterizedTest
    @MethodSource("testSource")
    void test(List<Integer> result, TreeNode root) {
        Assertions.assertEquals(result, new Solution().postorderTraversal(root));
    }

    static Stream<Arguments> testSource() {
        Serializer<TreeNode> serializer = new TreeSerializer();
        return Stream.of(
            Arguments.of(Arrays.asList(3, 2, 1), serializer.deserialize("[1,null,2,3]")),
            Arguments.of(Collections.emptyList(), serializer.deserialize("[null]")),
            Arguments.of(Collections.singletonList(1), serializer.deserialize("[1]")),
            Arguments.of(Arrays.asList(4, 3, 2, 1), serializer.deserialize("[1,2,null,3,null,4,null]")),
            Arguments.of(Arrays.asList(6, 7, 4, 5, 2, 3, 1), serializer.deserialize("[1,2,3,4,5,null,null,6,7]")),
            Arguments.of(Arrays.asList(2, 4, 6, 7, 5, 3, 1), serializer.deserialize("[1,2,3,null,null,4,5,null,null,6,7]"))
        );
    }
}
