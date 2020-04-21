package com.us.improve.algorithm.sort.practice;

import com.us.improve.algorithm.sort.ISort;

import java.util.Arrays;

/**
 * @ClassName SortPractice3Test
 * @Desciption 排序练习3
 * @Author loren
 * @Date 2020/4/19 3:37 PM
 * @Version 1.0
 **/
public class SortPractice3Test {

    public static void main(String[] args) {
        ISort sort = new SortPractice3();

        int[] arr1 = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.insertSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.shellSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.selectSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.mergeSort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {50, 34, 90, 23, 54, 77, 10};
        sort.quickSort(arr6);
        System.out.println(Arrays.toString(arr6));
    }

}
