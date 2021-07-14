package com.us.improve.leetcode.linkedlist;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-08 22:34
 * @Version 1.0
 **/
public class Merge {

	/**
	 * 问题描述
	 *
	 * 合并两个有序单链表
	 */

	public static Node merge(Node n1, Node n2) {
		if (n1 == null) {
			return n2;
		}

		if (n2 == null) {
			return n1;
		}

		Node sentinel = new Node();
		Node p = sentinel;

		Node p1 = n1;
		Node p2 = n2;
		while (p1 != null && p2 != null) {
			if (p1.data < p2.data) {
				p.next = p1;

				p1 = p1.next;
			} else {
				p.next = p2;

				p2 = p2.next;
			}

			p = p.next;
		}

		while (p1 != null) {
			p.next = p1;

			p1 = p1.next;
			p = p.next;
		}

		while (p2 != null) {
			p.next = p2;

			p2 = p2.next;
			p = p.next;
		}

		return sentinel.next;
	}

	public static Node merge2(Node n1, Node n2) {
		if (n1 == null) {
			return n2;
		}

		if (n2 == null) {
			return n1;
		}

		Node p;
		if (n1.data < n2.data) {
			p = n1;
			p.next = merge(n1.next, n2);
		} else {
			p = n2;
			p.next = merge(n1, n2.next);
		}

		return p;
	}

	public static void main(String[] args) {
		Node h1 = new Node(1, null, new Node(5, null, new Node(10, null, null)));
		Node h2 = new Node(2, null, new Node(4, null, null));

		Node h = merge(h1, h2);
		h.displayList();
	}

}
