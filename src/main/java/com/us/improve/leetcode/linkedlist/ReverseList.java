package com.us.improve.leetcode.linkedlist;

/**
 * @ClassName ReverseList
 * @Desciption 反转单链表
 * @Author loren
 * @Date 2020/4/11 3:00 PM
 * @Version 1.0
 **/
public class ReverseList {

    /**
     * 问题描述
     *
     * 反转一个单链表
     */

    /**
     * 解题思路
     *
     *
     */

    /**
     * 非递归实现
     *
     * @param node
     * @return
     */
    public static Node reverseList1(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node pre = null;
        Node cur = node;
        while (cur != null) {
            Node next = cur.next;

            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public static Node reverseList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node next = head.next;

        Node newHead = reverseList2(next);

        next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Node head;
        head = new Node(1, new Node(2, new Node(3, null)));
        Traversal.display(head);

        head = reverseList2(head);
        Traversal.display(head);
    }

}
