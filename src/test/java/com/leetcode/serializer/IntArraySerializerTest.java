package com.leetcode.serializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ricky
 * @date 2020-06-23 01:04:39
 */
public class IntArraySerializerTest {

    @Test
    public void deserializeNormally() {
        Serializer<int[]> serializer = new IntArraySerializer();
        Assertions.assertArrayEquals(
            new int[]{0, 1, 1},
            serializer.deserialize("[0,1,1]")
        );
        Assertions.assertArrayEquals(
            new int[]{0, 1, 1, 2, 1, 2},
            serializer.deserialize("[0,1,1,2,1,2]")
        );
        Assertions.assertArrayEquals(
            new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2},
            serializer.deserialize("[0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2]")
        );
    }

    @Test
    public void deserializeWithBlank() {
        Serializer<int[]> serializer = new IntArraySerializer();
        Assertions.assertArrayEquals(
            new int[]{0, 1, 1},
            serializer.deserialize(" [0,1,1]")
        );
        Assertions.assertArrayEquals(
            new int[]{0, 1, 1},
            serializer.deserialize(" [0 ,1,1]\r\n")
        );
        Assertions.assertArrayEquals(
            new int[]{0, 1, 1},
            serializer.deserialize(" [0 , 1,1]              ")
        );
        Assertions.assertArrayEquals(
            new int[]{0, 1, 1},
            serializer.deserialize(" [0 \t, 1,1  ]")
        );
    }

    @Test
    public void deserializeEmpty() {
        Serializer<int[]> serializer = new IntArraySerializer();
        Assertions.assertArrayEquals(
            new int[0],
            serializer.deserialize("[]")
        );
        Assertions.assertArrayEquals(
            new int[0],
            serializer.deserialize("\r\n[]")
        );
        Assertions.assertArrayEquals(
            new int[0],
            serializer.deserialize("[\r\n]")
        );
        Assertions.assertArrayEquals(
            new int[0],
            serializer.deserialize("[]  ")
        );
        Assertions.assertArrayEquals(
            new int[0],
            serializer.deserialize("  [ \r\n ] ")
        );
    }

    @Test
    public void deserializeSign() {
        Serializer<int[]> serializer = new IntArraySerializer();
        Assertions.assertArrayEquals(
            new int[] {-100, 20, 100},
            serializer.deserialize("[-100,20,100]")
        );
        Assertions.assertArrayEquals(
            new int[] {-100, 20, 100},
            serializer.deserialize("[-100,20,100]")
        );
        Assertions.assertArrayEquals(
            new int[] {-100, 20, 100},
            serializer.deserialize("[- 100,20,100]")
        );
        Assertions.assertArrayEquals(
            new int[] {-100, -20, 100},
            serializer.deserialize("[-100,-20,100]")
        );
        Assertions.assertArrayEquals(
            new int[] {-100, -20, -100},
            serializer.deserialize("[-100,-20,-100]")
        );
        Assertions.assertArrayEquals(
            new int[] {100, -20, -100},
            serializer.deserialize("[100,-20,-100]")
        );
        Assertions.assertArrayEquals(
            new int[] {100, 20, -100},
            serializer.deserialize("[100,+20,-100]")
        );
        Assertions.assertThrows(
            DeserializeException.class,
            () -> serializer.deserialize("[100,--20,-100]")
        );
    }

    @Test
    public void deserializeBound() {
        Serializer<int[]> serializer = new IntArraySerializer();
        Assertions.assertArrayEquals(
            new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE},
            serializer.deserialize("[2147483647,-2147483648]")
        );
        Assertions.assertThrows(
            DeserializeException.class,
            () -> serializer.deserialize("[2147483648,-2147483648]")
        );
        Assertions.assertThrows(
            DeserializeException.class,
            () -> serializer.deserialize("[2147483647,-2147483649]")
        );
        Assertions.assertThrows(
            DeserializeException.class,
            () -> serializer.deserialize("[9999999999999999999999,-2147483648]")
        );
    }
}
