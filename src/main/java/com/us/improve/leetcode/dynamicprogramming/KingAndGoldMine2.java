package com.us.improve.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-19 20:03
 * @Version 1.0
 **/
public class KingAndGoldMine2 {

	/**
	 *
	 *
	 * @param n 金矿数量
	 * @param w 投入工人数
	 * @param g 每座金矿的金子数
	 * @param p 每座金矿需要的工人数
	 * @return
	 */
	public static int getMaxGold(int n, int w, int[] g, int[] p) {
		// 前i - 1座矿, 投入[0 ~ w]个工人所能产出的最大金币数量
		int[] preResult = new int[w + 1];
		// 前i座矿, 投入[0 ~ w]个工人所能产出的最大金币数量
		int[] result = new int[w + 1];

		// 设置边界，第0座矿，投入[0 ~ w]个工人所能产出的最大金币数量
		for (int i = 0; i <= w; i++) {
			if (i < p[0]) {
				preResult[i] = 0;
			} else {
				preResult[i] = g[0];
			}
		}

		// 用preResult推出result，外循环控制递推的轮数，内循环进行递推
		// 这里的i指的金矿数组g的下标，逐个把每一个金矿都纳入考虑范围
		for (int i = 1; i < n; i++) {
			// 这里的j指的是工人的数量
			for (int j = 0; j <= w; j++) {
				if (j < p[i]) {
					result[j] = preResult[j];
				} else {
					result[j] = Math.max(preResult[j], preResult[j - p[i]] + g[i]);
				}
			}

			for (int k = 0; k < result.length; k++) {
				preResult[k] = result[k];
			}
		}

		System.out.println(Arrays.toString(result));
		return result[w];
	}

	public static void main(String[] args) {
		int[] g = {400, 500, 200, 300, 350};
		int[] p = {5, 5, 3, 4, 3};
		System.out.println(getMaxGold(5, 10, g, p));
	}

}
