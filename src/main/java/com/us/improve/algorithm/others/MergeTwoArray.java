package com.us.improve.algorithm.others;

import java.util.Arrays;

/**
 * @ClassName MergeTwoArrays
 * @Desciption 实现两个有序数组合并为一个有序数组
 * @Author loren
 * @Date 2020/4/3 4:48 PM
 * @Version 1.0
 **/
public class MergeTwoArray {

    public int[] merge(int[] arr1, int[] arr2) {
        int[] result;

        if (arr1 == null && arr2 == null) {
            return null;
        }
        if (arr1 == null) {
            result = new int[arr2.length];
            System.arraycopy(arr2, 0, result, 0, arr2.length);
            return result;
        }
        if (arr2 == null) {
            result = new int[arr1.length];
            System.arraycopy(arr1, 0 , result, 0, arr1.length);
            return result;
        }

        result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            result[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = null;
        int[] arr2 = null;
        int[] result;

        MergeTwoArray mergeTwoArray = new MergeTwoArray();

        result = mergeTwoArray.merge(arr1, arr2);
        System.out.println(Arrays.toString(result));

        arr1 = new int[] {1, 4, 6};
        arr2 = null;

        result = mergeTwoArray.merge(arr1, arr2);
        System.out.println(Arrays.toString(result));

        arr1 = null;
        arr2 = new int[] {0, 7, 9};
        result = mergeTwoArray.merge(arr1, arr2);
        System.out.println(Arrays.toString(result));

        arr1 = new int[] {1, 4, 6};
        arr2 = new int[] {0, 7, 9};
        result = mergeTwoArray.merge(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

}
