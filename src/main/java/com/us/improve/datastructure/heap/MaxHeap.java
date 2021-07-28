package com.us.improve.datastructure.heap;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-21 01:23
 * @Version 1.0
 **/
public class MaxHeap {

	private int[] arr;

	private int capacity;

	private int size;

	public MaxHeap(int capacity) {
		this.arr = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	public void add(int data) {
		if (size < capacity) {
			arr[size] = data;
			shiftUp(size);
			size++;
		} else {
			if (data < arr[0]) {
				arr[0] = data;
				shiftDown(0, size - 1);
			}
		}
	}

	public void removeTop() {
		if (size == 0) {
			return;
		}

		arr[0] = arr[size - 1];
		size--;

		shiftDown(0, size - 1);
	}

	private void shiftUp(int begin) {
		for (int i = begin; getParentNodeIndex(i) >= 0 && arr[getParentNodeIndex(i)] < arr[i]; i = getParentNodeIndex(i)) {
			// swap
			int tmp = arr[getParentNodeIndex(i)];
			arr[getParentNodeIndex(i)] = arr[i];
			arr[i] = tmp;
		}
	}

	private void shiftDown(int begin, int end) {
		if (begin >= end) {
			return;
		}

		int i = begin;
		while (true) {
			int maxValueIndex = i;
			int leftNodeIndex = getLeftNodeIndex(i);
			int rightNodeIndex = getRightNodeIndex(i);

			if (leftNodeIndex <= end && arr[maxValueIndex] < arr[leftNodeIndex]) {
				maxValueIndex = leftNodeIndex;
			}
			if (rightNodeIndex <= end && arr[maxValueIndex] < arr[rightNodeIndex]) {
				maxValueIndex = rightNodeIndex;
			}

			if (maxValueIndex == i) {
				break;
			}

			// swap
			int tmp = arr[maxValueIndex];
			arr[maxValueIndex] = arr[i];
			arr[i] = tmp;

			i = maxValueIndex;
		}
	}

	public void display() {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	private int getParentNodeIndex(int i) {
		return (i - 1) / 2;
	}

	private int getLeftNodeIndex(int i) {
		return i * 2 + 1;
	}

	private int getRightNodeIndex(int i) {
		return i * 2 + 2;
	}

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(5);

		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int item : arr) {
			heap.add(item);
		}

		heap.display();

		heap.removeTop();

		heap.display();
	}

}
