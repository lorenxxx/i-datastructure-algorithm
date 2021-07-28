package com.us.improve.datastructure.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-21 01:52
 * @Version 1.0
 **/
public class JdkHeap {

	public static void main(String[] args) {
		int capacity = 10;

		// Java的PriorityQueue默认是小顶堆
		Queue<Integer> minHeap = new PriorityQueue<>(capacity);

		// Java的PriorityQueue默认是小顶堆，添加comparator参数使其变成大顶堆
		Queue<Integer> maxHeap = new PriorityQueue<>(capacity, (i, j) -> Integer.compare(j, i));
	}

}
