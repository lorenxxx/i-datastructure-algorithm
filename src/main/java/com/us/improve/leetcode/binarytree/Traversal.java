package com.us.improve.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Traversal
 * @Desciption 二叉树遍历
 * @Author loren
 * @Date 2020/4/8 3:59 PM
 * @Version 1.0
 **/
public class Traversal {

    /**
     * 前序遍历
     *
     * 根->左->右
     *
     * @param node
     * @return
     */
    public static List<Integer> preOrder(Node node) {
        List<Integer> res = new ArrayList<>();
        doPreOrder(node, res);
        return res;
    }

    private static void doPreOrder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.getData());
        doPreOrder(node.getLeft(), res);
        doPreOrder(node.getRight(), res);
    }

    /**
     * 中序遍历
     *
     * 左->根->右
     *
     * @param node
     * @return
     */
    public static List<Integer> inOrder(Node node) {
        List<Integer> res = new ArrayList<>();
        doInOrder(node, res);
        return res;
    }

    private static void doInOrder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        doInOrder(node.getLeft(), res);
        res.add(node.getData());
        doInOrder(node.getRight(), res);
    }

    /**
     * 后序遍历
     *
     * 左->右->根
     *
     * @param node
     * @return
     */
    public static List<Integer> postOrder(Node node) {
        List<Integer> res = new ArrayList<>();
        doPostOrder(node, res);
        return res;
    }

    private static void doPostOrder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        doPostOrder(node.getLeft(), res);
        doPostOrder(node.getRight(), res);
        res.add(node.getData());
    }

    /**
     * 层序遍历
     *
     * BFS求解
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                Node node = queue.poll();
                list.add(node.getData());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }

                count--;
            }
            res.add(list);
        }

        return res;
    }


    /**
     * 层序遍历
     *
     * DFS求解
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root, int level, List<List<Integer>> res) {
        if (root == null) {
            return res;
        }

        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }

        List<Integer> list = res.get(level);
        list.add(root.getData());

        levelOrder(root.getLeft(), level + 1, res);
        levelOrder(root.getRight(), level + 1, res);

        return res;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }

}
