package com.leetcode.solution.problem925;

/**
 * 长按键入
 *
 * @author Ricky
 * @date 2020-10-21 22:52:35
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        Character prev = null;
        while (i < name.length() && j < typed.length()) {
            char ch1 = name.charAt(i);
            char ch2 = typed.charAt(j);
            // 第一个字符的位置
            if (prev == null) {
                // 两个字符串的首个字符必须相等，不相等后面都不需要判断了
                if (ch1 != ch2) {
                    return false;
                } else {
                    prev = ch1;
                }
            } else {
                // 两个指针都不同的时候，j 指针指向的字符必须等于 i 指针的上一个字符，此时 i 指针不需要移动，prev 不需要改变
                /*    --- prev
                 *   / --- i
                 *  / /
                 * A B
                 * A A A A B
                 *    \
                 *     --- j
                 */
                if (ch1 != ch2) {
                    if (ch2 != prev) {
                        return false;
                    } else {
                        ++j;
                    }
                    // 两个指针指向的字符都相同，只需要两个指针各移动一位
                } else {
                    ++i;
                    ++j;
                    prev = ch1;
                }
            }
        }
        // 同时到达结尾
        if (i == name.length() && j == typed.length()) {
            return true;
            // name 到达结尾，typed 未到达结尾
        } else if (i == name.length()) {
            // name 空白，typed 具有任意长度时
            if (prev == null) {
                return false;
            }
            while (j < typed.length()) {
                if (typed.charAt(j) != prev) {
                    return false;
                }
                ++j;
            }
            return true;
            // name 未到达结尾，typed 到达结尾
        } else {
            return false;
        }
    }
}
