package com.us.improve.algorithm.sort.practice;

import com.us.improve.algorithm.sort.ISort;

import java.util.Arrays;

/**
 * @ClassName SortPractice6Test
 * @Desciption 排序练习5测试
 * @Author loren
 * @Date 2020/5/7 10:12 AM
 * @Version 1.0
 **/
public class SortPractice5Test {

    public static void main(String[] args) {
        ISort sort = new SortPractice5();

        int[] arr1 = {10, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.insertSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {10, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.shellSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {10, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.selectSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {10, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.mergeSort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {10, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.quickSort(arr6);
        System.out.println(Arrays.toString(arr6));
    }

}
