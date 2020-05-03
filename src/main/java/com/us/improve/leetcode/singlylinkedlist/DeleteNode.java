package com.us.improve.leetcode.singlylinkedlist;

/**
 * @ClassName DeleteNode
 * @Desciption 删除链表中节点，要求时间复杂度为O(1)：有一个单链表，提供了头指针和一个结点指针，设计一个函数，在 O（1）时间内删除该结点指针指向的结点。
 * @Author loren
 * @Date 2020/4/11 2:09 PM
 * @Version 1.0
 **/
public class DeleteNode {

    /**
     * 问题描述
     *
     * 删除链表中节点，要求时间复杂度为O(1)
     * 有一个单链表，提供了头指针和一个结点指针，设计一个函数，在 O（1）时间内删除该结点指针指向的结点。
     *
     */

    /**
     * 解题思路
     *
     * 考虑3种情况：
     * 1：待删除的节点是头节点 -> head = head.next
     * 2：待删除的节点是尾节点(即没有后继节点) -> 从head开始遍历链表寻找待删除的节点
     * 3：待删除的节点是中间节点 -> 将delete.next的数据拷贝给delete，删除delete.next
     *
     * 平均情况时间复杂度为O(1)
     */

    public static Node deleteNode(Node head, Node delete) {
        if (head == null || delete == null) {
            return head;
        }

        // 如果待删除的节点是头节点
        if (head == delete) {
            head = head.getNext();
        } else if (delete.getNext() == null) { // 如果待删除的节点是尾节点
            Node p = head;
            while (p.getNext() != delete) {
                p = p.getNext();
            }
            p.setNext(null);
        } else { // 如果待删除的节点是中间节点
            delete.setData(delete.getNext().getData());
            delete.setNext(delete.getNext().getNext());
        }

        return head;
    }

    public static void main(String[] args) {
        Node nodeA = new Node(1, null);
        Traversal.display(nodeA);
        Traversal.display(deleteNode(nodeA, nodeA));

        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Traversal.display(node1);
    }

}
