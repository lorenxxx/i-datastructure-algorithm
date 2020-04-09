package com.us.improve.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ThreeSum
 * @Desciption 三数之和：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * @Author loren
 * @Date 2020/4/8 3:53 PM
 * @Version 1.0
 **/
public class ThreeSum {

    public static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 当第i个数开始大于零时，跳出循环
            if (nums[i] > 0) {
                break;
            }
            // 当相邻数相等时，跳过该数，避免重复结果
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 使用两个指针，向中间移动
            int left = i + 1;
            int right = nums.length - 1;
            int expectSum = -nums[i];
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum == expectSum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (twoSum < expectSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2, -1, -1, 0, 1, 2, 4};
        System.out.println(solve(nums));
    }

}
