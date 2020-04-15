package com.us.improve.algorithm.greedy;

import java.util.Arrays;

/**
 * @ClassName PayChange
 * @Desciption 支付找零
 * @Author loren
 * @Date 2020/4/15 3:40 PM
 * @Version 1.0
 **/
public class PayChange {

    /**
     * 问题描述
     *
     * 假设我们有 1 元、2 元、5 元、10 元、20 元、50 元、100 元这些面额的纸币，
     * 它们的张数分别是 c1、c2、c5、c10、c20、c50、c100。我们现在要用这些钱来支付 K 元，最少要用多少张纸币呢？
     */

    /**
     * 解题思路
     *
     * 先用面值最大的来支付，如果不够，就继续用更小一点面值的，以此类推，最后剩下的用 1 元来补齐。
     * 在贡献相同期望值（纸币数目）的情况下，我们希望多贡献点金额，这样就可以让纸币数更少，这就是一种贪心算法的解决思路。
     */

    /**
     * 纸币面值
     */
    private static int[] moneyValue = {100, 50, 20, 10, 5, 2, 1};

    /**
     *
     * @param moneyCount
     * @param total
     * @return
     */
    public static int[] payChange(int[] moneyCount, int total) {
        if (moneyCount == null || moneyCount.length == 0) {
            return null;
        }

        if (total < 0) {
            return null;
        }

        int[] ret = new int[moneyValue.length];

        int tmpTotal = 0;
        for (int i = 0; i < moneyValue.length && tmpTotal < total; i++) {
            for (int j = 0; j < moneyCount[i]; j++) {
                if (tmpTotal + moneyValue[i] <= total) {
                    tmpTotal += moneyValue[i];
                    ret[i] += 1;
                } else {
                    break;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] moneyCount = {1, 5, 5, 5, 5, 5, 5};
        int total = 298;

        int[] ret = PayChange.payChange(moneyCount, total);
        System.out.println(Arrays.toString(ret));
    }

}
