package com.us.improve.leetcode.string;

/**
 * @ClassName String2Int
 * @Desciption TODO
 * @Author loren
 * @Date 2020/4/8 2:54 PM
 * @Version 1.0
 **/
public class String2Int {

	public static int convert(String str) {
		if (str == null || str.length() == 0) {
			throw new RuntimeException("invalid input");
		}

		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			int tmp = str.charAt(i) - '0';
			num = num * 10 + tmp;
		}

		return num;
	}

	public static void main(String[] args) {
		String str = "12345";
		System.out.println(convert(str));
	}

}
