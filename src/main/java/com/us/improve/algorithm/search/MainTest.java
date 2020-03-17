package com.us.improve.algorithm.search;

/**
 * @ClassName MainTest
 * @Desciption TODO
 * @Author loren
 * @Date 2020/3/17 3:27 PM
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();

        int[] arr1 = new int[] {0, 1, 2, 3, 4, 6, 8, 9, 10, 11, 23, 34, 54, 55, 77, 90};
        int[] arr2 = new int[] {0, 1, 2, 2, 3, 4, 4, 4, 4, 6, 8, 8, 9, 9, 10, 11, 23, 34, 54, 55, 77, 90};

        int result1 = search.bSearch1(arr1, 77);
        System.out.println(result1);

        int result2 = search.bSearch2(arr1, 6);
        System.out.println(result2);

        int result3 = search.bSearch3(arr2, 4);
        System.out.println(result3);

        int result4 = search.bSearch4(arr2, 2);
        System.out.println(result4);

        int result5 = search.bSearch5(arr2, 5);
        System.out.println(result5);

        int result6 = search.bSearch6(arr2, 5);
        System.out.println(result6);

    }

}
