package com.us.improve.leetcode.binarytree;

/**
 * @ClassName IsSymmetric
 * @Desciption 对称二叉树：给定一个二叉树，检查它是否是镜像对称的。
 * @Author loren
 * @Date 2020/4/9 3:00 PM
 * @Version 1.0
 **/
public class IsSymmetric {

	/**
	 * 问题描述
	 *
	 * 给定一个二叉树，检查它是否是镜像对称的。
	 */

	/**
	 * 解题思路
	 * <p>
	 * 如果一棵树的左子树和右子树镜像对称的话，那么这棵树一定是镜像对称的
	 */

	public boolean isSym(Node node) {
		if (node == null) {
			return true;
		}

		return isSym(node.getLeft(), node.getRight());
	}

	private boolean isSym(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return node1.getData() == node2.getData()
				&& isSym(node1.getLeft(), node2.getRight())
				&& isSym(node1.getRight(), node2.getLeft());
	}

}
