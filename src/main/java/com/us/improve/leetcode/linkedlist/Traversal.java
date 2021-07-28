package com.us.improve.leetcode.linkedlist;

/**
 * @ClassName Traversal
 * @Desciption 遍历链表
 * @Author loren
 * @Date 2020/4/10 2:39 PM
 * @Version 1.0
 **/
public class Traversal {

    public static void display(Node node) {
        Node p = node;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }

        System.out.println();
    }

    public static void reverseDisplay(Node node) {
        if (node == null) {
            return;
        }

        reverseDisplay(node.next);

        System.out.print(node.data + " ");
    }

}
