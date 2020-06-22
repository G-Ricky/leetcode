package com.leetcode.serializer;

/**
 * 反序列化异常
 *
 * @author Ricky
 * @date 2020-06-23 01:06:38
 */
public class DeserializeException extends RuntimeException {

    public DeserializeException() {
    }

    public DeserializeException(String message) {
        super(message);
    }

    public DeserializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeserializeException(Throwable cause) {
        super(cause);
    }
}
