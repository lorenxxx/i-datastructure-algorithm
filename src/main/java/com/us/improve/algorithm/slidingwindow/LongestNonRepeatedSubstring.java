package com.us.improve.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LongestNonRepeatSubstring
 * @Desciption 最长无重复字符子串
 * @Author loren
 * @Date 2020/4/17 1:46 PM
 * @Version 1.0
 **/
public class LongestNonRepeatedSubstring {

	/**
	 * 问题描述
	 *
	 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	 */

	/**
	 * 解题思路
	 * <p>
	 * 滑动窗口
	 * 同时用一个map来记录每一个字符出现的最后一个位置
	 */

	public static int getLongestNonRepeatedSubstring(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		// map用来记录字符出现的最后一个位置
		Map<Character, Integer> map = new HashMap<>();

		int maxLength = 0;
		int left = 0;
		int right = 0;
		while (right < str.length()) {
			Character c = str.charAt(right);
			Integer index = map.get(c);
			// 如果为空，表示之前不存在重复字符
			// 如果不为空，则要判断字符的位置是否大于等于begin的位置，因为我们的区间是[begin，end）
			// 而我们进行窗口滑动时候，只是将begin移动到了重复字符之后，并没有在map中删除重复字符之前到所有元素
			// 所以，我们要判断重复的字符是否在我们有效的区间内
			if (index != null && index >= left) {
				left = index + 1;
			}

			maxLength = Math.max(maxLength, right - left + 1);

			map.put(c, right);
			right++;
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String str = "abcad";
		System.out.println(getLongestNonRepeatedSubstring(str));
	}

}
