package com.leetcode.solution.problem385;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    private List<String> tokens = new ArrayList<>();

    public NestedInteger deserialize(String s) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '[') {
                tokens.add("[");
            } else if (ch == ']') {
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }
                tokens.add("]");
            } else if (ch == '-') {
                number.append(ch);
            } else if (ch == ',') {
                if (number.length() > 0) {
                    tokens.add(number.toString());
                    number.setLength(0);
                }
                tokens.add(",");
            } else {
                number.append(ch);
            }
        }
        if (number.length() > 0) {
            tokens.add(number.toString());
        }
        if (tokens.size() == 1) {
            return new NestedInteger(Integer.parseInt(tokens.get(0)));
        }
        List<NestedInteger> nestedIntegerList = null;
        Deque<List<NestedInteger>> nestedIntegerListStack = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("[")) {
                if (nestedIntegerList != null) {
                    nestedIntegerListStack.push(nestedIntegerList);
                }
                nestedIntegerList = new ArrayList<>();
            } else if (token.equals("]")) {
                if (nestedIntegerListStack.isEmpty()) {
                    NestedInteger root = new NestedInteger();
                    for (NestedInteger nestedInteger : nestedIntegerList) {
                        root.add(nestedInteger);
                    }
                    return root;
                } else {
                    List<NestedInteger> innerNestedIntegerList = nestedIntegerList;
                    NestedInteger innerNestedInteger = new NestedInteger();
                    for (NestedInteger nestedInteger : innerNestedIntegerList) {
                        innerNestedInteger.add(nestedInteger);
                    }
                    nestedIntegerList = nestedIntegerListStack.pop();
                    nestedIntegerList.add(innerNestedInteger);
                }
            } else if (token.equals(",")) {

            } else {
                int num = Integer.parseInt(token);
                NestedInteger nestedInteger = new NestedInteger(num);
                nestedIntegerList.add(nestedInteger);
            }
        }
        NestedInteger root = new NestedInteger();
        for (NestedInteger nestedInteger : nestedIntegerList) {
            root.add(nestedInteger);
        }
        return root;
    }

}