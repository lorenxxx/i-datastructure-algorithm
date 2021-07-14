package com.us.improve.datastructure.heap;

import java.util.Arrays;

/**
 * @ClassName Heap
 * @Desciption 堆
 * @Author loren
 * @Date 2020/3/24 3:04 PM
 * @Version 1.0
 **/
public class Heap {

    /**
     * 数组
     */
    private Integer[] elementData;

    /**
     * 堆可以存储的最大数据个数
     */
    private int capacity;

    /**
     * 堆中已经存储的数据个数
     */
    private int count;

    public Heap(int capacity) {
        this.elementData = new Integer[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    public static Heap buildHeap(Integer[] arr) {
        if (arr == null || arr.length <= 0) {
            return null;
        }

        Heap heap = new Heap(arr.length);
        for (Integer data : arr) {
            heap.insert(data);
        }

        return heap;
    }

    /**
     * 插入
     *
     * @param data 待插入数据
     */
    public void insert(int data) {
        ensureCapacity();
        elementData[count] = data;
        heapifyDown2Up(this.elementData, count);
        count++;
    }

    /**
     * 删除最大数据
     *
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }

        this.elementData[0] = this.elementData[count - 1];
        this.elementData[count - 1] = null;
        count--;

        heapifyUp2Down(this.elementData, 0, this.count);
    }

    /**
     * 从下往上堆化
     *
     * @param index 堆化起点
     */
    private void heapifyDown2Up(Integer[] arr, int index) {
        for (int i = index; getParentNodeIndex(i) >= 0 && arr[i] > arr[getParentNodeIndex(i)]; i = getParentNodeIndex(i)) {
            int tmp = arr[getParentNodeIndex(i)];
            arr[getParentNodeIndex(i)] = arr[i];
            arr[i] = tmp;
        }
    }

    /**
     * 从上往下堆化
     *
     * @param index 堆化起点
     */
    private void heapifyUp2Down(Integer[] arr, int index, int count) {
        int i = index;
        while (true) {
            int maxPos = i;
            if (getLeftNodeIndex(i) < count && arr[i] < arr[getLeftNodeIndex(i)]) {
                maxPos = getLeftNodeIndex(i);
            }
            if (getRightNodeIndex(i) < count && arr[maxPos] < arr[getRightNodeIndex(i)]) {
                maxPos = getRightNodeIndex(i);
            }
            if (maxPos == i) {
                break;
            }

            // swap
            Integer tmp = arr[i];
            arr[i] = arr[maxPos];
            arr[maxPos] = tmp;

            i = maxPos;
        }

    }

    /**
     * 扩容
     */
    private void ensureCapacity() {
        if (this.capacity == this.count) {
            int newCapacity = capacity * 2;
            Integer[] newElementData = new Integer[newCapacity + 1];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);

            this.elementData = newElementData;
            this.capacity = newCapacity;
        }
    }

    /**
     * 展示
     */
    public void display() {
        System.out.println(Arrays.toString(this.elementData));
    }

    /**
     * 获取父节点在数组中的下标
     *
     * @param i 节点下标
     * @return 父节点在数组中的下标
     */
    private int getParentNodeIndex(int i) {
        return (i - 1) / 2;
    }

    /**
     * 获取左子节点在数组中的下标
     *
     * @param i 节点下标
     * @return 左子节点的数组下标
     */
    private int getLeftNodeIndex(int i) {
        return i * 2 + 1;
    }

    /**
     * 获取右子节点在数组中的下标
     *
     * @param i 节点下标
     * @return 左子节点的数组下标
     */
    private int getRightNodeIndex(int i) {
        return i * 2 + 2;
    }

}
