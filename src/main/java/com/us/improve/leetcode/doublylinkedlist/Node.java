package com.us.improve.leetcode.doublylinkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Node
 * @Desciption 双向链表节点
 * @Author loren
 * @Date 2020/4/11 3:58 PM
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Node<T> {

    private T data;

    private Node pre;

    private Node next;

    public Node(T data) {
        this(data, null, null);
    }

}
