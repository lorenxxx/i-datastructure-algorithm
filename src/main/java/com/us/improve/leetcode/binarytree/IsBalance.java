package com.us.improve.leetcode.binarytree;

/**
 * @ClassName IsBalance
 * @Desciption 判断是否为平衡二叉树
 * @Author loren
 * @Date 2020/4/9 2:52 PM
 * @Version 1.0
 **/
public class IsBalance {

	/**
	 * 问题描述
	 *
	 * 判断一棵二叉树是否为平衡二叉树
	 * (所谓平衡二叉树，就是左子树和右子树的高度差不能超过1，且左右子树必须是平衡二叉树；)
	 */

	/**
	 * 解题思路
	 * <p>
	 * 对于树中任意一个节点，求其左右子树的高度并做比较，如果任意一个节点的左右子树高度度相差超过1，则不平衡
	 */

	public boolean isBalance(Node node) {
		if (node == null) {
			return true;
		}

		boolean balance = true;
		getHeight(node, balance);
		return balance;
	}

	private int getHeight(Node node, boolean balance) {
		if (node == null) {
			return 0;
		}

		int left = getHeight(node.getLeft(), balance);
		int right = getHeight(node.getRight(), balance);
		if (Math.abs(left - right) > 1) {
			balance = false;
		}

		return Math.max(left, right) + 1;
	}

}
