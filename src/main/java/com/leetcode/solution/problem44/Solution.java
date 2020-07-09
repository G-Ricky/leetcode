package com.leetcode.solution.problem44;

/**
 * 通配符匹配
 *
 * @author Ricky
 * @date 2020-07-05 22:13:27
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        boolean prevIsAny = false;
        for (int i = 0; i < p.length(); ++i) {
            if (p.charAt(i) == '*') {
                if (!prevIsAny) {
                    prevIsAny = true;
                    sb.append(".*?");
                }
            } else if (p.charAt(i) == '?') {
                sb.append('.');
                prevIsAny = false;
            } else {
                sb.append(p.charAt(i));
                prevIsAny = false;
            }
        }
        sb.append('$');
        return s.matches(sb.toString());
        // TODO 未通过
    }
}
