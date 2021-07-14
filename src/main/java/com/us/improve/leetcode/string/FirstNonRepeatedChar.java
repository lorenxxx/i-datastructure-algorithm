package com.us.improve.leetcode.string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-09 21:08
 * @Version 1.0
 **/
public class FirstNonRepeatedChar {

	/**
	 * 问题描述
	 *
	 * 从一个字符串中找出第一个非重复的字符
	 */

	public static Character firstNonRepeatedChar1(String str) {
		if (str == null) {
			return null;
		}

		if (str.length() == 1) {
			return str.charAt(0);
		}

		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), map.containsKey(str.charAt(i)) ? map.get(str.charAt(i)) + 1 : 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		return null;
	}

	public static Character firstNonRepeatedChar2(String str) {
		Set<Character> repeats = new HashSet<>();
		Set<Character> noRepeats = new LinkedHashSet<>();

		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (repeats.contains(c)) {
				continue;
			}

			if (noRepeats.contains(c)) {
				noRepeats.remove(c);
				repeats.add(c);
			} else {
				noRepeats.add(c);
			}
		}

		for (Character noRepeat : noRepeats) {
			return noRepeat;
		}

		return null;
	}

	public static void main(String[] args) {
		String str1 = "hello";
		System.out.println(firstNonRepeatedChar1(str1));

		String str2 = "oops";
		System.out.println(firstNonRepeatedChar2(str2));
	}

}
