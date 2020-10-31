package com.leetcode.serializer;

/**
 * 字符串数组反序列化工具
 *
 * @author Ricky
 * @date 2020-10-31 21:30:47
 */
public class StringArrayDeserializer implements Serializer<String[]> {

    @Override
    public String serialize(String[] serializable) {
        return null;
    }

    @Override
    public String[] deserialize(String text) {
        // TODO 暂时无法处理特殊字符
        String trimText = text.trim();
        if (trimText.indexOf('[') != 0 && trimText.lastIndexOf(']') != text.length() - 1) {
            throw new DeserializeException();
        }
        String[] elements = trimText.substring(1, trimText.length() - 1).split(",");
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            String trimElement = element.trim();
            if (trimElement.indexOf('"') != 0 && trimElement.lastIndexOf('"') != trimElement.length() - 1) {
                throw new DeserializeException();
            }
            elements[i] = trimElement.substring(1, trimElement.length() - 1);
        }
        return elements;
    }
}
