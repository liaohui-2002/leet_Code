package com.liaohui.all.ex_Stack.ex_用队列实现栈_225;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @auther Mr.Liao
 * @date 2021/9/9 21:54
 */
public class MyStack {
    Deque<Integer> q1 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offerLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = q1.size();
        while (size > 1){
            q1.offerLast(q1.removeFirst());
            size--;
        }
        return q1.removeFirst();
    }

    /** Get the top element. */
    public int top() {
        return q1.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

