package com.leetcode.solution.problem100;

import com.leetcode.TreeNode;
import com.leetcode.serializer.Serializer;
import com.leetcode.serializer.TreeSerializer;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-24 13:08:03
 */
public class SolutionTestFactory {

    public static Stream<Object[]> test() {
        Serializer<TreeNode> serializer = new TreeSerializer();
        return Stream.of(
            new Object[]{true, serializer.deserialize("[1,2,3]"), serializer.deserialize("[1,2,3]")},
            new Object[]{false, serializer.deserialize("[1,2]"), serializer.deserialize("[1,null,2]")},
            new Object[]{false, serializer.deserialize("[1,2,1]"), serializer.deserialize("[1,1,2]")}
        );
    }
}
