package com.us.improve.algorithm.others.array;

import java.util.Arrays;

/**
 * @ClassName DynamicExpansionArray
 * @Desciption 实现一个支持动态扩容的数组
 * @Author loren
 * @Date 2020/4/3 5:07 PM
 * @Version 1.0
 **/
public class DynamicExpansionArray {

    private int[] elementData;

    private int capacity;

    private int size;

    public DynamicExpansionArray(int capacity) {
        this.elementData = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void add(int data) {
        ensureCapacity();
        elementData[size++] = data;
    }

    private void ensureCapacity() {
        if (this.size >= this.capacity) {
            System.out.println("Expansion...");
            int newCapacity = this.capacity * 2;
            int[] newElementData = new int[newCapacity];
            System.arraycopy(this.elementData, 0, newElementData, 0, this.elementData.length);

            this.elementData = newElementData;
            this.capacity = newCapacity;
        }
    }

    public void display() {
        System.out.println(Arrays.toString(this.elementData));
    }

    public static void main(String[] args) {
        DynamicExpansionArray dynamicExpansionArray = new DynamicExpansionArray(1);
        dynamicExpansionArray.add(1);
        dynamicExpansionArray.add(2);
        dynamicExpansionArray.add(3);
        dynamicExpansionArray.add(4);
        dynamicExpansionArray.add(5);
        dynamicExpansionArray.display();
    }

}
