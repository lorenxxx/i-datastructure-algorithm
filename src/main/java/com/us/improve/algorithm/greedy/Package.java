package com.us.improve.algorithm.greedy;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-16 20:44
 * @Version 1.0
 **/
public class Package {

	/**
	 * 问题描述
	 *
	 * 一般背包问题，物品可分割
	 */

	/**
	 * 解题思路
	 *
	 */

	public static void doPackage(List<Goods> goodsList, int bagMaxWeight) {
		if (goodsList == null || goodsList.size() == 0) {
			return;
		}

		if (bagMaxWeight <= 0) {
			return;
		}

		Collections.sort(goodsList, (g1, g2) -> g2.value / g2.weight - g1.value / g1.weight);
		//System.out.println(goodsList);

		int[] goodsValue = new int[goodsList.size()];
		int[] goodsWeight = new int[goodsList.size()];
		for (int i = 0; i < goodsList.size(); i++) {
			goodsValue[i] = goodsList.get(i).value;
			goodsWeight[i] = goodsList.get(i).weight;
		}

		System.out.println("物品价值数组: " + Arrays.toString(goodsValue));
		System.out.println("物品重量数组: " + Arrays.toString(goodsWeight));


		int totalValue = 0;
		int[] ret = new int[goodsList.size()];

		int tmpWeight = 0;
		for (int i = 0; i < goodsWeight.length && tmpWeight < bagMaxWeight; i++) {
			if (tmpWeight + goodsWeight[i] <= bagMaxWeight) {
				tmpWeight += goodsWeight[i];

				totalValue += goodsValue[i];
				ret[i] = goodsWeight[i];
			} else {
				int splitWeight = bagMaxWeight - tmpWeight;
				totalValue += splitWeight * (goodsValue[i] / goodsWeight[i]);
				ret[i] = splitWeight;
				break;
			}
		}

		System.out.println("最大价值: " + totalValue);
		System.out.println("装法: " + Arrays.toString(ret));
	}

	public static void main(String[] args) {
		List<Goods> goodsList = new ArrayList<>();
		goodsList.add(new Goods(100, 100));
		goodsList.add(new Goods(90, 30));
		goodsList.add(new Goods(120, 60));
		goodsList.add(new Goods(80, 20));
		goodsList.add(new Goods(75, 15));

		Package.doPackage(goodsList, 150);
	}

	@Data
	static class Goods {

		private int value;

		private int weight;

		public Goods(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}

	}

}
