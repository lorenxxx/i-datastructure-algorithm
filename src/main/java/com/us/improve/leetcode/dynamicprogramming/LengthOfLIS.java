package com.us.improve.leetcode.dynamicprogramming;

/**
 * @ClassName LengthOfLIS
 * @Desciption LeetCode 300: 最长上升子序列
 * @Author loren
 * @Date 2020/6/12 4:08 PM
 * @Version 1.0
 **/
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 1) {
            return nums.length;
        }

        int max = 1;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                left = i;
            }

            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int max = lengthOfLIS(nums);
        System.out.println(max);
    }

}
