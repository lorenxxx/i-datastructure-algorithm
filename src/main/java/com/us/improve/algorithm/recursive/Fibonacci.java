package com.us.improve.algorithm.recursive;

/**
 * @ClassName Fibonacci
 * @Desciption 斐波那契数列
 * @Author loren
 * @Date 2020/6/17 7:24 PM
 * @Version 1.0
 **/
public class Fibonacci {

    public int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return f(n - 1) + f(n - 2);
    }

}
