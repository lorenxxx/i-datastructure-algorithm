package com.us.improve.datastructure.heap;

/**
 * @Author loren
 * @Description 小顶堆
 * @Date 2021-07-21 00:22
 * @Version 1.0
 **/
public class MinHeap {

	private int[] arr;

	private int capacity;

	private int size;

	public MinHeap(int capacity) {
		this.arr = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	public void add(int data) {
		if (size < capacity) {
			arr[size] = data;
			heapifyUp(size);
			size++;
		} else {
			if (data > arr[0]) {
				arr[0] = data;
				heapifyDown(0, size - 1);
			}
		}
	}

	public void removeTop() {
		if (size == 0) {
			return;
		}

		arr[0] = arr[size - 1];
		size--;

		heapifyDown(0, size - 1);
	}

	/**
	 * 从下往上堆化
	 *
	 * @param begin 堆化起点
	 */
	private void heapifyUp(int begin) {
		for (int i = begin; getParentNodeIndex(i) >= 0 && arr[i] < arr[getParentNodeIndex(i)]; i = getParentNodeIndex(i)) {
			// swap
			int tmp = arr[i];
			arr[i] = arr[getParentNodeIndex(i)];
			arr[getParentNodeIndex(i)] = tmp;
		}
	}

	/**
	 * 从上往下堆化
	 *
	 * @param begin 堆化起点
	 * @param end   堆化终点
	 */
	private void heapifyDown(int begin, int end) {
		if (begin >= end) {
			return;
		}

		int i = begin;
		while (true) {
			int minValueIndex = i;
			int leftNodeIndex = getLeftNodeIndex(i);
			int rightNodeIndex = getRightNodeIndex(i);

			if (leftNodeIndex <= end && arr[minValueIndex] > arr[leftNodeIndex]) {
				minValueIndex = leftNodeIndex;
			}
			if (rightNodeIndex <= end && arr[minValueIndex] > arr[rightNodeIndex]) {
				minValueIndex = rightNodeIndex;
			}

			if (minValueIndex == i) {
				break;
			}

			// swap
			int tmp = arr[i];
			arr[i] = arr[minValueIndex];
			arr[minValueIndex] = tmp;

			i = minValueIndex;
		}
	}

	/**
	 * 展示
	 */
	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	/**
	 * 获取父节点在数组中的下标
	 *
	 * @param i 节点下标
	 * @return 父节点在数组中的下标
	 */
	private int getParentNodeIndex(int i) {
		return (i - 1) / 2;
	}

	/**
	 * 获取左子节点在数组中的下标
	 *
	 * @param i 节点下标
	 * @return 左子节点的数组下标
	 */
	private int getLeftNodeIndex(int i) {
		return i * 2 + 1;
	}

	/**
	 * 获取右子节点在数组中的下标
	 *
	 * @param i 节点下标
	 * @return 左子节点的数组下标
	 */
	private int getRightNodeIndex(int i) {
		return i * 2 + 2;
	}

	public static void main(String[] args) {
		MinHeap heap = new MinHeap(5);

		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int item : arr) {
			heap.add(item);
		}

		heap.display();

		heap.removeTop();

		heap.display();
	}

}
