package com.leetcode.serializer;

import com.leetcode.ListNode;

/**
 * 链表序列化工具
 *
 * @author Ricky
 * @date 2020-06-26 17:54:19
 */
public class ListNodeSerializer implements Serializer<ListNode> {

    private static final Serializer<int[]> SERIALIZER = new IntArraySerializer();

    @Override
    public String serialize(ListNode serializable) {
        StringBuilder sb = new StringBuilder("[");

        ListNode node = serializable;
        boolean isHead = true;
        while (node != null) {
            if (isHead) {
                isHead = false;
            } else {
                sb.append(",");
            }
            sb.append(node.val);

            node = node.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public ListNode deserialize(String text) {
        int[] values = SERIALIZER.deserialize(text);
        ListNode[] nodes = new ListNode[values.length];

        for (int i = 0; i < nodes.length; ++i) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }

        return nodes[0];
    }
}
