package com.us.improve.leetcode.array;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-19 22:10
 * @Version 1.0
 **/
public class TwoDimenArrayIterator {

	private int[][] data;

	private int row;

	private int column;

	public TwoDimenArrayIterator(int[][] data) {
		this.data = data;
		this.row = 0;
		this.column = 0;
	}

	public boolean hasNext() {
		return row < data.length && column < data[row].length;
	}

	public int next() {
		int value = data[row][column];

		column++;
		if (column == data[row].length) {
			row++;
			column = 0;
		}

		// 跳过空行
		while (row < data.length && data[row].length == 0) {
			row++;
		}

		return value;
	}

	public static void main(String[] args) {
		int[][] data = { { 1, 2, 3 }, { 4, 5 }, {}, {}, { 6, 7 }, {} };

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		TwoDimenArrayIterator iterator = new TwoDimenArrayIterator(data);
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		//System.out.println(data[1][0]);
	}

}
