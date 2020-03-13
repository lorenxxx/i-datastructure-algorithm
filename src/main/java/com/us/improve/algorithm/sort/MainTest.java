package com.us.improve.algorithm.sort;

/**
 * @ClassName MainTest
 * @Desciption 测试
 * @Author loren
 * @Date 2020/3/12 4:08 PM
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {
        ISort sort = new Sorter();

        int[] arr1 = new int[] {4, 5, 6, 3 , 2, 1, 3};
        sort.bubbleSort(arr1);
        displayArr(arr1);

        int[] arr2 = new int[] {4, 5, 6, 3 , 2, 1, 3};
        sort.insertSort(arr2);
        displayArr(arr2);

        int[] arr3 = new int[] {4, 5, 6, 3 , 2, 1, 3};
        sort.shellSort(arr3);
        displayArr(arr3);

        int[] arr4 = new int[] {4, 5, 6, 3 , 2, 1, 3};
        sort.selectSort(arr4);
        displayArr(arr4);
    }

    public static void displayArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
