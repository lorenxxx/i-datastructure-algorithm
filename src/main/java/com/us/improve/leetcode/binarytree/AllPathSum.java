package com.us.improve.leetcode.binarytree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-22 15:14
 * @Version 1.0
 **/
public class AllPathSum {

	/**
	 * 问题描述
	 * <p>
	 * 给定一个仅包含数字0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
	 * 例如根节点到叶子节点的一条路径是1→2→3,那么这条路径就用123 来代替。
	 * 找出根节点到叶子节点的所有路径表示的数字之和
	 */

	private Stack<Integer> path = new Stack<>();

	private Set<Integer> visited = new HashSet<>();

	private int sum = 0;

	public int getAllPathSum(Node root) {
		if (root == null) {
			return 0;
		}

		path.push(root.data);
		visited.add(root.data);

		dfs(root);

		return sum;
	}

	private void dfs(Node node) {
		Node left = node.left;
		Node right = node.right;

		if (left == null && right == null) {
			sum += getPathSum(path);
			return;
		}

		if (left != null && !visited.contains(left.data)) {
			path.push(left.data);
			visited.add(left.data);

			dfs(left);

			path.pop();
		}

		if (right != null && !visited.contains(right.data)) {

			path.push(right.data);
			visited.add(right.data);

			dfs(right);

			path.pop();
		}
	}

	private int getPathSum(Stack<Integer> path) {
		if (path == null) {
			return 0;
		}

		Integer[] arr = path.toArray(new Integer[path.size()]);
		String str = "";
		for (Integer item : arr) {
			str += item;
		}

		return Integer.parseInt(str);
	}

	public static void main(String[] args) {
		Node root = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3));
		//Node root = new Node(1, new Node(2), new Node(3));

		AllPathSum allPathSum = new AllPathSum();
		int sum = allPathSum.getAllPathSum(root);

		System.out.println(sum);
	}

}
