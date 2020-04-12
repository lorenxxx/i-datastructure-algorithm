package com.us.improve.leetcode.others;

/**
 * @ClassName Test
 * @Desciption TODO
 * @Author loren
 * @Date 2020/4/11 3:40 PM
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        int res = 0;
        int[] nums = new int[] {4, 3, 2, 4, 3};
        for (int num : nums) {
            res = res ^ num;
        }
        System.out.println(res);
    }

}
