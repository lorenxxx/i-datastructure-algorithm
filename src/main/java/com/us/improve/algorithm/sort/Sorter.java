package com.us.improve.algorithm.sort;

/**
 * @ClassName Sorter
 * @Desciption 排序器
 * @Author loren
 * @Date 2020/3/12 3:15 PM
 * @Version 1.0
 **/
public class Sorter implements ISort {

    @Override
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // 表示有数据交换
                    flag = true;
                }
            }

            // 如果没有数据交换，则提前退出冒泡循环
            if (!flag) {
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
            int value = arr[i];

            int j = i - 1;
            // 寻找合适的插入位置
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    // 元素移动
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = value;
        }
    }

    @Override
    public void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int step = arr.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = tmp;
            }
        }
    }

    @Override
    public void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            // 寻找未排序区间最小的元素
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // 交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

    @Override
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] result = new int[arr.length];
        mergeSortRecursive(arr, result, 0, arr.length - 1);
    }

    private void mergeSortRecursive(int[] arr, int[] result, int low, int high) {
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

                i++;
                j--;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivot;

        doQuickSort(arr, low, j - 1);
        doQuickSort(arr, j + 1, high);
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
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        int tmp = arr[low];
        arr[low] = arr[i];
        arr[i] = tmp;

        doQuickSort(arr, low, i - 1);
        doQuickSort(arr, i + 1, high);
    }

    @Override
    public void bucketSort(int[] arr) {

    }

    @Override
    public void countingSort(int[] arr) {

    }

    @Override
    public void radixSort(int[] arr) {

    }


}
