package com.us.improve.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName BinaryTree
 * @Desciption 二叉树
 * @Author loren
 * @Date 2020/3/22 2:10 PM
 * @Version 1.0
 **/
public class BinaryTree {

    private Node root;

    /**
     * 前序遍历
     *
     * 递归实现
     *
     * 顺序：节点本身 -> 左子树 -> 右子树
     * 递推公式：preOrder(node) = print(node) -> preOrder(node.left) -> preOrder(node.right)
     *
     * 时间复杂度：O(n)
     *
     * @param node
     */
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 前序遍历
     *
     * 非递归实现
     *
     * 顺序：节点本身 -> 左子树 -> 右子树
     * 递推公式：preOrder(node) = print(node) -> preOrder(node.left) -> preOrder(node.right)
     *
     * 时间复杂度：O(n)
     *
     * @param node
     */
    public void preOrder2(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        if (!stack.isEmpty()) {
            Node tmp = stack.pop();

            System.out.println(tmp.getData());

            if (tmp.getRight() != null) {
                stack.push(tmp.getRight());
            }

            if (tmp.getLeft() != null) {
                stack.push(tmp.getLeft());
            }
        }
    }

    /**
     * 中序遍历
     *
     * 顺序：左子树 -> 节点本身 -> 右子树
     * 递推公式：inOrder(node) = inOrder(node.left) -> print(node) -> inOrder(node.right)
     *
     * 时间复杂度：O(n)
     *
     * @param node
     */
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node.getData());
        inOrder(node.getRight());
    }

    /**
     * 后序遍历
     *
     * 顺序：左子树 -> 右子树 -> 节点本身
     * 递推公式：postOrder(node) = postOrder(node.left) -> postOrder(node.right) -> print(nodes)
     *
     * 时间复杂度：O(n)
     *
     * @param node
     */
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getData());
    }

    /**
     * 层序遍历
     *
     * BFS
     *
     * @param node
     */
    public void levelOrder1(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            System.out.println(tmp.getData());

            if (tmp.getLeft() != null) {
                queue.add(tmp.getLeft());
            }

            if (tmp.getRight() != null) {
                queue.add(tmp.getRight());
            }
        }
    }

}
