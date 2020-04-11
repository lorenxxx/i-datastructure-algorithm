package com.us.improve.leetcode.singlylinkedlist;

import java.util.Stack;

/**
 * @ClassName Traversal
 * @Desciption TODO
 * @Author loren
 * @Date 2020/4/10 2:39 PM
 * @Version 1.0
 **/
public class Traversal {

    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.getData() + " -> ");
            head = head.getNext();
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void reverseDisplay(Node head) {
        if (head == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.getData());
            head = head.getNext();
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " -> ");
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void reverseDisplay2(Node head) {
        if (head == null) {
            return;
        }

        reverseDisplay2(head.getNext());
        System.out.println(head.getData());
    }

}
