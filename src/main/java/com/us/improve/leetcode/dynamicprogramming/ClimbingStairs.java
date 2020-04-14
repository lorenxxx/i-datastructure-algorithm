package com.us.improve.leetcode.dynamicprogramming;

/**
 * @ClassName ClimbingStairs
 * @Desciption 用动态规划求解爬楼梯问题
 * @Author loren
 * @Date 2020/4/13 3:47 PM
 * @Version 1.0
 **/
public class ClimbingStairs {

    public static int climb(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int a = 1, b = 2;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }

        return tmp;
    }
}
