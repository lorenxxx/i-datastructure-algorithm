package com.us.improve.algorithm.others.array;

import java.util.Arrays;

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
        if (size >= capacity) {
            return;
        }

    }

    public void delete(int data) {

    }

    public void update(int oldData, int newData) {

    }

    public void updateByIndex(int index, int data) {

    }

    public void display() {
        System.out.println(Arrays.toString(this.elementData));
    }

    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray(10);
    }

}
