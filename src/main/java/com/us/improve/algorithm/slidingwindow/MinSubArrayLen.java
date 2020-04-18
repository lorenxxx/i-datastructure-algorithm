package com.us.improve.algorithm.slidingwindow;

/**
 * @ClassName MinSubArrayLen
 * @Desciption 长度最小的子数组
 * @Author loren
 * @Date 2020/4/17 3:13 PM
 * @Version 1.0
 **/
public class MinSubArrayLen {

    /**
     * 问题描述
     *
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     */

    /**
     * 解题思路
     */

    public static int getMinSubArrayLen(int[] arr, int s) {
        // 边界判断省略

        int l = 0;
        int r = -1;
        int sum = 0;
        int result = arr.length + 1;
        while (l < arr.length) {
            if (r + 1 < arr.length && sum < s) {
                r++;
                sum += arr[r];
            } else {
                sum -= arr[l];
                l++;
            }

            if (sum >= s) {
                result = Math.min(r - l + 1, result);
            }
        }

        if (result == arr.length + 1) {
            return 0;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(getMinSubArrayLen(arr, s));
    }

}
