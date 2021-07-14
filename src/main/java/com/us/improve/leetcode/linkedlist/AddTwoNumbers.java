package com.us.improve.leetcode.linkedlist;

/**
 * @Author loren
 * @Description 两数相加
 * @Date 2020-12-31 11:25
 * @Version 1.0
 **/
public class AddTwoNumbers {

	/**
	 * 问题描述
	 * <p>
	 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
	 *
	 */

	static class Node<T> {

		private T data;

		private Node next;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}

		public void display() {
			StringBuilder sb = new StringBuilder();

			Node cur = this;
			while (cur != null) {
				sb.append(cur.data);
				sb.append("->");

				cur = cur.next;
			}

			sb.delete(sb.length() - 2, sb.length());

			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		Node<Integer> n1 = new Node(4, new Node(5, new Node(9, new Node(1, null))));
		Node<Integer> n2 = new Node(4, new Node(6, new Node(3, null)));

		n1.display();
		n2.display();

		Node n = process(n1, n2);
		n.display();
	}

	public static Node<Integer> process(Node<Integer> n1, Node<Integer> n2) {
		// 如果n1位空，返回n2
		if (n1 == null) {
			return n2;
		}

		// 如果n2位空，返回n1
		if (n2 == null) {
			return n1;
		}

		Node<Integer> head = null;
		Node<Integer> tail = null;
		Integer carry = 0;

		Node<Integer> h1 = n1;
		Node<Integer> h2 = n2;
		while (h1 != null || h2 != null) {
			Integer num1 = h1 != null ? h1.data : 0;
			Integer num2 = h2 != null ? h2.data : 0;

			Integer sum = num1 + num2 + carry;
			carry = sum >= 10 ? 1 : 0;

			if (head == null) {
				tail = new Node<>(sum % 10, null);
				head = tail;
			} else {
				tail.next = new Node<>(sum % 10, null);
				tail = tail.next;
			}

			if (h1 != null) {
				h1 = h1.next;
			}

			if (h2 != null) {
				h2 = h2.next;
			}
		}

		return head;
	}

}
