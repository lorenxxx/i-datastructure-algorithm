package com.us.improve.leetcode.linkedlist;

/**
 * @ClassName Merge
 * @Desciption 合并两个有序单链表
 * @Author loren
 * @Date 2020/4/10 4:21 PM
 * @Version 1.0
 **/
public class Merge {

    /**
     * 问题描述
     *
     * 合并两个有序单链表
     */

    /**
     * 解题思路
     *
     */

    /**
     * 非递归实现
     *
     * @param node1
     * @param node2
     * @return
     */
    public static Node merge(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        Node sentinel = new Node();
        Node p = sentinel;
        Node p1 = node1;
        Node p2 = node2;
        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }

            p = p.next;
        }

        while (p1 != null) {
            p.next = p1;

            p1 = p1.next;
            p = p.next;
        }

        while (p2 != null) {
            p.next = p2;

            p2 = p2.next;
            p = p.next;
        }

        return sentinel.next;
    }

    /**
     * 递归实现
     *
     * @param node1
     * @param node2
     * @return
     */
    public static Node merge2(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        Node head;
        if (node1.data < node2.data) {
            head = node1;
            head.next = merge2(node1.next, node2);
        } else {
            head = node2;
            head.next = merge2(node1, node2.next);
        }

        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1, new Node(5, new Node(9, null)));
        Node head2 = new Node(2, new Node(4, new Node(10, null)));
        Node head = merge2(head1, head2);
        Traversal.display(head);
    }

}
