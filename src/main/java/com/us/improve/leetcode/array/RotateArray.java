package com.us.improve.leetcode.array;

import java.util.Arrays;

/**
 * @ClassName RotateArray
 * @Desciption 旋转数组
 * @Author loren
 * @Date 2020/4/23 1:45 AM
 * @Version 1.0
 **/
public class RotateArray {

    /**
     * 问题描述
     *
     * 给定一个数组和一个正整数k，旋转这个数组，使得数组中每个元素向后移动k位
     */

    /**
     * 解题思路
     *
     *
     */

    /**
     * 暴力法，每次移动1个位置，移动K轮
     *
     * @param arr
     * @param k
     */
    public static void rotateArray1(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        if (k <= 0 || k % arr.length == 0) {
            return;
        }

        // k可能大于数组长度，先取模
        k %= arr.length;

        // 每次移动1个位置，移动k轮
        for (int i = 0; i < k; i++) {
            int tmp = arr[arr.length - 1];
            for (int j = arr.length - 2; j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[0] = tmp;
        }
    }

    /**
     * 这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动
     *
     * @param arr
     * @param k
     */
    public static void rotateArray2(int[] arr, int k) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        if (k <= 0 || k % arr.length == 0) {
            return;
        }

        // k可能大于数组长度，先取模
        k = k % arr.length;

        // 整体数组镜像对调
        reverseArray(arr, 0, arr.length - 1);
        // 前k个元素镜像对调
        reverseArray(arr, 0, k - 1);
        // 剩余元素镜像对调
        reverseArray(arr, k, arr.length - 1);
    }

    private static void reverseArray(int[] arr, int begin, int end) {
        while (begin < end) {
            int tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;

            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 3;
        rotateArray2(arr, k);
        System.out.println(Arrays.toString(arr));
    }

}
