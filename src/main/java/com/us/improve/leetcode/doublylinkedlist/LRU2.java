package com.us.improve.leetcode.doublylinkedlist;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-08 22:09
 * @Version 1.0
 **/
public class LRU2 {

	static class Node {

		private int data;

		private Node pre;

		private Node next;

		public Node(int data, Node pre, Node next) {
			this.data = data;
			this.pre = pre;
			this.next = next;
		}

		public Node(int data) {
			this(data, null, null);
		}

	}

	private static final int DEFAULT_MAX_CACHE_SIZE = 10;

	private Node head;

	private Node tail;

	private int size;

	private int maxCacheSize;

	public LRU2(int maxCacheSize) {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.maxCacheSize = maxCacheSize > 0 ? maxCacheSize : DEFAULT_MAX_CACHE_SIZE;
	}

	public void addFirst(Node node) {
		if (node == null) {
			return;
		}

		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.pre = node;

			head = node;
		}

		size++;
	}

	public void remove(Node node) {
		if (node == null) {
			return;
		}


	}

	public void addCache(Node node) {
		if (node == null) {
			return;
		}

		if (head == null) {
			addFirst(node);
		} else {
			Node exist = findCache(node);
		}
	}

	public Node findCache(Node node) {
		if (this.head == null || node == null) {
			return null;
		}

		Node p = this.head;
		while (p != null) {
			if (p.data == node.data) {
				return p;
			}

			p = p.next;
		}

		return null;
	}

	public void display() {
		if (head == null) {
			return;
		}

		Node p = head;
		while (p != null) {
			System.out.print(p.data + " -> ");
			p = p.next;
		}

		System.out.println("NULL");
		System.out.println("head: " + head.data + ", tail: " + tail.data + ", size: " + size);
	}

	public static void main(String[] args) {
		LRU2 cache = new LRU2(3);

		cache.addCache(new Node(1));
		cache.addCache(new Node(2));
		cache.addCache(new Node(3));

		cache.display();

		cache.addCache(new Node(4));

		cache.display();

		cache.addCache(new Node(2));

		cache.display();

		cache.addCache(new Node(4));

		cache.display();
	}

}
