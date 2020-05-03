package com.us.improve.leetcode.hash;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @ClassName ConsistentHash
 * @Desciption 一致性Hash算法
 * @Author loren
 * @Date 2020/4/24 8:22 PM
 * @Version 1.0
 **/
public class ConsistentHash {

    /**
     * 问题描述
     *
     * 一致性hash算法
     */

    /**
     * 解题思路
     *
     *
     */

    /**
     * 圆环
     */
    private TreeMap<Long, Node> circle = new TreeMap<>();

    /**
     * 真实节点
     */
    private List<Node> realNodes = new ArrayList<>();

    public void addNode(Node node) {
        Long nodeKey = md5(node.toString());
        circle.put(nodeKey, node);

        realNodes.add(node);
    }

    public void removeNode(Node node) {
        Long nodeKey = md5(node.toString());
        circle.remove(nodeKey);

        realNodes.remove(nodeKey);
    }

    public Node getNode(String key) {
        Long keyMd5 = md5(key);
        SortedMap<Long, Node> sortedMap = circle.tailMap(keyMd5);

        Long k;
        if (sortedMap.isEmpty()) {
            k = (circle.firstKey());
        } else {
            k = (sortedMap.firstKey());
        }
        Node node = circle.get(k);
        return node;
    }

    private Long md5(String key) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bKey = md.digest(key.getBytes());

        long res = ((long) (bKey[3] & 0xFF) << 24) | ((long) (bKey[2] & 0xFF) << 16) | ((long) (bKey[1] & 0xFF) << 8) | bKey[0] & 0xFF;
        return res;
    }


    public static void main(String[] args) throws Exception {
        ConsistentHash consistentHash = new ConsistentHash();
        consistentHash.addNode(new Node(1));
        consistentHash.addNode(new Node(3));
        consistentHash.addNode(new Node(5));
        consistentHash.addNode(new Node(7));
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class Node {

        private int nodeNum;

        @Override
        public String toString() {
            return "Node" + nodeNum;
        }

    }

}
