package com.us.improve.algorithm.greedy;

import java.util.Arrays;

/**
 * @ClassName Sweets
 * @Desciption 分糖果
 * @Author loren
 * @Date 2020/4/15 2:49 PM
 * @Version 1.0
 **/
public class Sweets {

    /**
     * 问题描述
     *
     * 我们有 m 个糖果和 n 个孩子
     * 我们现在要把糖果分给这些孩子吃，但是糖果少，孩子多，（m < n），所以糖果只能分配给一部分孩子
     * 每个糖果的大小不等，这 m 个糖果的大小分别是 s1，s2，s3，……，sm
     * 除此之外，每个孩子对糖果大小的需求也是不一样的，只有糖果的大小大于等于孩子的对糖果大小的需求的时候，孩子才得到满足
     * 假设这 n 个孩子对糖果大小的需求分别是 g1，g2，g3，……，gn。
     * 如何分配糖果，能尽可能满足最多数量的孩子？
     */

    /**
     * 解题思路
     *
     * 1、对于任意一个孩子来说，如果小的糖果能够满足，就没必要用给他分配更大的糖果，这样更大的糖果就可以留给需求更大的孩子
     * 2、对糖果需求更小的孩子更容易被满足，所以优先从需求小的孩子进行分配，因为满足一个需求小的孩子和满足一个需求大的孩子对期望值的贡献是一样的
     */

    /**
     * 表示糖果的大小
     */
    private int[] sweets = {1, 3, 3, 5, 6};

    /**
     * 表示孩子对糖果的需求
     */
    private int[] children = {1, 2, 4, 5, 7, 9, 6};

    /**
     * 表示分配方案
     */
    private int[] solution = new int[children.length];

    public static int[] assign(int[] sweets, int[] children) {
        // 边界校验
        if (sweets == null || sweets.length == 0) {
            return null;
        }

        // 边界校验
        if (children == null || children.length == 0) {
            return null;
        }

        int[] ret = new int[children.length];
        Arrays.sort(sweets);
        Arrays.sort(children);

        System.out.println(Arrays.toString(children));

        int sp = 0;
        for (int i = 0; i < children.length; i++) {
            // 是否产生分配标志位
            boolean flag = false;

            for (int j = sp; j < sweets.length; j++) {
                if (sweets[j] >= children[i]) {
                    ret[i] = sweets[j];
                    sp = j + 1;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] sweets = {1, 3, 3, 5, 6};
        int[] children = {1, 2, 4, 5, 7, 9, 6};

        int[] ret = Sweets.assign(sweets, children);
        System.out.println(Arrays.toString(ret));
    }

}
