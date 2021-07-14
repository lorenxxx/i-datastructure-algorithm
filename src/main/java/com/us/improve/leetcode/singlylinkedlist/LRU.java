package com.us.improve.leetcode.singlylinkedlist;

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
            tail = node;
            size++;
            return;
        } else {
            Node exist = findCache(node);
            // 如果新节点不在缓存中
            if (exist == null) {
                // 如果缓存已满，则删除头节点
                if (size == maxCacheSize) {
                    head = head.getNext();
                    size--;
                }
                // 新节点加入到缓存尾部
                tail.setNext(node);
                tail = node;
                size++;
            } else { // 如果新节点在缓存中
                // 如果新节点是尾节点
                if (tail.getData() == node.getData()) {

                    return;
                } else {
                    exist.setData(exist.getNext().getData());
                    exist.setNext(exist.getNext().getNext());

                    // 新节点加入到缓存尾部
                    tail.setNext(node);
                    tail = node;
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
            if (p.getData() == node.getData()) {
                return p;
            }
            p = p.getNext();
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
