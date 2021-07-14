package com.us.improve.leetcode.linkedlist;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-08 22:36
 * @Version 1.0
 **/
public class Node {

	public int data;

	public Node pre;

	public Node next;

	public Node(int data, Node pre, Node next) {
		this.data = data;
		this.pre = pre;
		this.next = next;
	}

	public Node(int data) {
		this(data, null, null);
	}

	public Node() {

	}

	public void displayList() {
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
