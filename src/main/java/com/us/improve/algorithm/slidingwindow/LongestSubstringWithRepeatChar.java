package com.us.improve.algorithm.slidingwindow;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LongestSubstringWithRepeatChar
 * @Desciption 无重复字符的最长子串
 * @Author loren
 * @Date 2020/4/17 1:46 PM
 * @Version 1.0
 **/
public class LongestSubstringWithRepeatChar {

    /**
     * 问题描述
     *
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     */

    /**
     * 解题思路
     *
     *
     */

    public static int getLongestSubstringWithRepeatChar(String str) {
        // 边界判断
        if (StringUtils.isBlank(str)) {
            return 0;
        }

        if (str.length() == 1) {
            return 1;
        }

        // map用来记录字符出现的最后一个位置
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;

        int left = 0;
        int right = 0;
        while (right < str.length()) {
            Character c = str.charAt(right);

            // 如果c出现的位置在map中被记录过
            if (map.containsKey(c)) {
                // 如果c出现的位置在当前窗口之内，则窗口的left端直接滑动到left出现的下一个位置
                if (map.get(c) >= left) {
                    left = map.get(c) + 1;
                } else {
                    max = Math.max(max, right - left + 1);
                }
            } else {
                max = Math.max(max, right - left + 1);
            }

            map.put(c, right);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "abcabcdb";
        System.out.println(getLongestSubstringWithRepeatChar(str));
    }

}
