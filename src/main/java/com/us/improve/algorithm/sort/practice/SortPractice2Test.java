package com.us.improve.algorithm.sort.practice;

import com.us.improve.algorithm.sort.ISort;

import java.util.Arrays;

/**
 * @ClassName SortPractice2Test
 * @Desciption 排序练习2测试
 * @Author loren
 * @Date 2020/4/3 3:51 PM
 * @Version 1.0
 **/
public class SortPractice2Test {

    public static void main(String[] args) {
        ISort sort = new SortPractice2();

        int[] arr1 = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.insertSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.insertSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.selectSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.mergeSort(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        sort.quickSort(arr6);
        System.out.println(Arrays.toString(arr6));
    }

}
