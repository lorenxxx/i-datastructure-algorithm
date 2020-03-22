package com.us.improve.datastructure.tree;

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

}
