package com.us.improve.datastructure.tree;

/**
 * @ClassName BinarySearchTree
 * @Desciption 二叉查找树
 * @Author loren
 * @Date 2020/3/22 3:10 PM
 * @Version 1.0
 **/
public class BinarySearchTree {

    private Node root;

    /**
     * 查找
     *
     * @param data 待查找数据
     * @return 节点，未找到则返回null
     */
    public Node find(int data) {
        Node node = root;
        while (node != null) {
            if (data < node.getData()) {
                node = node.getLeft();
            } else if (data > node.getData()) {
                node = node.getRight();
            } else {
                return node;
            }
        }

        return null;
    }

    /**
     * 插入
     *
     * 注：目前只能适用于没有相等数据的情况
     *
     * @param data 待插入数据
     */
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        }

        Node node = root;
        while (node != null) {
            if (data < node.getData()) {
                if (node.getLeft() == null) {
                    node.setLeft(new Node(data));
                    return;
                } else {
                    node = node.getLeft();
                }
            } else if (data > node.getData()) {
                if (node.getRight() == null) {
                    node.setRight(new Node(data));
                    return;
                } else {
                    node = node.getRight();
                }
            } else {
                return;
            }
        }
    }

    /**
     * 删除
     *
     * @param data 待删除数据
     */
    public void delete(int data) {
        Node node = root;
        Node parent = null;

        while (node != null && node.getData() != data) {
            if (data < node.getData()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
            parent = node;
        }

        if (node == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (node.getLeft() != null && node.getRight() != null) {
            Node minNode = node.getRight();
            Node minNodeParent = parent;
            while (minNode.getLeft() != null) {
                minNodeParent = minNode;
                minNode = minNode.getLeft();
            }
            node.setData(minNodeParent.getData());
            node = minNode;
            parent = minNodeParent;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child;
        if (parent.getLeft() != null) {
            child = parent.getLeft();
        } else if (parent.getRight() != null) {
            child = parent.getRight();
        } else {
            child = null;
        }

        if (parent == null) {
            root = child;
        } else if (parent.getLeft() == node) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

}
