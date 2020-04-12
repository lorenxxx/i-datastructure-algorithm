package com.us.improve.leetcode.singlylinkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Node
 * @Desciption 单向链表节点
 * @Author loren
 * @Date 2020/4/10 2:36 PM
 * @Version 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Node {

    private int data;

    private Node next;

    public Node(int data) {
        this(data, null);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

}
