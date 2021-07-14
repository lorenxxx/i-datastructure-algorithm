package com.us.improve.leetcode.linkedlist;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-08 23:06
 * @Version 1.0
 **/
public class Reverse {

	/**
	 * 问题描述
	 *
	 * 反转一个单链表
	 */

	public static Node process1(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node pre = null;
		Node cur = head;
		while (cur != null) {
			Node next = cur.next;

			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return pre;
	}

	public static Node process2(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node p = process2(head.next);
		head.next.next = head;
		head.next = null;

		return p;
	}

}
