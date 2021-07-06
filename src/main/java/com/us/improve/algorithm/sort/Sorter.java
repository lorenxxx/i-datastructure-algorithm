package com.us.improve.algorithm.sort;

/**
 * @ClassName Sorter
 * @Desciption 排序器
 * @Author loren
 * @Date 2020/3/12 3:15 PM
 * @Version 1.0
 **/
public class Sorter implements ISort {

	@Override
	public void bubbleSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			// 提前退出冒泡循环的标志位
			boolean flag = false;

			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// 交换
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					// 表示有数据交换
					flag = true;
				}
			}

			// 如果没有数据交换，则提前退出冒泡循环
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
			int value = arr[i];

			int j = i - 1;
			// 寻找合适的插入位置
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

		int[] result = new int[arr.length];
		doMergeSort(arr, result, 0, arr.length - 1);
	}

	private void doMergeSort(int[] arr, int[] result, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = left + (right - left) / 2;

		int left1 = left;
		int right1 = mid;
		int left2 = mid + 1;
		int right2 = right;

		doMergeSort(arr, result, left1, right1);
		doMergeSort(arr, result, left2, right2);

		int k = left;
		while (left1 <= right1 && left2 <= right2) {
			result[k++] = arr[left1] < arr[left2] ? arr[left1++] : arr[left2++];
		}
		while (left1 <= right1) {
			result[k++] = arr[left1++];
		}
		while (left2 <= right2) {
			result[k++] = arr[left2++];
		}

		for (k = left; k <= right; k++) {
			arr[k] = result[k];
		}
	}

	@Override
	public void quickSort(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}

		doQuickSort(arr, 0, arr.length - 1);
	}

	private void doQuickSort(int[] arr, int left, int right) {
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
