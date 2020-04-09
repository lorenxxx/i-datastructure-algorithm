package com.us.improve.algorithm.others.linkedlist;

/**
 * @ClassName SinglyLinkedList
 * @Desciption 单向链表
 * @Author loren
 * @Date 2020/4/6 4:56 PM
 * @Version 1.0
 **/
public class SinglyLinkedList {

    private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    private Node tail;

    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        size++;
    }

    public void delete(int data) {
        Node pre = null;
        Node p = head;
        while (p != null) {
            if (p.data != data) {
                pre = p;
                p = p.next;
            } else {
                break;
            }
        }

        if (pre != null) {
            pre.next = p.next;
        }
    }

    public void display() {
        if (head != null) {
            Node p = head;
            do {
                System.out.print(p.data + " -> ");
                p = p.next;
            } while (p != null);
            System.out.println();
        }
    }

}
