package com.us.improve.leetcode.binarytree;

/**
 * @ClassName Height
 * @Desciption 求二叉树的高度
 * @Author loren
 * @Date 2020/4/8 4:17 PM
 * @Version 1.0
 **/
public class Height {

	/**
	 * 问题描述
	 *
	 * 求二叉树的高度
	 */

	/**
	 * 解题思路
	 *
	 * 对于树中任意一个节点，其高度 = Max（左子树的高度，右子树的高度）+ 1
	 */

	public static int getHeight(Node node) {
		if (node == null) {
			return 0;
		}

		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}

	public static void main(String[] args) {
		Node root = new Node(1, new Node(2, null, null), null);
		System.out.println(getHeight(root));
	}

}
