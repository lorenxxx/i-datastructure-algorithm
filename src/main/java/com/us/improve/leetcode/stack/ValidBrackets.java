package com.us.improve.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName ValidString
 * @Desciption 有效的括号
 * @Author loren
 * @Date 2020/4/16 1:52 PM
 * @Version 1.0
 **/
public class ValidBrackets {

    /**
     * 问题描述
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     */

    /**
     * 使用栈处理
     */

    public static boolean isValidBrackets(String str) {
        if (str == null || str.length() <= 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if (stack.size() == 0) {
                stack.push(c);
            } else if (isSym(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size() == 0;
    }

    private static boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }

    public static void main(String[] args) {
        String str1 = "[{()}]()";
        String str2 = "[{()}()";
        System.out.println(isValidBrackets(str1));
        System.out.println(isValidBrackets(str2));
    }

}
