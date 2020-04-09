package com.us.improve.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSums
 * @Desciption 两数之和
 * @Author loren
 * @Date 2020/4/6 5:24 PM
 * @Version 1.0
 **/
public class TwoSums {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (map.containsKey(expect)) {
                return new int[] {map.get(expect), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

}
