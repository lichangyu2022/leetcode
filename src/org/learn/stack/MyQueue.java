package org.learn.stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
 */
public class MyQueue {


    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            in2OutStack();
        }
        return outStack.pop();
    }

    private void in2OutStack() {
        if(inStack.isEmpty()){
            return;
        }
        outStack.push(inStack.pop());
        in2OutStack();
    }

    public int peek() {
        if(outStack.isEmpty()){
            in2OutStack();
        }
        return outStack.peek();
    }

    public boolean empty() {
        if(outStack.isEmpty() && inStack.isEmpty()){
            return true;
        }
        return false;
    }

}
