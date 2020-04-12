package com.us.improve.leetcode.binarytree;

/**
 * @ClassName IsBalance
 * @Desciption 判断是否为平衡二叉树
 * @Author loren
 * @Date 2020/4/9 2:52 PM
 * @Version 1.0
 **/
public class IsBalance {

    public boolean isBalance(Node root) {
        boolean balance = true;
        getDepth(root, balance);
        return balance;
    }

    private int getDepth(Node root, boolean balance) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.getLeft(), balance);
        int right = getDepth(root.getRight(), balance);
        if (Math.abs(left - right) > 1) {
            balance = false;
        }

        return Math.max(left, right) + 1;
    }

}
