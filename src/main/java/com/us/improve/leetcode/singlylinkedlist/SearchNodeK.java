package com.us.improve.leetcode.singlylinkedlist;

/**
 * @ClassName SearchNodeK
 * @Desciption 输入一个单链表，输出此链表中的倒数第 K 个节点
 * @Author loren
 * @Date 2020/4/10 2:38 PM
 * @Version 1.0
 **/
public class SearchNodeK {

    /**
     * 问题描述
     *
     * 输入一个单链表，输出链表中的倒数第 K 个节点
     */

    /**
     * 二次遍历法
     *
     * @param head
     * @param k
     * @return
     */
    public static Node searchNodeK1(Node head, int k) {
        int count = 0;

        Node p = head;
        while (p != null) {
            count++;
            p = p.getNext();
        }

        if (count < k) {
            return null;
        }

        Node pp = head;
        for (int i = 0; i < count - k; i++) {
            pp = pp.getNext();
        }

        return pp;
    }

    /**
     * 双指针法
     *
     * @param head
     * @param k
     * @return
     */
    public static Node searchNodeK2(Node head, int k) {
        Node fast = head;
        Node slow = head;

        // fast先出发
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.getNext();
            } else {
                return null;
            }
        }

        // 此时fast和slow间隔k个节点
        // fast和slow同时向链表末尾移动
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.setNext(new Node(2, null));
        head.getNext().setNext(new Node(3, null));

        Traversal.display(head);
        Node node = searchNodeK1(head, 3);
        System.out.println(node);

        node = searchNodeK2(head, 3);
        System.out.println(node);
    }

}
