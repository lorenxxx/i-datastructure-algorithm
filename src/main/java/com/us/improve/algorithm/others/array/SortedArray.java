package com.us.improve.algorithm.others.array;

/**
 * @ClassName SortedArray
 * @Desciption 实现一个大小固定的有序数组，支持动态增删改操作
 * @Author loren
 * @Date 2020/4/3 5:27 PM
 * @Version 1.0
 **/
public class SortedArray {

    private int[] elementData;

    private int capacity;

    private int size;

    public SortedArray(int capacity) {
        this.elementData = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void add(int data) {
        // 容量判断
        if (size >= capacity) {
            return;
        }

        // 通过二分查找，找到最后一个小于等于给定元素的下标
        int index = -1;
        int low = 0;
        int high = this.size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (this.elementData[mid] <= data) {
                if (mid == size - 1 || this.elementData[mid + 1] > data) {
                    index = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }

        // 搬移元素
        for (int k = index + 1; k < this.size; k++) {
            this.elementData[k + 1] = this.elementData[k];
        }

        // 插入元素
        this.elementData[index + 1] = data;
        size++;
    }

    public void delete(int data) {
        // 如果数组中没有元素，则直接返回
        if (size == 0) {
            return;
        }

        // 通过二分查找，找到第一个大于等于给定元素的数组下标
        int index = -1;
        int low = 0;
        int high = this.size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (this.elementData[mid] == data) {
                if (mid == 0 || this.elementData[mid - 1] < data) {
                    index = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else if (this.elementData[mid] < data) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (index != -1) {
            int step = 1;
            int k = index;
            while (k < this.size - 1 && this.elementData[++k] == data) {
                step++;
            }

            while (index + step < this.size) {
                this.elementData[index] = this.elementData[index + step];
                index++;
            }

            this.size -= step;
        }

    }

    public void updateByIndex(int index, int data) {
        if (index >= size) {
            return;
        }

        int oldData = this.elementData[index];
        if (data < oldData) {
            int k = index - 1;
            while (k >= 0) {
                if (this.elementData[k] > data) {
                    this.elementData[k + 1] = this.elementData[k];
                    k--;
                } else {
                    break;
                }
            }
            this.elementData[k + 1] = data;
        } else if (data > oldData) {
            int k = index + 1;
            while (k <= this.size - 1) {
                if (this.elementData[k] < data) {
                    this.elementData[k - 1] = this.elementData[k];
                    k++;
                } else {
                    break;
                }
            }
            this.elementData[k - 1] = data;
        }
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elementData[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray(5);
        sortedArray.add(3);
        sortedArray.display();

        sortedArray.add(10);
        sortedArray.display();

        sortedArray.add(5);
        sortedArray.add(7);
        sortedArray.display();

        //sortedArray.delete(9);
        //sortedArray.display();

        sortedArray.updateByIndex(2, 11);
        sortedArray.display();
    }

}
