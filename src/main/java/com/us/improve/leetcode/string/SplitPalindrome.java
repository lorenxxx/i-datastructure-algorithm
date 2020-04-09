package com.us.improve.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpliPalindrome
 * @Desciption 分割回文串：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 * @Author loren
 * @Date 2020/4/8 2:33 PM
 * @Version 1.0
 **/
public class SplitPalindrome {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> split(String str) {
        if (str == null || str.length() == 0) {
            return res;
        }

        dfs(str,0, new ArrayList<>());

        return res;
    }

    private void dfs(String str, int left, List<String> partition) {
        // 判断终止条件
        if (left == str.length()) {
            // 添加到结果集中
            res.add(new ArrayList<>(partition));
            return;
        }

        // 从left开始，依次判断left->right是不是回文串
        for (int right = left; right < str.length(); right++) {
            // 判断是否是回文串
            if (isPalindrome(str, left, right)) {
                // 添加当前回文串到list中
                partition.add(str.substring(left, right + 1));
                // 从right + 1开始继续递归，寻找回文串
                dfs(str,right + 1, partition);
                // 回溯，寻找更长的回文串
                partition.remove(partition.size() - 1);
            }
        }
    }

    /**
     * 判断是否是回文串
     *
     * @param str
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(String str, int left, int right) {
        while (left < right && str.charAt(left) == str.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

    public static void main(String[] args) {
        String str = "aacc";

        SplitPalindrome splitPalindrome = new SplitPalindrome();
        List<List<String>> res = splitPalindrome.split(str);
        System.out.println(res);
    }

}
