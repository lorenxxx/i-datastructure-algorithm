package com.us.improve.leetcode.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NumDecoding
 * @Desciption 数字解码
 * @Author loren
 * @Date 2020/4/25 8:45 PM
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

        Map<Integer, Integer> memo = new HashMap<>();

        return doDecode(str, 0, str.length() - 1, memo);
    }

    private int doDecode(String str, int begin, int end, Map<Integer, Integer> memo) {
        if (memo.containsKey(begin)) {
            return memo.get(begin);
        }

        if (str.charAt(begin) == '0') {
            return 0;
        }

        // 仅一位数字
        if (end - begin <= 0) {
            return 1;
        }

        // 剩余至少两位数字
        // 考虑只取一位数字的情况
        int count = doDecode(str, begin + 1, end, memo);
        // 考虑取两位数字的情况
        if (str.charAt(begin) == '1' || (str.charAt(begin) == '2' && str.charAt(begin + 1) <= '6')) {
            count += doDecode(str, begin + 2, end, memo);
        }

        memo.put(begin, count);
        return count;
    }

    public static void main(String[] args) {
        NumDecoding numDecoding = new NumDecoding();

        String str = "226";
        numDecoding.decode(str);
        System.out.println(numDecoding.decode(str));
    }

}
