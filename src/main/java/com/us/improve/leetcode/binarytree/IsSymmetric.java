package com.us.improve.leetcode.binarytree;

/**
 * @ClassName IsSymmetric
 * @Desciption 对称二叉树：给定一个二叉树，检查它是否是镜像对称的。
 * @Author loren
 * @Date 2020/4/9 3:00 PM
 * @Version 1.0
 **/
public class IsSymmetric {

    public boolean solve(Node root) {
        if (root == null) {
            return true;
        }

        return isSym(root.getLeft(), root.getRight());
    }

    public boolean isSym(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        return n1.getData() == n2.getData() && isSym(n1.getLeft(), n2.getRight()) && isSym(n1.getRight(), n2.getLeft());
    }

}
