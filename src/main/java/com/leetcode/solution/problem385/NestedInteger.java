package com.leetcode.solution.problem385;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricky
 * @date 2022-04-15 23:04:50
 */
public class NestedInteger {

    private Integer value;

    private List<NestedInteger> list;

      // Constructor initializes an empty nested list.
      public NestedInteger() {

      };

      // Constructor initializes a single integer.
      public NestedInteger(int value) {
          this.value = value;
      }

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger() {
          return value != null;
      }

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger() {
          return value;
      }

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value) {
          this.value = value;
      }

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni) {
          if (list == null) {
              list = new ArrayList<>();
          }
          list.add(ni);
      }

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList() {
          return list;
      }
}
