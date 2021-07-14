package com.us.improve.algorithm.search.practice;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-14 22:15
 * @Version 1.0
 **/
public class BinarySearchPractice2Test {

	public static void main(String[] args) {
		BinarySearchPractice2 binarySearch = new BinarySearchPractice2();

		int[] arr1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] arr2 = new int[] {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};

		System.out.println("Index: " + binarySearch.bSearch1(arr1, 3));
		System.out.println("Index: " + binarySearch.bSearch2(arr1, 3));
		System.out.println("Index: " + binarySearch.bSearch3(arr2, 2));
		System.out.println("Index: " + binarySearch.bSearch4(arr2, 2));
		System.out.println("Index: " + binarySearch.bSearch5(arr2, 2));
		System.out.println("Index: " + binarySearch.bSearch6(arr2, 2));
	}

}
