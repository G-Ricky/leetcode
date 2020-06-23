package com.leetcode.serializer;

import com.leetcode.TreeNode;

import java.util.stream.Stream;

/**
 * @author Ricky
 * @date 2020-06-24 01:39:22
 */
public class TreeSerializerTestFactory {

    static Stream<String> illegal() {
        return Stream.of(
            "[]",
            "[0,1",
            "0,1]",
            "[0,,1]",
            "[,0,1]",
            "[0,1,]",
            "[0,2147483648]",
            "[-2147483649]"
// TODO            "[null,1]",
// TODO           "[1,null,null,1]"
        );
    }

    static Stream<Object[]> normal() {
        TreeNode[] nodes = new TreeNode[]{
            new TreeNode(0),
            new TreeNode(2),
            new TreeNode(-1),
            new TreeNode(1),
            new TreeNode(2),
            new TreeNode(3),
            new TreeNode(4),
            new TreeNode(5),
            new TreeNode(1),
            new TreeNode(2),
            new TreeNode(3),
            new TreeNode(4),
            new TreeNode(5),
        };

        nodes[1].left = nodes[2];

        nodes[3].left = nodes[4];
        nodes[3].right = nodes[5];
        nodes[5].left = nodes[6];
        nodes[5].right = nodes[7];

        nodes[8].left = nodes[9];
        nodes[9].left = nodes[10];
        nodes[10].left = nodes[11];
        nodes[11].left = nodes[12];

        return Stream.of(
            new Object[]{nodes[0], "[0]"},
            new Object[]{nodes[1], "[2,-1]"},
            new Object[]{nodes[3], "[1,2,3,null,null,4,5]"},
            new Object[]{nodes[8], "[1,2,null,3,null,4,null,5]"}
        );
    }

    static Stream<Object[]> bound() {
        TreeNode[] nodes = new TreeNode[]{
            new TreeNode(Integer.MAX_VALUE),
            new TreeNode(Integer.MIN_VALUE),
            new TreeNode(Integer.MAX_VALUE),
            new TreeNode(Integer.MIN_VALUE),
            new TreeNode(Integer.MIN_VALUE),
            new TreeNode(Integer.MAX_VALUE),
        };

        nodes[2].left = nodes[3];
        nodes[4].right = nodes[5];

        return Stream.of(
            new Object[]{nodes[0], "[2147483647]"},
            new Object[]{nodes[1], "[-2147483648]"},
            new Object[]{nodes[2], "[2147483647,-2147483648]"},
            new Object[]{nodes[4], "[-2147483648,null,2147483647]"}
        );
    }

    static Stream<Object[]> blank() {
        TreeNode[] nodes = new TreeNode[]{
            new TreeNode(1),
            new TreeNode(2),
            new TreeNode(3),
            new TreeNode(1),
            new TreeNode(2),
            new TreeNode(1),
            new TreeNode(2),
            new TreeNode(1),
            new TreeNode(2),
        };
        nodes[0].left = nodes[1];
        nodes[0].right = nodes[2];

        nodes[3].left = nodes[4];

        nodes[5].right = nodes[6];

        nodes[7].left = nodes[8];

        return Stream.of(
            new Object[] {nodes[0], "   [ 1,          2,3] "},
            new Object[] {nodes[3], "[1,2                 ]"},
            new Object[] {nodes[5], "[   1, null  ,2]"},
            new Object[] {nodes[7], " [1 ,2,null      ]"}
        );
    }
}
