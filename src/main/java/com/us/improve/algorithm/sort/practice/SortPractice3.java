package com.us.improve.algorithm.sort.practice;

import com.us.improve.algorithm.sort.ISort;

/**
 * @ClassName SortPractice3
 * @Desciption 排序练习3
 * @Author loren
 * @Date 2020/4/19 3:26 PM
 * @Version 1.0
 **/
public class SortPractice3 implements ISort {

    @Override
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapFlag = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    swapFlag = true;
                }
            }

            if (!swapFlag) {
                break;
            }
        }
    }

    @Override
    public void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];

            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > insertValue) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = insertValue;
        }
    }

    @Override
    public void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int step = arr.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int insertValue = arr[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (arr[j] > insertValue) {
                        arr[j + step] = arr[j];
                    } else {
                        break;
                    }
                }

                arr[j + step] = insertValue;
            }
        }
    }

    @Override
    public void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    @Override
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] result = new int[arr.length];
        doMergeSort(arr, result, 0, arr.length - 1);
    }

    private void doMergeSort(int[] arr, int[] result, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        int left1 = left;
        int right1 = mid;
        int left2 = mid + 1;
        int right2 = right;

        doMergeSort(arr, result, left1, right1);
        doMergeSort(arr, result, left2, right2);

        int k = left;
        while (left1 <= right1 && left2 <= right2) {
            result[k++] = arr[left1] < arr[left2] ? arr[left1++] : arr[left2++];
        }
        while (left1 <= right1) {
            result[k++] = arr[left1++];
        }
        while (left2 <= right2) {
            result[k++] = arr[left2++];
        }

        for (k = left; k <= right; k++) {
            arr[k] = result[k];
        }
    }

    @Override
    public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        doQuickSort(arr, 0, arr.length - 1);
    }

    private void doQuickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        int i = low;
        int j = high;
        int pivot = arr[low];

        while (i < j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivot;

        doQuickSort(arr, low, j - 1);
        doQuickSort(arr, j + 1, high);
    }

}
