package com.us.improve.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName StackQueue
 * @Desciption 用栈模拟队列
 * @Author loren
 * @Date 2020/4/15 5:46 PM
 * @Version 1.0
 **/
public class StackQueue<T> {

    /**
     * 问题描述
     *
     * 用栈模拟队列
     * 栈：先进后出
     * 队列：先进先出
     */

    /**
     * 使用两个栈
     */

    private Stack<T> stackA;

    private Stack<T> stackB;

    private int size;

    public StackQueue() {
        this.stackA = new Stack<>();
        this.stackB = new Stack<>();
        this.size = 0;
    }

    public void enqueen(T data) {
        stackA.push(data);
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        }

        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }

        T ret = stackB.pop();
        size--;
        return ret;
    }

    public static void main(String[] args) {
        StackQueue<Integer> stackQueen = new StackQueue<>();

        int[] nums = {1, 2, 3, 4, 5};
        for (int num : nums) {
            stackQueen.enqueen(num);
        }

        while(true) {
            Integer num = stackQueen.dequeue();
            if (num != null) {
                System.out.println(num);
            } else {
                break;
            }
        }
    }

}
