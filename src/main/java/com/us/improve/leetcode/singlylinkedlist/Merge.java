package com.us.improve.leetcode.singlylinkedlist;

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
     * @param head1
     * @param head2
     * @return
     */
    public static Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        // 哨兵
        Node sentinel = new Node();
        Node p = sentinel;
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.getData() < p2.getData()) {
                p.setNext(p1);
                p1 = p1.getNext();
            } else {
                p.setNext(p2);
                p2 = p2.getNext();
            }
            p = p.getNext();
        }

        while (p1 != null) {
            p.setNext(p1);
            p1 = p1.getNext();
            p = p.getNext();
        }

        while (p2 != null) {
            p.setNext(p2);
            p2 = p2.getNext();
            p = p.getNext();
        }

        return sentinel.getNext();
    }

    /**
     * 递归实现
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node merge2(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node head;
        if (head1.getData() < head2.getData()) {
            head = head1;
            head.setNext(merge2(head1.getNext(), head2));
        } else {
            head = head2;
            head.setNext(merge2(head1, head2.getNext()));
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
