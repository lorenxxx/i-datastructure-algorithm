package com.us.improve.algorithm.sort.practice;

import com.us.improve.algorithm.sort.ISort;

/**
 * @ClassName SortPractice1
 * @Desciption 排序练习1
 * @Author loren
 * @Date 2020/3/12 3:17 PM
 * @Version 1.0
 **/
public class SortPractice1 implements ISort {

	@Override
	public void bubbleSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			// 一轮过程中是否发生元素交换标志位
			boolean flag = false;

			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;

					flag = true;
				}
			}

			// 如果一轮过程中没有发生元素交换，则提前退出
			if (!flag) {
				break;
			}
		}
	}

	@Override
	public void insertSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			// 待插入的数据
			int value = arr[i];

			int j = i - 1;
			while (j >= 0 && arr[j] > value) {
				// 移动元素
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = value;
		}
	}

	@Override
	public void shellSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		for (int step = arr.length / 2; step >= 1; step /= 2) {
			for (int i = step; i < arr.length; i++) {
				// 待插入的数据
				int value = arr[i];

				int j = i - step;
				while (j >= 0 && arr[j] > value) {
					// 移动元素
					arr[j + step] = arr[j];
					j -= step;
				}

				arr[j + step] = value;
			}
		}
	}

	@Override
	public void selectSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			int min = i;
			// 寻找未排序区间最小的元素
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			// 交换
			if (i != min) {
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
	}

	@Override
	public void mergeSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		int[] tmp = new int[arr.length];
		doMergeSort(arr, tmp, 0, arr.length - 1);
	}

	private void doMergeSort(int[] arr, int[] tmp, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = left + (right - left) / 2;

		int left1 = left;
		int right1 = mid;
		int left2 = mid + 1;
		int right2 = right;

		doMergeSort(arr, tmp, left1, right1);
		doMergeSort(arr, tmp, left2, right2);

		int k = left;
		while (left1 <= right1 && left2 <= right2) {
			tmp[k++] = arr[left1] < arr[left2] ? arr[left1++] : arr[left2++];
		}
		while (left1 <= right1) {
			tmp[k++] = arr[left1++];
		}
		while (left2 <= right2) {
			tmp[k++] = arr[left2++];
		}

		for (k = left; k <= right; k++) {
			arr[k] = tmp[k];
		}
	}

	@Override
	public void quickSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		doQuickSort(arr, 0, arr.length - 1);
	}

	public void doQuickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int i = left;
		int j = right;
		int pivot = arr[left + (right - left) / 2];

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i < j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;

				i++;
				j--;
			} else if (i == j) {
				i++;
			}
		}

		doQuickSort(arr, left, j);
		doQuickSort(arr, i, right);
	}

}
