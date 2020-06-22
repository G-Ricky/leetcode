package com.leetcode.serializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ricky
 * @date 2020-06-23 02:26:50
 */
public class BinarySerializerTest {

    @Test
    public void deserializeNormally() {
        Serializer<Long> serializer = new BinarySerializer();
        Assertions.assertEquals(0, serializer.deserialize("0"));
        Assertions.assertEquals(0, serializer.deserialize("00"));
        Assertions.assertEquals(1, serializer.deserialize("1"));
        Assertions.assertEquals(15, serializer.deserialize("1111"));
    }

    @Test
    public void serializeNormally() {
        Serializer<Long> serializer = new BinarySerializer();
        Assertions.assertEquals("0", serializer.serialize(0L));
        Assertions.assertEquals("1", serializer.serialize(1L));
        Assertions.assertEquals("1111", serializer.serialize(15L));
    }
}
