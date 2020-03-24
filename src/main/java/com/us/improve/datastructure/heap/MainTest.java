package com.us.improve.datastructure.heap;

/**
 * @ClassName MainTest
 * @Desciption 测试
 * @Author loren
 * @Date 2020/3/24 3:18 PM
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {
        Heap heap = new Heap(2);

        Integer[] datas = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int data : datas) {
            heap.insert(data);
        }
        heap.display();

        heap.removeMax();
        heap.display();

        Heap buildedHeap = Heap.buildHeap(datas);
        buildedHeap.display();
    }

}
