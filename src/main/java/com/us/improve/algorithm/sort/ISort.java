package com.us.improve.algorithm.sort;

/**
 * @ClassName ISort
 * @Desciption 排序接口定义
 * @Author loren
 * @Date 2020/3/12 3:11 PM
 * @Version 1.0
 **/
public interface ISort {

    /**
     * 冒泡排序
     *
     * 时间复杂度: O(n^2)
     *
     * @param arr 待排序数组
     */
    void bubbleSort(int[] arr);

    /**
     * 插入排序
     *
     * 时间复杂度: O(n^2)
     *
     * @param arr 待排序数组
     */
    void insertSort(int[] arr);

    /**
     * 希尔排序(增量递减插入排序)
     * 插入排序的改进版本
     *
     * @param arr 待排序数组
     */
    void shellSort(int[] arr);

    /**
     * 选择排序
     *
     * 时间复杂度: O(n^2)
     *
     * @param arr 待排序数组
     */
    void selectSort(int[] arr);

    /**
     * 归并排序
     *
     * 递推公式: merge_sort(p...r) = merge(merge_sort(p...q), merge_sort(q + 1 ... q))
     * 终止条件: p >= r 不用再继续分解
     *
     * 时间复杂度: O(nlogn)
     * 空间复杂度: O(n)
     *
     * @param arr 待排序数组
     */
    void mergeSort(int[] arr);

    /**
     * 快速排序
     *
     * 递推公式: quick_sort(p...r) = quick_sort(p...q) + quick_sort(q + 1 ... r)
     * 终止条件: p >= r
     *
     * 时间复杂度: O(nlogn)
     * 空间复杂度: O(1) 原地排序
     *
     * @param arr 待排序数组
     */
    void quickSort(int[] arr);

}