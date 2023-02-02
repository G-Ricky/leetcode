package com.leetcode.converter;

import com.leetcode.serializer.IntArray2Serializer;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

/**
 * 二维数组转 int
 *
 * @author Ricky
 * @date 2023-01-31 21:01:15
 */
public class IntArray2Converter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!String.class.isAssignableFrom(source.getClass())) {
            throw new ArgumentConversionException("Can not convert parameter");
        }
        return new IntArray2Serializer().deserialize((String) source);
    }
}
