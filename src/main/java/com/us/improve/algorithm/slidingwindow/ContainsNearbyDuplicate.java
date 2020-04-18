package com.us.improve.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ContainsNearbyDuplicate
 * @Desciption 存在距离k以内的重复元素
 * @Author loren
 * @Date 2020/4/17 2:50 PM
 * @Version 1.0
 **/
public class ContainsNearbyDuplicate {

    /**
     * 问题描述
     *
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     */

    /**
     * 解题思路
     */

    public static boolean containsNearbyDuplicate(int[] arr, int k) {
        // 边界判断省略

        int left = 0;
        int right = 1;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }

            set.add(arr[i]);
            if (set.size() > k + 1) {
                set.remove(arr[i - k -1]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 2, 2, 3};
        int k1 = 2;
        System.out.println(containsNearbyDuplicate(nums1, k1));
    }

}
