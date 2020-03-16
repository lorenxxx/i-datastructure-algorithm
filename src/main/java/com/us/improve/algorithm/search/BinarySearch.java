package com.us.improve.algorithm.search;

/**
 * @ClassName BinarySearch
 * @Desciption 二分查找
 * @Author loren
 * @Date 2020/3/16 4:20 PM
 * @Version 1.0
 **/
public class BinarySearch {

    /**
     * 简单二分查找：有序数组中不存在重复元素，查找值等于给定值的元素下标
     *
     * 非递归实现
     *
     * @param arr   待查找数组
     * @param value 待查找值
     * @return 元素下标，如果不存在则返回-1
     */
    public int bSearch1(int[] arr, int value) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 简单二分查找：有序数组中不存在重复元素，查找值等于给定值的元素下标
     *
     * 递归实现
     *
     * @param arr   待查找数组
     * @param value 待查找值
     * @return 元素下标，如果不存在则返回-1
     */
    public int bSearch2(int[] arr, int value) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        return doBSearch2(arr, 0, arr.length - 1, value);
    }

    private int doBSearch2(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return doBSearch2(arr, mid + 1, high, value);
        } else {
            return doBSearch2(arr, low, mid - 1, value);
        }
    }

    /**
     * 二分查找变体：有序数组中存在重复元素，查找第一个值等于给定值的元素下标
     *
     * 递归实现
     *
     * @param arr   待查找数组
     * @param value 待查找值
     * @return 元素下标，如果不存在则返回-1
     */
    public int bSearch3(int[] arr, int value) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * 二分查找变体：有序数组中存在重复元素，查找最后一个值等于给定值的元素
     *
     * 递归实现
     *
     * @param arr   待查找数组
     * @param value 待查找值
     * @return 元素下标，如果不存在则返回-1
     */
    public int bSearch4(int[] arr, int value) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 二分查找变体：有序数组中存在重复元素，查找第一个大于等于给定值的元素
     *
     * 递归实现
     *
     * @param arr   待查找数组
     * @param value 待查找值
     * @return 元素下标，如果不存在则返回-1
     */
    public int bSearch5(int arr[], int value) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                if (mid == 0 || arr[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 二分查找变体：有序数组中存在重复元素，查找最后一个小于等于给定值的元素
     *
     * 递归实现
     *
     * @param arr   待查找数组
     * @param value 待查找值
     * @return 元素下标，如果不存在则返回-1
     */
    public int bSearch6(int arr[], int value) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= value) {
                if (mid == arr.length - 1 || arr[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


}
