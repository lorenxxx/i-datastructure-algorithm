package com.us.improve.algorithm.recursive;

/**
 * @ClassName ClimbStairs
 * @Desciption 爬楼梯
 * @Author loren
 * @Date 2020/6/17 7:33 PM
 * @Version 1.0
 **/
public class ClimbStairs {

    public int f(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return f(n - 1) + f(n - 2);
    }

}
