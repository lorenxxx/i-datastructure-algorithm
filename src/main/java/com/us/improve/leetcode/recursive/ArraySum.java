package com.us.improve.leetcode.recursive;

/**
 * @ClassName ArraySum
 * @Desciption 使用递归的方式对数组求和
 * @Author loren
 * @Date 2020/4/13 3:14 PM
 * @Version 1.0
 **/
public class ArraySum {

    public static int calSum(int[] arr, int begin) {
        if (begin == arr.length) {
            return 0;
        }

        return arr[begin] + calSum(arr, begin + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 7, 9};
        int result = calSum(arr, 0);
        System.out.println(result);
    }

}
