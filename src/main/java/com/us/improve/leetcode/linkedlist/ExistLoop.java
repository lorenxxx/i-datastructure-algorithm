package com.us.improve.leetcode.linkedlist;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-08 23:00
 * @Version 1.0
 **/
public class ExistLoop {

	/**
	 * 问题描述
	 *
	 * 给定一个单链表，判断链表中是否存在环
	 */

	public static boolean check(Node head) {
		Node slow = head;
		Node fast = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow != null && fast != null && slow.data == fast.data) {
				return true;
			}
		}

		return false;
	}

}
