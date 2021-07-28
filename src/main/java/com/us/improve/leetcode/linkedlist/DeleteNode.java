package com.us.improve.leetcode.linkedlist;

/**
 * @ClassName DeleteNode
 * @Desciption
 * @Author loren
 * @Date 2020/4/11 2:09 PM
 * @Version 1.0
 **/
public class DeleteNode {

	/**
	 * 问题描述
	 *
	 * 删除链表中节点，要求时间复杂度为O(1)
	 * 有一个单链表，提供了头指针和一个节点指针，设计一个函数，在 O（1）时间内删除该结点指针指向的结点。
	 *
	 */

	/**
	 * 解题思路
	 * <p>
	 * 考虑3种情况：
	 * 1：待删除的节点是头节点 -> head = head.next
	 * 2：待删除的节点是尾节点(即没有后继节点) -> 从head开始遍历链表寻找待删除的节点
	 * 3：待删除的节点是中间节点 -> 将delete.next的数据拷贝给delete，删除delete.next
	 * <p>
	 * 平均情况时间复杂度为O(1)
	 */

	public static Node deleteNode(Node head, Node delete) {
		if (head == null || delete == null) {
			return head;
		}

		// 如果待删除的节点是头节点
		if (head == delete) {
			head = head.next;
		} else if (delete.next == null) {
			// 如果待删除的节点是尾节点
			Node p = head;
			while (p.next != delete) {
				p = p.next;
			}

			p.next = null;
		} else {
			// 如果待删除的节点是中间节点
			delete.data = delete.next.data;
			delete.next = delete.next.next;
		}

		return head;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		Node n = deleteNode(n1, n3);
		Traversal.display(n);
	}

}
