package com.us.improve.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum
 * @Desciption 两数之和
 * @Author loren
 * @Date 2020/4/8 2:55 PM
 * @Version 1.0
 **/
public class TwoSum {

    /**
     * 问题描述
     *
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标
     *
     */

    /**
     * 解题思路
     *
     *
     */

    public static int[] findTwoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (map.containsKey(expect)) {
                return new int[] {map.get(expect), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    /**
     * 练习
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] findTwoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (map.containsKey(expect)) {
                return new int[] {map.get(expect), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 18;

        int[] result = findTwoSum(nums, target);
        System.out.println(Arrays.toString(result));

        int[] result1 = findTwoSum2(nums, target);
        System.out.println(Arrays.toString(result));
    }

}
