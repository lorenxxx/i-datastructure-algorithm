package com.us.improve.leetcode.topk;

import java.util.Arrays;

/**
 * @ClassName TopMinK2
 * @Desciption 查找一个组数中最小的k个数
 * @Author loren
 * @Date 2020/4/16 5:49 PM
 * @Version 1.0
 **/
public class TopMinK2 {

    /**
     * 问题描述
     *
     * 查找一个组数中最小的k个数
     */

    /**
     * 解题思路
     *
     * 基于快速排序的思想做修改
     */

    public static Integer[] getTopMinK(Integer[] arr, int k) {
        // 边界判断省略...

        partitionArr(arr, 0, arr.length - 1, k);

        Integer[] ret = new Integer[k];
        System.arraycopy(arr, 0, ret, 0, k);
        return ret;
    }

    private static void partitionArr(Integer[] arr, int low, int high, int k) {
        int m = partition(arr, low, high);
        if (m == k) {
            return;
        } else if (m > k) {
            partitionArr(arr, low, m - 1, k);
        } else {
            partitionArr(arr, m + 1, high, k);
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
        int i = low;
        int j = high;

        int v = arr[low];

        while (true) {
            while (arr[++i] < v) {
                if (i == high) {
                    break;
                }
            }
            while (arr[j--] > v) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
        }

        swap(arr, low, j);
        return j;
    }

    private static void swap(Integer[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 5, 3, 7, 10, 21, 5, 10};
        int k = 5;
        System.out.println(Arrays.toString(getTopMinK(arr, k)));
    }

}
