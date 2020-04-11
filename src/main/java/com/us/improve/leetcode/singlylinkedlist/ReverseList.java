package com.us.improve.leetcode.singlylinkedlist;

/**
 * @ClassName ReverseList
 * @Desciption 反转一个单链表
 * @Author loren
 * @Date 2020/4/11 3:00 PM
 * @Version 1.0
 **/
public class ReverseList {

    public static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }

        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.getNext();

            cur.setNext(pre);
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static Node reverseList2(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node reHead = reverseList2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return reHead;
    }

    public static void main(String[] args) {
        Node head;
        head = new Node(1, new Node(2, new Node(3, null)));
        Traversal.display(head);

        head = reverseList2(head);
        Traversal.display(head);
    }

}
