package com.us.improve.algorithm.recursive;

/**
 * @ClassName NFactorial
 * @Desciption 计算n的阶乘
 * @Author loren
 * @Date 2020/6/17 7:20 PM
 * @Version 1.0
 **/
public class NFactorial {

    public int f(int n) {
        if (n == 1) {
            return 1;
        }

        return n * f(n - 1);
    }

}
