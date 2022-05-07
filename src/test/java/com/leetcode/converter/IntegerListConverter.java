package com.leetcode.converter;

import com.leetcode.serializer.IntArraySerializer;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符串转int[]转换类
 *
 * @author Ricky
 * @date 2020-10-23 23:19:46
 */
public class IntegerListConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!String.class.isAssignableFrom(source.getClass())) {
            throw new ArgumentConversionException("Can not convert parameter");
        }
        int[] array = new IntArraySerializer().deserialize((String) source);
        return Arrays.stream(array)
            .boxed()
            .collect(Collectors.toCollection(() -> new ArrayList<>(array.length)));
    }
}
