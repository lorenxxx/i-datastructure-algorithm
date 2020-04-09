package com.us.improve.leetcode;

/**
 * @ClassName StringTool
 * @Desciption TODO
 * @Author loren
 * @Date 2020/4/7 4:04 PM
 * @Version 1.0
 **/
public class StringTool {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
     *
     * 说明：空字符串定义为有效的回文串
     *
     * @param str 字符串
     * @return true/false
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        if (str.length() == 0) {
            return true;
        }

        int head = 0;
        int tail = str.length() - 1;
        while (head < tail) {
            if (!Character.isLetterOrDigit(str.charAt(head))) {
                head++;
            } else if (!Character.isLetterOrDigit(str.charAt(tail))) {
                tail--;
            } else {
                if (Character.toLowerCase(str.charAt(head)) != Character.toLowerCase(str.charAt(tail))) {
                    return false;
                } else {
                    head++;
                    tail--;
                }
            }
        }

        return true;
    }

    /**
     * 给定一个字符串，验证它是否是回文串
     *
     * @param str
     * @param left
     * @param right
     * @return
     */
    public static boolean isPalindrome(String str, int left, int right) {
        while (left < right && str.charAt(left) == str.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

    /**
     * 反转字符串
     *
     * @param str
     * @return
     */
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        char[] charArray = str.toCharArray();
        int low = 0;
        int high = charArray.length - 1;
        while (low < high) {
            char tmp = charArray[low];
            charArray[low] = charArray[high];
            charArray[high] = tmp;

            low++;
            high--;
        }

        return new String(charArray);
    }

    /**
     * 将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0
     *
     * @param str
     * @return
     */
    public static int str2Int(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean isNegative = str.charAt(0) == '-';
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c < '0' || c > '9') {
                return 0;
            }
            result = result * 10 + (c - '0');
        }

        return isNegative ? -result : result;
    }



    public static void main(String[] args) {
        System.out.println("回文判断: ");
        System.out.println(isPalindrome(null));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("level"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println();

        System.out.println("反转字符串: ");
        System.out.println(reverseString(null));
        System.out.println(reverseString(""));
        System.out.println(reverseString("i"));
        System.out.println(reverseString("hello"));
        System.out.println();

        System.out.println("字符串转换成整数: ");
        System.out.println(str2Int("9"));
        System.out.println(str2Int("-99"));
        System.out.println(str2Int("+99"));

        System.out.println("hello".substring(0, 1));
    }

}
