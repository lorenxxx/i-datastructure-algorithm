package com.us.improve.leetcode.linkedlist;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-20 23:03
 * @Version 1.0
 **/
public class AddTwoNumbers {

	/**
	 * 问题描述
	 *
	 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
 	 *
	 */

	public static Node addTwoNumbers(Node n1, Node n2) {
		if (n1 == null) {
			return n2;
		}

		if (n2 == null) {
			return n1;
		}

		Node head = null;
		Node tail = null;

		int carry = 0;
		while (n1 != null || n2 != null) {
			int num1 = n1 != null ? n1.data : 0;
			int num2 = n2 != null ? n2.data : 0;

			int sum = num1 + num2 + carry;
			carry = sum >= 10 ? 1 : 0;

			Node node = new Node(sum % 10);
			if (head == null) {
				head = node;
				tail = head;
			} else {
				tail.next = node;
				tail = node;
			}

			if (n1 != null) {
				n1 = n1.next;
			}

			if (n2 != null) {
				n2 = n2.next;
			}
		}

		if (carry == 1) {
			Node node = new Node(1);
			tail.next = node;
			tail = tail.next;
		}

		return head;
	}

	public static void main(String[] args) {
		Node n1 = new Node(2, new Node(7, new Node(9)));
		Node n2 = new Node(4, new Node(9));

		Traversal.display(n1);
		Traversal.display(n2);

		Node n = addTwoNumbers(n1, n2);

		Traversal.display(n);
	}

}
