package com.us.improve.leetcode.topk;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName TopMinK
 * @Desciption 查找一个组数中最小的k个数
 * @Author loren
 * @Date 2020/4/16 4:31 PM
 * @Version 1.0
 **/
public class TopMinK {

    /**
     * 问题描述
     *
     * 查找一个组数中最小的k个数
     */

    /**
     * 解题思路
     *
     * 使用堆
     * 维护一个容量为k的大顶堆
     * 遍历剩余数据，如果数据比堆顶元素大，不做任何操作；如果数据比堆顶元素小，则用该数据替换堆顶元素，重新堆化
     */

    public static Integer[] getTopMinK(Integer[] arr, int k) {
        // 边界判断省略...

        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i, j) -> Integer.compare(j, i));

        for (int item : arr) {
            if (heap.isEmpty() || heap.size() < k || item < heap.peek()) {
                heap.offer(item);
            }
        }

        Integer[] ret = heap.toArray(new Integer[heap.size()]);
        return ret;
    }

    /**
     * 练习
     *
     * @param arr
     * @param k
     * @return
     */
    public static Integer[] getTopMinK2(Integer[] arr, int k) {
        if (arr == null || arr.length <= k) {
            return arr;
        }

        // Java的PriorityQueue默认是小顶堆，添加comparator参数使其变成大顶堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i, j) -> Integer.compare(j, i));

        for (int item : arr) {
            if (heap.isEmpty() || heap.size() < k || item < heap.peek()) {
                heap.offer(item);
            }
        }

        Integer[] ret = heap.toArray(new Integer[heap.size()]);
        return ret;
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 2, 5, 3, 7, 10, 21, 5, 12};
        int k = 5;
        System.out.println(Arrays.toString(getTopMinK(arr, k)));
        System.out.println(Arrays.toString(getTopMinK2(arr, k)));
    }


}
