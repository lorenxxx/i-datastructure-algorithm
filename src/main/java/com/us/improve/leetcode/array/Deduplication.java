package com.us.improve.leetcode.array;

import java.util.*;

/**
 * @ClassName Deduplication
 * @Desciption 数组去重
 * @Author loren
 * @Date 2020/4/23 10:28 PM
 * @Version 1.0
 **/
public class Deduplication {

    /**
     * 问题描述
     *
     * 给定一个数组，里面包含重复元素，找出重复的元素，并去重
     */

    /**
     * 解题思路
     */


    public static List<Integer> deduplicate1(int[] arr) {
        Set<Integer> ret = new HashSet<>();

        if (arr == null || arr.length <= 1) {
            return new ArrayList<>(ret);
        }

        Set<Integer> tmpSet = new HashSet<>();
        for (int item : arr) {
            if (tmpSet.contains(item)) {
                ret.add(item);
            } else {
                tmpSet.add(item);
            }
        }

        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 5, 5};
        System.out.println(deduplicate1(arr));

        List<Integer> list = new LinkedList<>();
        list.add(9);
        list.add(2);
        list.add(3);

        for (Integer item : list) {
            System.out.println(item);
        }
    }

}
