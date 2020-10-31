package com.leetcode.serializer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 二维 int 数组解析器
 *
 * @author Ricky
 * @date 2020-10-31 21:43:27
 */
public class IntArray2Serializer implements Serializer<int[][]> {

    private static final int END = 12;

    private static final int[][] STATE_MATRIX = new int[][]{
        // '[', ']', '\d', ','
        {1, -1, -1, -1},
        {2, END, -1, -1},
        {-1, 4, 3, -1},
        {-1, 4, -1, 5},
        {-1, END, -1, 6},
        {-1, -1, 3, -1},
        {7, -1, -1, -1},
        {-1, 9, 8, -1},
        {-1, 9, -1, 10},
        {-1, END, -1, 6},
        {-1, -1, 8, -1},
    };

    enum TokenType {
        LEFT_PARENTHESES,
        RIGHT_PARENTHESES,
        DIGIT,
        COMMA,
    }

    @Override
    public String serialize(int[][] serializable) {
        return null;
    }

    @Override
    public int[][] deserialize(String text) {
        List<Token> tokens = getTokens(text);
        int state = 0;
        int level = 0;
        List<List<Integer>> outerList = new LinkedList<>();
        List<Integer> innerList = null;
        int innerMaxLength = 0;
        for (Iterator<Token> iterator = tokens.iterator(); iterator.hasNext();) {
            Token token = iterator.next();
            state = STATE_MATRIX[state][token.type.ordinal()];
            if (state == -1) {
                throw new DeserializeException("Unexpected token '" + token.value + "'.");
            }
            if (state == END) {
                if (iterator.hasNext()) {
                    throw new DeserializeException("Unexpected end of input.");
                }
                break;
            }
            if (token.type == TokenType.DIGIT) {
                assert innerList != null;
                innerList.add(Integer.valueOf(token.value));
            } else if (token.type == TokenType.LEFT_PARENTHESES) {
                ++level;
                if (level == 2) {
                    innerList = new LinkedList<>();
                }
            } else if (token.type == TokenType.RIGHT_PARENTHESES) {
                --level;
                if (level == 1) {
                    assert innerList != null;
                    innerMaxLength = Math.max(innerMaxLength, innerList.size());
                    outerList.add(innerList);
                }
            }
        }
        int[][] result = new int[outerList.size()][];
        int i = 0;
        for (List<Integer> innerList2 : outerList) {
            result[i] = new int[innerList2.size()];
            int j = 0;
            for (Integer val : innerList2) {
                result[i][j] = val;
                ++j;
            }
            ++i;
        }
        return result;
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
