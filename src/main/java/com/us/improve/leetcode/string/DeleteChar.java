package com.us.improve.leetcode.string;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-09 20:44
 * @Version 1.0
 **/
public class DeleteChar {

	/**
	 * 写一个函数实现从字符串中删除任意给出的字符
	 */
	public static String deleteChar1(String str, char c) {
		if (str == null || str.length() == 0) {
			return str;
		}

		String tmp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != c) {
				tmp += str.charAt(i);
			}
		}

		return tmp;
	}

	public static String deleteChar2(String str, char c) {
		if (str == null || str.length() == 0) {
			return str;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != c) {
				sb.append(str.charAt(i));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String str1 = "hello";
		System.out.println(deleteChar1(str1, 'l'));

		String str2 = "world";
		System.out.println(deleteChar2(str2, 'l'));
	}

}
