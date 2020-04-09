package com.us.improve.leetcode.binarytree;

/**
 * @ClassName IsBalance
 * @Desciption 判断是否为平衡二叉树
 * @Author loren
 * @Date 2020/4/9 2:52 PM
 * @Version 1.0
 **/
public class IsBalanced {

    public boolean solve(Node root) {
        boolean isBalanced = true;
        getDepth(root, isBalanced);
        return isBalanced;
    }

    private int getDepth(Node root, boolean isBalanced) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.getLeft(), isBalanced);
        int right = getDepth(root.getRight(), isBalanced);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return Math.max(left, right) + 1;
    }

}
