package com.us.improve.leetcode.linkedlist;

/**
 * @ClassName LRU
 * @Desciption LRU缓存置换算法
 * @Author loren
 * @Date 2020/4/11 4:18 PM
 * @Version 1.0
 **/
public class LRU {

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
			tail = head;
			size++;
			return;
		} else {
			Node exist = findCache(node);
			// 如果新节点不在缓存中
			if (exist == null) {
				// 如果缓存已满，则删除头节点
				if (size == maxCacheSize) {
					head = head.next;
					size--;
				}

				// 新节点加入到缓存尾部
				tail.next = node;
				tail = node;
				size++;
			} else {
				// 如果新节点在缓存中
				// 如果新节点是尾节点
				if (tail.data == node.data) {
					return;
				} else {
					exist.data = exist.next.data;
					exist.next = exist.next.next;

					// 新节点加入到缓存尾部
					tail.next = node;
					tail = node;
				}
			}
		}
	}

	public void addCache2(Node node) {
		if (node == null) {
			return;
		}

		if (head == null) {
			head = node;
			tail = head;

			size++;
			return;
		} else {
			Node exist = findCache(node);
			if (exist == null) {
				if (size == maxCacheSize) {
					head = head.next;
					size--;
				}

				tail.next = node;
				tail = tail.next;
				size++;
			} else {
				if (tail.data == node.data) {
					return;
				} else {
					exist.data = exist.next.data;
					exist.next = exist.next.next;

					tail.next = node;
					tail = tail.next;
				}
			}
		}
	}

    public Node findCache(Node node) {
    	if (head == null || node == null) {
    		return null;
		}

    	Node p = head;
		while (p != null) {
			if (p.data == node.data) {
				return p;
			}

			p = p.next;
		}

		return null;
	}

    public Node head() {
        return head;
    }

    public static void main(String[] args) {
        LRU cache = new LRU(3);
        cache.addCache(new Node(1));
        cache.addCache(new Node(2));
        cache.addCache(new Node(3));

        Traversal.display(cache.head());

        cache.addCache(new Node(4));
        Traversal.display(cache.head());

        cache.addCache(new Node(3));
        Traversal.display(cache.head());

        cache.addCache(new Node(2));
        Traversal.display(cache.head());
    }

}
