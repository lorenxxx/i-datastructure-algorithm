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
     * @param arr 待排序数组
     */
    void bubbleSort(int[] arr);

    /**
     * 插入排序
     *
     * @param arr 待排序数组
     */
    void insertSort(int[] arr);

    /**
     * 选择排序
     *
     * @param arr 待排序数组
     */
    void selectSort(int[] arr);

}