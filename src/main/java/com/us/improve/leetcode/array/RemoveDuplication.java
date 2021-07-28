package com.us.improve.leetcode.array;

import java.util.Arrays;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-20 18:49
 * @Version 1.0
 **/
public class RemoveDuplication {

	/**
	 * 问题描述
	 *
	 * 给定一个数组，里面包含重复元素，去除重复元素形成新数组，返回新数组长度。不额外分配数组空间。
	 *
	 */

	/**
	 * 解题思路
	 *
	 * 双指针，一快一慢
	 */

	public static int removeDuplication(int[] arr) {
		if (arr == null) {
			return 0;
		}

		if (arr.length <= 1) {
			return arr.length;
		}

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		int slow = 0;
		int fast = 1;
		while (fast < arr.length) {
			if (arr[slow] != arr[fast] && ++slow < fast) {
				arr[slow] = arr[fast];
			}

			fast++;
		}

		return slow + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 6, 5, 5, 7 };
		System.out.println(Arrays.toString(arr));

		int ret = removeDuplication(arr);
		System.out.println(ret);
		System.out.println(Arrays.toString(arr));
	}

}
