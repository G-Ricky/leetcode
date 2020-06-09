package com.leetcode.problem225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        Integer top = null;
        for (int i = 0; i < size; ++i) {
            top = queue.poll();
            if (i < size - 1) {
                queue.add(top);
            }
        }

        return top;
    }

    /** Get the top element. */
    public int top() {
        int size = queue.size();
        Integer top = null;
        for (int i = 0; i < size; ++i) {
            top = queue.poll();
            queue.add(top);
        }

        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
