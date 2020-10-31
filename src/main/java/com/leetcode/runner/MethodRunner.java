package com.leetcode.runner;

import com.leetcode.serializer.DeserializeException;
import com.leetcode.serializer.IntArray2Serializer;
import com.leetcode.serializer.Serializer;
import com.leetcode.serializer.StringArrayDeserializer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 反序列化方法序列
 *
 * @author Ricky
 * @date 2020-10-31 21:21:50
 */
public class MethodRunner<T> {

    public static <T> MethodRunner<T> parse(String deserialize, Class<T> clazz) {
        String[] lines = deserialize.split("\r?\n");
        if (lines.length < 2) {
            throw new DeserializeException();
        }
        Serializer<String[]> methodDeserializer = new StringArrayDeserializer();
        Serializer<int[][]> argumentDeserializer = new IntArray2Serializer();
        String[] methods = methodDeserializer.deserialize(lines[0]);
        int[][] arguments = argumentDeserializer.deserialize(lines[1]);
        if (methods.length == 0 || arguments.length == 0) {
            throw new DeserializeException();
        }
        if (methods.length != arguments.length) {
            throw new DeserializeException();
        }
        if (!Objects.equals(methods[0], clazz.getName())) {
            throw new DeserializeException();
        }
        try {
            T instance = clazz.newInstance();
            for (int i = 1; i < methods.length; i++) {
                Class<?>[] classes = new Class[arguments.length];
                for (int j = 0; j < arguments[i].length; ++j) {
                    classes[j] = int.class;
                }
                Method method = clazz.getMethod(methods[i], classes);
                method.invoke(instance, arguments[i]);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new DeserializeException(e);
        }
        return null;
    }
}
