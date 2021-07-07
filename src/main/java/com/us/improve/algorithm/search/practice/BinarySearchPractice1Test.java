package com.us.improve.algorithm.search.practice;

/**
 * @ClassName BinarySearchPractice1Test
 * @Desciption 二分查找练习1测试
 * @Author loren
 * @Date 2020/4/21 5:22 PM
 * @Version 1.0
 **/
public class BinarySearchPractice1Test {

    public static void main(String[] args) {
        BinarySearchPractice1 binarySearch = new BinarySearchPractice1();

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
