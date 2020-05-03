package com.us.improve.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LongestSubstringWithoutRepeatingCharacters
 * @Desciption 最长无重复字符子串
 * @Author loren
 * @Date 2020/4/8 3:41 PM
 * @Version 1.0
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 问题描述
     *
     * 最长无重复字符子串
     * 给定一个字符串，请你找出其中不含有重复字符的#最长子串#的长度
     */

    /**
     * 解题思路
     *
     */


    public static int findLongestSubstring1(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        int res = 0;
        int left = 0;
        int right = 0;
        Set<Character> windowSet = new HashSet<>(str.length());

        while (left < str.length() && right < str.length()) {
            Character tmpChar = str.charAt(right);
            if (!windowSet.contains(tmpChar)) {
                windowSet.add(tmpChar);
                right++;
                res = right - left > res ? right - left : res;
            } else {
                windowSet.remove(str.charAt(left));
                left++;
            }
        }

        return res;
    }

    public static int findLongestSubstring2(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int begin = 0, end = 0; end < str.length(); end++) {
            Integer index = map.get(str.charAt(end));
            // 如果为空，表示之前不存在重复字符
            // 如果不为空，则要判断字符的位置是否大于等于begin的位置，因为我们的区间是【begin，end）
            // 而我们进行窗口滑动时候，只是将begin移动到了重复字符之后，并没有在map中删除重复字符之前到所有元素
            // 所以，我们要判断重复的字符是否在我们有效的区间内
            if (index != null && index >= begin) {
                begin = index + 1;
            }
            map.put(str.charAt(end), end);
            sum = Math.max(sum, end -  begin + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(findLongestSubstring1(str));
        System.out.println(findLongestSubstring2(str));
    }

}
