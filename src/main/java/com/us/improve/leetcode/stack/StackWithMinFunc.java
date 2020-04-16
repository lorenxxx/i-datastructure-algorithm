package com.us.improve.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName MinValueInStack
 * @Desciption 包含min函数的栈
 * @Author loren
 * @Date 2020/4/16 2:25 PM
 * @Version 1.0
 **/
public class StackWithMinFunc {

    /**
     * 问题描述
     *
     * 实现一个栈，包含一个min函数，min函数返回栈中最小的元素
     */

    /**
     * 解题思路
     *
     * 使用两个栈 dataStack minStack
     * dataStack正常存储数据
     * minStack的栈顶存储dataStack当前最小元素
     */

    private Stack<Integer> dataStack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer data) {
        dataStack.push(data);
        minStack.push(minStack.isEmpty() ? data : Math.min(data, minStack.peek()));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMinFunc stack = new StackWithMinFunc();
        stack.push(3);
        stack.push(9);
        stack.push(5);
        System.out.println(stack.min());

        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }

}
