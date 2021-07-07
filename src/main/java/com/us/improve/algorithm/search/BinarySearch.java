package com.us.improve.algorithm.search;

/**
 * @ClassName BinarySearch
 * @Desciption 二分查找
 * @Author loren
 * @Date 2020/3/16 4:20 PM
 * @Version 1.0
 **/
public class BinarySearch {

	/**
	 * 简单二分查找：有序数组中不存在重复元素，查找值等于给定值的元素下标
	 * <p>
	 * 非递归实现
	 *
	 * @param arr   待查找数组
	 * @param value 待查找值
	 * @return 元素下标，如果不存在则返回-1
	 */
	public int bSearch1(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == value) {
				return mid;
			} else if (arr[mid] < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	/**
	 * 简单二分查找：有序数组中不存在重复元素，查找值等于给定值的元素下标
	 * <p>
	 * 递归实现
	 *
	 * @param arr   待查找数组
	 * @param value 待查找值
	 * @return 元素下标，如果不存在则返回-1
	 */
	public int bSearch2(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		return doBSearch2(arr, 0, arr.length - 1, value);
	}

	private int doBSearch2(int[] arr, int left, int right, int value) {
		if (left > right) {
			return -1;
		}

		int mid = left + (right - left) / 2;
		if (arr[mid] == value) {
			return mid;
		} else if (arr[mid] < value) {
			return doBSearch2(arr, mid + 1, right, value);
		} else {
			return doBSearch2(arr, left, mid - 1, value);
		}
	}

	/**
	 * 二分查找变体：有序数组中存在重复元素，查找第一个值等于给定值的元素下标
	 *
	 * @param arr   待查找数组
	 * @param value 待查找值
	 * @return 元素下标，如果不存在则返回-1
	 */
	public int bSearch3(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == value) {
				if (mid == 0 || arr[mid - 1] != value) {
					return mid;
				} else {
					right = mid - 1;
				}
			} else if (arr[mid] < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	/**
	 * 二分查找变体：有序数组中存在重复元素，查找最后一个值等于给定值的元素
	 *
	 * @param arr   待查找数组
	 * @param value 待查找值
	 * @return 元素下标，如果不存在则返回-1
	 */
	public int bSearch4(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == value) {
				if (mid == arr.length - 1 || arr[mid + 1] != value) {
					return mid;
				} else {
					left = mid + 1;
				}
			} else if (arr[mid] < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

	/**
	 * 二分查找变体：有序数组中存在重复元素，查找第一个大于等于给定值的元素
	 *
	 * @param arr   待查找数组
	 * @param value 待查找值
	 * @return 元素下标，如果不存在则返回-1
	 */
	public int bSearch5(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] >= value) {
				if (mid == 0 || arr[mid - 1] < value) {
					return mid;
				} else {
					right = mid - 1;
				}
			} else {
				left = mid + 1;
			}
		}

		return -1;
	}

	/**
	 * 二分查找变体：有序数组中存在重复元素，查找最后一个小于等于给定值的元素
	 *
	 * @param arr   待查找数组
	 * @param value 待查找值
	 * @return 元素下标，如果不存在则返回-1
	 */
	public int bSearch6(int[] arr, int value) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] <= value) {
				if (mid == arr.length - 1 || arr[mid + 1] > value) {
					return mid;
				} else {
					left = mid + 1;
				}
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

}
