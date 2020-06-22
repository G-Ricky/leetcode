package com.leetcode.serializer;

/**
 * 二进制字符串序列化工具
 *
 * @author Ricky
 * @date 2020-06-23 01:35:02
 */
public class BinarySerializer implements Serializer<Long> {

    private static final int BIT = 64;

    @Override
    public String serialize(Long serializable) {
        if (serializable == null) {
            throw new DeserializeException("serializable can not be null.");
        }
        if (serializable == 0) {
            return "0";
        }
        char[] chars = new char[BIT];
        int count = 0;
        for (int i = BIT - 1; i >= 0; --i) {
            int bit = (int) ((serializable >> i) & 1);
            if (bit > 0 && count == 0) {
                count = 1;
            }
            if (count > 0) {
                chars[count - 1] = (char) (bit + '0');
                ++count;
            }
        }

        return new String(chars, 0, count - 1);
    }

    @Override
    public Long deserialize(String text) {
        if (text == null) {
            throw new DeserializeException("text can not be null.");
        }
        if (text.length() == 0) {
            throw new DeserializeException("text can not be empty.");
        }
        if (text.length() > 64) {
            throw new DeserializeException("Number is too large.");
        }

        long result = 0;
        for (int i = text.length() - 1; i >= 0; --i) {
            char ch = text.charAt(i);
            if (ch == '0') {
                result <<= 1;
            } else if (ch == '1') {
                result = (result << 1) | 1;
            } else {
                throw new DeserializeException(String.format("Unexpected token %c at column %d", ch, i));
            }
        }

        return result;
    }
}
