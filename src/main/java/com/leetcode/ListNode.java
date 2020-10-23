package com.leetcode;

import com.leetcode.serializer.ListNodeSerializer;

import java.util.Objects;

/**
 * @author Ricky
 * @date 2020-06-26 17:48:28
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode node = (ListNode) o;
        return val == node.val &&
            Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    /**
     * Junit {@link org.junit.jupiter.params.converter.FallbackStringToObjectConverter} 识别的 字符串转 ListNode 工厂方法
     * @param str
     * @return
     */
    public static ListNode fromString(String str) {
        return new ListNodeSerializer().deserialize(str);
    }
}
