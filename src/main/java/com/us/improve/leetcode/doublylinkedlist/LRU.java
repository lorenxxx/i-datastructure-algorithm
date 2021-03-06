package com.us.improve.leetcode.doublylinkedlist;

/**
 * @ClassName LRU
 * @Desciption LRU缓存置换算法
 * @Author loren
 * @Date 2020/4/11 4:04 PM
 * @Version 1.0
 **/
public class LRU {

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

	public LRU(int maxCacheSize) {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.maxCacheSize = maxCacheSize > 0 ? maxCacheSize : DEFAULT_MAX_CACHE_SIZE;
	}

	public void addCache(Node node) {
		if (node == null) {
			return;
		}

		if (head == null) {
			head = node;
			tail = node;
			size++;
			return;
		} else {
			Node exist = findCache(node);
			if (exist == null) {
				if (size == maxCacheSize) {
					tail = tail.pre;
					tail.next = null;

					node.next = head;
					head.pre = node;
					head = node;
				} else {
					node.next = head;
					head.pre = node;
					head = node;
					size++;
				}
			} else {
				if (exist == tail) {
					tail = tail.pre;
					tail.next = null;

					exist.next = head;
					head.pre = exist;
					head = exist;
				} else {
					exist.pre.next = exist.next;
					exist.next.pre = exist.pre;

					exist.next = head;
					head.pre = exist;
					head = exist;
				}
			}
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
		LRU cache = new LRU(3);

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
