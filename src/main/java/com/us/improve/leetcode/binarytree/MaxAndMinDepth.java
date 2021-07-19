package com.us.improve.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MaxDepth
 * @Desciption 二叉树的最大/最小深度
 * @Author loren
 * @Date 2020/4/18 3:47 PM
 * @Version 1.0
 **/
public class MaxAndMinDepth {

    /**
     * 问题描述
     *
     * 给定一颗二叉树，求这颗二叉树的最大/最小深度
     */

    /**
     * 解题思路
     *
     * DFS变形，只要递归求出左右子树的最大/最小深度即可
     * 每递归调用一次函数，深度加一
     */

    /**
     * 求最大深度
     *
     * @param node
     * @return
     */
    public static int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getMaxDepth(node.getLeft()), getMaxDepth(node.getRight())) + 1;
    }

    /**
     * 求最小深度
     *
     * DFS
     *
     * @param node
     * @return
     */
    public static int getMinDepth(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.getLeft() == null) {
            return getMinDepth(node.getRight()) + 1;
        }

        if (node.getRight() == null) {
            return getMinDepth(node.getLeft()) + 1;
        }

        int leftDepth = getMinDepth(node.getLeft());
        int rightDepth = getMinDepth(node.getRight());

        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 求最小深度
     *
     * BFS
     *
     * @param node
     * @return
     */
    public static int getMinDepth2(Node node) {
        if (node == null) {
            return 0;
        }


        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        int depth = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();

            while (count > 0) {
                Node tmp = queue.poll();

                if (tmp.getLeft() == null) {
                    return depth;
                } else {
                    queue.add(tmp.getLeft());
                }

                if (tmp.getRight() == null) {
                    return depth;
                } else {
                    queue.add(tmp.getRight());
                }

                count--;
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left = new Node (2);
        Node right = new Node(3, new Node(4), new Node(5));
        root.setLeft(left);
        root.setRight(right);

        System.out.println(getMaxDepth(root));
        System.out.println(getMinDepth(root));
        System.out.println(getMinDepth2(root));
    }

}
