package com.us.improve.leetcode.recursive;

/**
 * @ClassName ClimbingStairs
 * @Desciption 用递归求解爬楼梯的问题
 * @Author loren
 * @Date 2020/4/13 3:35 PM
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

        return climb(n - 1) + climb(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        int result = climb(n);
        System.out.println(result);
    }

}
