package com.leetcode.serializer;

/**
 * @author Ricky
 * @date 2020-06-22 02:04:02
 */
public interface Serializer<T> {

    /**
     * 序列化对象
     * @param serializable 对象
     * @return
     */
    String serialize(T serializable);

    /**
     * 反序列化对象
     * @param text 文本对象
     * @return
     */
    T deserialize(String text);
}
