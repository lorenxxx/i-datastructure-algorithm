package com.us.improve.leetcode.singlylinkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName IsExistLoop
 * @Desciption 判断链表是否有环
 * @Author loren
 * @Date 2020/4/10 3:13 PM
 * @Version 1.0
 **/
public class IsExistLoop {

    /**
     * 暴力穷举
     *
     * @param head
     * @return
     */
    public static boolean isExistLoop(Node head) {
        Set<Integer> set = new HashSet<>();
        Node p = head;
        while (p != null) {
            if (set.contains(p.getData())) {
                return true;
            }
            set.add(p.getData());
            p = p.getNext();
        }

        return false;
    }

    /**
     * 快慢指针法
     *
     * @param head
     * @return
     */
    public static boolean isExistLoop2(Node head) {
        Node fast = head;
        Node slow = head;

        while (slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow != null && fast != null && slow.getData() == fast.getData()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.println(isExistLoop(node1));

        node5.setNext(node3);

        System.out.println(isExistLoop(node1));

        System.out.println(isExistLoop2(node1));
    }

}
