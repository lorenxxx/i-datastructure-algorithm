package com.us.improve.algorithm.sort.practice;

import com.us.improve.algorithm.sort.ISort;

import java.util.Arrays;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-02-22 18:50
 * @Version 1.0
 **/
public class SortPractice6Test
{

	public static void main(String[] args)
	{
		ISort sort = new SortPractice6();

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
	}

}
