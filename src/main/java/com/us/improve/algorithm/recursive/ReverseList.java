package com.us.improve.algorithm.recursive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ReverseList
 * @Desciption 反转单链表
 * @Author loren
 * @Date 2020/6/17 7:38 PM
 * @Version 1.0
 **/
public class ReverseList {

    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newList = reverse(head.next);

        Node t1 = head.next;
        t1.next = head;
        head.next = null;

        return newList;
    }

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Node<T> {

    T data;

    Node next;

}
