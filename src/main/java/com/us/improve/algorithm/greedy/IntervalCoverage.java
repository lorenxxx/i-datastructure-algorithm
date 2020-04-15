package com.us.improve.algorithm.greedy;

import java.util.Arrays;

/**
 * @ClassName IntervalCoverage
 * @Desciption 区间覆盖
 * @Author loren
 * @Date 2020/4/15 4:12 PM
 * @Version 1.0
 **/
public class IntervalCoverage {

    // TODO: 2020/4/15  

    /**
     * 问题描述
     *
     * 假设我们有 n 个区间，区间的起始端点和结束端点分别是[l1, r1]，[l2, r2]，[l3, r3]，……，[ln, rn]
     * 我们从这 n 个区间中选出一部分区间，这部分区间满足两两不相交（端点相交的情况不算相交），最多能选出多少个区间呢？
     */

    /**
     * 解题思路
     *
     * 我们每次选择的时候，左端点跟前面的已经覆盖的区间不重合的，右端点又尽量小的，这样可以让剩下的未覆盖区间尽可能的大，就可以放置更多的区间。
     */

    public static int[][] intervalCoverage(int[][] segments, int left, int right) {
        // 边界判断省略...

        int[] used = new int[segments.length];

        return null;
    }

    public static void main(String[] args) {
        int[][] segments = {
                {6, 8},
                {2, 4},
                {3, 5},
                {1, 5},
                {5, 9},
                {8, 10}
        };

        int left = 1;
        int right = 10;

        int[][] ret = IntervalCoverage.intervalCoverage(segments, left, right);
        System.out.println(Arrays.toString(ret));
    }

}
