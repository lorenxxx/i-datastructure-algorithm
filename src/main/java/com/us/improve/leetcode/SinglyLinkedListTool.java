package com.us.improve.leetcode;

import com.us.improve.leetcode.infra.SinglyLinkedList;

/**
 * @ClassName SinglyLinkedListTool
 * @Desciption TODO
 * @Author loren
 * @Date 2020/4/7 3:27 PM
 * @Version 1.0
 **/
public class SinglyLinkedListTool {

    /**
     * 搜索单链表倒数第K个节点
     *
     * @param head
     * @return
     */
    public SinglyLinkedList.Node searchNodeK1(SinglyLinkedList.Node head) {
        return null;
    }

    /**
     * 顺序打印单链表
     * @param head
     */
    public static void print(SinglyLinkedList.Node head) {
        if (head == null) {
            return;
        }

        SinglyLinkedList.Node p = head;
        while (p != null) {
            System.out.print(p.getData() + " -> ");
            p = p.getNext();
        }
        System.out.print("NULL");
        System.out.println();
        System.out.println();
    }

    /**
     * 反转一个单链表
     *
     * 非递归实现
     *
     */
    public static SinglyLinkedList.Node reverseList1(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node pre = null;
        SinglyLinkedList.Node cur = head;

        while (cur != null) {
            SinglyLinkedList.Node next = cur.getNext();

            cur.setNext(pre);

            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        SinglyLinkedList.Node head = SinglyLinkedList.build(new int[] {1, 2, 3, 4, 5});
        System.out.println("初始化单链表: ");
        print(head);

        System.out.println("反转单链表: ");
        print(reverseList1(head));
    }

}
