package com.us.improve.leetcode.string;

/**
 * @ClassName IsPalindrome
 * @Desciption
 * @Author loren
 * @Date 2020/4/8 2:54 PM
 * @Version 1.0
 **/
public class IsPalindrome {

	/**
	 * 问题描述
	 *
	 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
	 */


	/**
	 * 假设字符串无空格
	 */
	public static boolean isPalindrome1(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}

		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	/**
	 * 假设字符串有空格，且不考虑空格
	 */
	public static boolean isPalindrome2(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}

		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			while (!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			while (!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}

			if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public static void main(String[] args) {
		String s1 = "abA";
		System.out.println(isPalindrome1(s1));

		String s2 = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome2(s2));
	}

}
