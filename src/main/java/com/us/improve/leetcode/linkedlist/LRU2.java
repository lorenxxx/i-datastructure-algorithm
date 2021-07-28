package com.us.improve.leetcode.linkedlist;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-27 21:13
 * @Version 1.0
 **/
public class LRU2 {

	private Node head;

	private int size;

	private int maxSize;

	public LRU2(int maxSize) {
		this.head = null;
		this.size = 0;
		this.maxSize = maxSize;
	}

	public void addCache(int value) {
		if (head == null) {
			addHead(value);
			return;
		}

		if (head.data == value) {
			return;
		}

		Node prevNode = findPrev(value);
		if (prevNode != null) {
			remove(value);
			addHead(value);
		} else {
			if (size >= maxSize) {
				removeTail();
			}
			addHead(value);
		}
	}

	public void addHead(int value) {
		Node node = new Node(value);

		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}

		size++;
	}

	public void removeTail() {
		if (head == null) {
			return;
		}

		if (head.next == null) {
			head = null;
			size--;
			return;
		}

		Node p = head;
		while (p.next.next != null) {
			p = p.next;
		}

		p.next = null;

		size--;
	}

	public void remove(int value) {
		if (head == null) {
			return;
		}

		Node prev = findPrev(value);
		if (prev != null) {
			prev.next = prev.next.next;
		}
	}

	public Node findPrev(int value) {
		if (head == null) {
			return null;
		}

		Node p = head;
		while (p.next != null) {
			if (p.next.data == value) {
				return p;
			}

			p = p.next;
		}

		return null;
	}

	public void display() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + " ");

			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LRU2 cache = new LRU2(1);
		cache.addCache(1);
		cache.addCache(2);
		cache.addCache(3);

		cache.addCache(4);

		cache.display();
	}

}
