package com.us.improve.leetcode.dynamicprogramming;

/**
 * @ClassName NumDecoding
 * @Desciption 数字解码
 * @Author loren
 * @Date 2020/4/25 10:12 PM
 * @Version 1.0
 **/
public class NumDecoding {

    /**
     * 问题描述
     *
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     *
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     * 示例 1
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）
     */

    public int decode(String str) {
        if (str == null || str.length() == 0 || str.charAt(0) == '0') {
            return 0;
        }

        if (str.length() == 1) {
            return 1;
        }

        int pre0 = 1;
        int pre1 = 1;
        for (int i = 2; i < str.length(); i++) {
            int tmp = 0;
            if (!isValid(str.charAt(i)) && !isValid(str.charAt(i - 1), str.charAt(i))) {
                return 0;
            } else if (!isValid(str.charAt(i)) && isValid(str.charAt(i - 1), str.charAt(i))) {
                tmp = pre0;
            } else if (isValid(str.charAt(i)) && !isValid(str.charAt(i - 1), str.charAt(i))) {
                tmp = pre1;
            } else {
                tmp = pre0 + pre1;
            }
            pre0 = pre1;
            pre1 = tmp;
        }
        return pre1;
    }

    private boolean isValid(char c) {
        return c != '0';
    }

    private boolean isValid(char c1, char c2) {
        int num = (c1 - '0') * 10 + (c2 - '0');
        return num >= 10 && num <= 26;
    }

    public static void main(String[] args) {
        NumDecoding numDecoding = new NumDecoding();

        String str = "224";
        System.out.println(numDecoding.decode(str));
    }
}
