package com.leetcode.serializer;

import java.util.*;

/**
 * @author Ricky
 * @date 2020-06-22 02:09:03
 */
public class IntArraySerializer implements Serializer<int[]> {

    private static final int END = 6;

    private static final int[][] STATE_MATRIX = new int[][]{
        // '[', '+/-', '\d', ',', ']'
        {1, -1, -1, -1, -1},
        {-1, 2, 3, -1, END},
        {-1, -1, 3, -1, -1},
        {-1, -1, -1, 4, END},
        {-1, 5, 3, -1, -1},
        {-1, -1, 3, -1, -1}
    };

    enum TokenType {
        LEFT_PARENTHESES,
        SIGN,
        DIGIT,
        COMMA,
        RIGHT_PARENTHESES,
    }

    @Override
    public String serialize(int[] serializable) {
        StringBuilder sb = new StringBuilder("[");
        for (int value : serializable) {
            sb.append(value);
        }
        sb.append(']');

        return sb.toString();
    }

    @Override
    public int[] deserialize(String text) {
        if ("[]".equals(text)) {
            return new int[0];
        }
        if (text.length() == 0) {
            throw new DeserializeException("Can not parse empty string.");
        }

        List<Token> tokens = getTokens(text);
        List<Integer> result = new ArrayList<>(tokens.size() / 2);

        int nextState = 0;
        int sign = 1;
        for (Iterator<Token> iterator = tokens.iterator(); iterator.hasNext();) {
            Token token = iterator.next();
            nextState = STATE_MATRIX[nextState][token.type.ordinal()];
            if (nextState == -1) {
                throw new DeserializeException("Unexpected token '" + token.value + "'.");
            }
            if (nextState == END) {
                if (iterator.hasNext()) {
                    throw new DeserializeException("Unexpected end of input.");
                }
                break;
            }
            if (token.type == TokenType.SIGN) {
                sign = "+".equals(token.value)
                    ? 1 : -1;
            } else if (token.type == TokenType.DIGIT) {
                result.add(parseInt(token.value, sign));
                sign = 1;
            }
        }

        return toIntArray(result);
    }

    private int parseInt(String str, int sign) {
        long number;
        try {
            number = Long.parseLong(str) * sign;
        } catch (NumberFormatException e) {
            throw new DeserializeException("Invalid Number format with string: " + str, e);
        }
        if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE) {
            throw new DeserializeException(String.format("Number %s%s is too large.", sign == 1 ? "" : "-", str));
        }

        return (int) number;
    }

    private List<Token> getTokens(String text) {
        List<Token> token = new LinkedList<>();
        char[] buffer = new char[10];
        int j = 0;
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            // 数字读入已终结
            if (j != 0 && !Character.isDigit(ch)) {
                token.add(Token.of(String.valueOf(buffer, 0, j), TokenType.DIGIT));
                j = 0;
            }
            // 获取 token
            if (ch == '[') {
                token.add(Token.of("[", TokenType.LEFT_PARENTHESES));
            } else if (ch == ']') {
                token.add(Token.of("]", TokenType.RIGHT_PARENTHESES));
            } else if (ch == ',') {
                token.add(Token.of(",", TokenType.COMMA));
            } else if (ch == '-' || ch == '+') {
                token.add(Token.of(ch, TokenType.SIGN));
            } else if (Character.isDigit(ch)) {
                if (j < 10) {
                    buffer[j++] = ch;
                } else {
                    throw new DeserializeException(String.format("Number %s%c is too large.", String.valueOf(buffer), ch));
                }
            } else if (ch != ' ' && ch != '\r' && ch != '\n' && ch != '\t' && ch != '\f') {
                throw new DeserializeException("Unexpected token " + ch);
            }
            // else 跳过空白字符
        }

        return token;
    }

    private int[] toIntArray(List<Integer> list) {
        int[] result = new int[list.size()];
        int i = 0;
        for (Integer element : list) {
            result[i++] = element;
        }

        return result;
    }

    static class Token {

        String value;

        TokenType type;

        Token(String value, TokenType type) {
            this.value = value;
            this.type = type;
        }

        static Token of(String value, TokenType type) {
            return new Token(value, type);
        }

        static Token of(char ch, TokenType type) {
            return new Token(String.valueOf(ch), type);
        }
    }
}
