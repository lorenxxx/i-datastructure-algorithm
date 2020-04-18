package com.us.improve.algorithm.slidingwindow;

/**
 * @ClassName SlidingWindowMaxValue
 * @Desciption 滑动窗口最大值
 * @Author loren
 * @Date 2020/4/17 1:20 PM
 * @Version 1.0
 **/
public class SlidingWindowMaxValue {

    /**
     * 查找滑动窗口最大值
     *
     * @param arr 给定数组
     * @param k   窗口大小
     * @return
     */
    public static void findSlidingWindowMaxValue(int[] arr, int k) {
        // 边界判断
        if (arr == null || arr.length < k) {
            return;
        }

        if (k < 0) {
            return;
        }

        int left = 0;
        int right = k - 1;
        while (right < arr.length) {
            findMaxValue(arr, left, right);
            left++;
            right++;
        }
    }

    private static void findMaxValue(int[] arr, int left, int right) {
        int max = arr[left];

        int i = left + 1;
        while (i <= right) {
            if (arr[i] > max) {
                max = arr[i];
            }
            i++;
        }

        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        findSlidingWindowMaxValue(nums, k);
    }

}
