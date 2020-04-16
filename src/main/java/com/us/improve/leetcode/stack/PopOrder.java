package com.us.improve.leetcode.stack;

/**
 * @ClassName PopOrder
 * @Desciption 栈的压入、弹出序列
 * @Author loren
 * @Date 2020/4/16 2:14 PM
 * @Version 1.0
 **/
public class PopOrder {

    /**
     * 问题描述
     *
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
     * 假设压入栈的所有数字均不相等
     * 这两个序列的长度是相等的
     */

    /**
     * 解题思路
     *
     * 双指针
     * i 和 arr.length - n - 1
     */

    public static boolean isPopOrder(int[] pushSequence, int[] popSequence) {
        // 边界判断省略

        int n = pushSequence.length - 1;
        for (int i = 0; i <= n; i++) {
            if (!(pushSequence[i] == popSequence[n - i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] pushSequence = {1, 2, 3, 4, 5};
        int[] popSequence = {5, 4, 3, 2, 0};
        System.out.println(isPopOrder(pushSequence, popSequence));
    }

}
