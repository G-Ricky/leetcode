package com.leetcode.solution.problem591;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 标签验证器
 *
 * @author Ricky
 * @date 2022-05-04 00:05:59
 */
public class Solution {

    private static final String CDATA_PREFIX = "<![CDATA[";

    private static final String CDATA_SUFFIX = "]]>";

    private static final String CLOSE_TAG_START = "</";

    private static final int CONTENT_INVALID = 0;

    private static final int CONTENT_VALID = 1;

    private static final int CONTENT_CLOSE_TAG = 100;

    private int pos = 0;

    private final Deque<String> tagStack = new LinkedList<>();

    public boolean isValid(String code) {
        return processStart(code);
    }

    private boolean processStart(String code) {
        return processOpenTag(code)
            && processContent(code)
            && processCloseTag(code);
    }

    private boolean processOpenTag(String code) {
        if (pos >= code.length()) {
            return false;
        }
        if (code.charAt(pos++) != '<') {
            return false;
        }
        StringBuilder temp = new StringBuilder();
        boolean isParenthesesClosed = false;
        while (pos < code.length()) {
            char ch = code.charAt(pos++);
            if (isUpperCase(ch)) {
                temp.append(ch);
            } else if (ch == '>') {
                isParenthesesClosed = true;
                break;
            } else {
                return false;
            }
        }
        if (!isParenthesesClosed) {
            return false;
        }
        String openTag = temp.toString();
        if (openTag.length() > 0 && openTag.length() <= 9) {
            tagStack.push(openTag);
            return true;
        } else {
            return false;
        }
    }

    private boolean processContent(String code) {
        if (pos >= code.length()) {
            return false;
        }
        while (pos < code.length()) {
            char ch = code.charAt(pos++);
            if (ch == '<') {
                int specialContentResult = processSpecialContent(code);
                if (specialContentResult == CONTENT_INVALID) {
                    return false;
                } else if (specialContentResult == CONTENT_CLOSE_TAG) {
                    return true;
                }
            }
        }
        return true;
    }

    /**
     * 在 TAG_CONTENT 中读取到一个 < 后的处理
     */
    private int processSpecialContent(String code) {
        if (pos >= code.length()) {
            return 0;
        }
        char ch = code.charAt(pos++);
        if (isUpperCase(ch)) { // 假定接下来的内容是一个起始标签
            pos -= 2; // 回溯指针
            return processStart(code) ? CONTENT_VALID : CONTENT_INVALID; // 递归解析嵌套标签
        } else if (ch == '/') { // 假定接下来的内容是一个结束标签
            pos -= 2;
            return CONTENT_CLOSE_TAG;
        } else if (ch == '!') { // 假定接下来的内容是一个 CDATA
            pos -= 2;
            return processCDATA(code) ? CONTENT_VALID : CONTENT_INVALID;
        } else {
            return 0;
        }
    }

    private boolean processCDATA(String code) {
        if (pos >= code.length()) {
            return false;
        }
        if (!checkAhead(code, CDATA_PREFIX)) {
            return false;
        }
        while (pos < code.length()) {
            char ch = code.charAt(pos);
            if (ch == ']' && checkAhead(code, CDATA_SUFFIX)) {
                return true;
            }
            pos++;
        }
        return false;
    }

    private boolean processCloseTag(String code) {
        if (tagStack.isEmpty()) {
            return false;
        }
        String openTag = tagStack.pop();
        if (pos >= code.length()) {
            return false;
        }
        if (!checkAhead(code, CLOSE_TAG_START)) {
            return false;
        }

        StringBuilder temp = new StringBuilder();
        boolean isParenthesesClosed = false;
        while (pos < code.length()) {
            char ch = code.charAt(pos++);
            if (isUpperCase(ch)) {
                temp.append(ch);
            } else if (ch == '>') {
                isParenthesesClosed = true;
                break;
            } else {
                return false;
            }
        }
        if (!isParenthesesClosed) {
            return false;
        }
        String closeTag = temp.toString();
        if (closeTag.length() == 0 || !closeTag.equals(openTag)) {
            return false;
        }

        // 最后一个标签弹出时，如果 code 未到结尾算无效
        if (tagStack.isEmpty() && pos < code.length()) {
            return false;
        }
        return true;
    }

    private boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private String peek(String code, int pos, int len) {
        if (pos + len > code.length()) {
            return null;
        } else {
            return code.substring(pos, pos + len);
        }
    }

    private boolean checkAhead(String code, String compare) {
        String toCompare = peek(code, pos, compare.length());
        if (compare.equals(toCompare)) {
            pos += compare.length();
            return true;
        } else {
            return false;
        }
    }
}