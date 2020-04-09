package com.us.improve.leetcode.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName IntersectionOfTwoArrays
 * @Desciption 两个数组的交集：给定两个数组，编写一个函数来计算它们的交集。
 * @Author loren
 * @Date 2020/4/9 5:28 PM
 * @Version 1.0
 **/
public class IntersectionOfTwoArrays {

    public static List<Integer> solve(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();

        if (nums1 == null || nums1.length == 0) {
            return new ArrayList<>();
        }

        if (nums2 == null || nums2.length == 0) {
            return new ArrayList<>();
        }

        Set<Integer> set = new HashSet<>(nums1.length);
        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3};
        int[] nums2 = new int[] {1, 2, 2, 6};
        System.out.println(solve(nums1, nums2));
    }

}
