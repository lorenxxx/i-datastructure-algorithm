package com.us.improve.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-21 02:03
 * @Version 1.0
 **/
public class Package01 {

	/**
	 *
	 * @param n 物品数量
	 * @param pW 背包重量
	 * @param g 每个物品的价值
	 * @param w 每个物品的重量
	 */
	private static int getMaxValue(int n, int pW, int[] g, int[] w) {
		int[] preResult = new int[pW + 1];
		int[] result = new int[pW + 1];

		// 考察第0个物品，逐渐增加背包的容量, 所能获得的最大价值
		for (int i = 0; i <= pW; i++) {
			if (i < w[0]) {
				preResult[i] = 0;
			} else {
				preResult[i] = g[0];
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= pW; j++) {
				if (j < w[i]) {
					result[j] = preResult[j];
				} else {
					result[j] = Math.max(preResult[j], preResult[j - w[i]] + g[i]);
				}
			}

			for (int k = 0; k < result.length; k++) {
				preResult[k] = result[k];
			}
		}

		System.out.println(Arrays.toString(result));
		return result[pW];
	}

	public static void main(String[] args) {
		int[] g = {400, 500, 200, 300, 350};
		int[] w = {5, 5, 3, 4, 3};
		int n = 5;
		int pW = 10;
		System.out.println(getMaxValue(n, pW, g, w));
	}

}
