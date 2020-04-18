package com.us.improve.datastructure.heap;

import java.util.Arrays;

/**
 * @ClassName BigTopHeap
 * @Desciption 大顶堆
 * @Author loren
 * @Date 2020/4/16 2:51 PM
 * @Version 1.0
 **/
public class BigTopHeap {

    /**
     * 关于堆
     *
     * 如果从数组下标1开始存储数据，则对于一个节点i来说：
     * 左节点 = 2 * i
     * 右节点 = 2 * i + 1
     * 父节点 = i / 2
     * 非叶子节点[1, n/2]
     * 叶子节点[n/2 + 1, n]
     *
     * 如果从数组下标0开始存储，则对于一个节点i来说：
     * 左节点 = 2 * i + 1
     * 右节点 = 2 * i + 2
     * 父节点 = (i - 1) / 2
     * 非叶子节点[1, n/2 - 1]
     * 叶子节点[n/2, n - 1]
     */

    /**
     * 堆是一个完全二叉树，底层用数组存储
     */
    private Integer[] arr;

    /**
     * 堆中能存储的最大元素数量
     */
    private int capacity;

    /**
     * 当前堆中元素数量
     */
    private int n;

    public BigTopHeap(int capacity) {
        this.arr = new Integer[capacity + 1];
        this.capacity = capacity;
        this.n = 0;
    }

    public BigTopHeap(Integer[] arr) {
        this(arr.length);
        System.arraycopy(arr, 0, this.arr, 1, arr.length);
        this.n = arr.length;
        buildHead();
    }

    /**
     * 插入元素
     *
     * @param data
     */
    public void insert(int data) {
        if (n >= capacity) {
            return;
        }

        // 先将元素插入到数组尾部
        arr[++n] = data;

        // 自下而上进行堆化
        // 时间复杂度就是树的高度，所以为 O(logn)。
        int i = n;
        while (i / 2 > 0 && arr[i] > arr[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 移除堆顶元素
     *
     * @return 堆顶元素
     */
    public Integer removeTop() {
        if (n == 0) {
            return null;
        }

        // 暂存堆顶元素
        int top = arr[1];

        int count = n;
        // 将数组末尾的元素保存到堆顶，然后自上而下堆化
        arr[1] =  arr[count];
        arr[count] = null;
        n--;
        heapifyFromUp2Down(1, n);

        return top;
    }

    public void sort() {
        int i = n;
        while (true) {
            if (i <= 1) {
                break;
            }

            swap(1, i);
            i--;
            heapifyFromUp2Down(1, i);
        }
    }

    /**
     * 展示堆中的数组
     */
    public void displayArr() {
        System.out.println(Arrays.toString(this.arr));
    }

    private void buildHead() {
        for (int i = n / 2; i > 0; i--) {
            heapifyFromUp2Down(i, n);
        }
    }

    /**
     * 自上而下堆化
     *
     * 时间复杂度就是树的高度，所以为 O(logn)
     *
     * @param i 起点下标
     * @param n 终点下标
     */
    private void heapifyFromUp2Down(int i, int n) {
        while (true) {
            int maxValueIndex = i;

            int left = i * 2;
            int right = i * 2 + 1;
            // 如果左节点比父节点大
            if (left <= n && arr[i] < arr[left]) {
                maxValueIndex = left;
            }
            // 如果右节点左节点或父节点大
            if (right <= n && arr[maxValueIndex] < arr[right]) {
                maxValueIndex = right;
            }

            // 如果当前节点值为最大值，无需再往下迭代了
            if (maxValueIndex == i) {
                break;
            }

            swap(maxValueIndex, i);
            i = maxValueIndex;
        }
    }

    /**
     * 交换数组中的两个元素
     *
     * @param i   下标
     * @param j   下标
     */
    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 1, 7, 5, 8, 9};
        BigTopHeap heap = new BigTopHeap(nums);
        heap.displayArr();

        int top = heap.removeTop();
        System.out.println(top);
        heap.displayArr();

        heap.sort();
        heap.displayArr();
    }

}
