package com.us.improve.leetcode.infra;

import lombok.Data;

/**
 * @ClassName SinglyLinkedList
 * @Desciption 单向链表
 * @Author loren
 * @Date 2020/4/7 2:55 PM
 * @Version 1.0
 **/
public class SinglyLinkedList {

    @Data
    public class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    private Node tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int data) {
        Node node = new Node(data, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public static Node build(int[] nums) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int num : nums) {
            list.add(num);
        }
        return list.head;
    }

}
