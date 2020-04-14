package com.us.improve.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName KingAndGoldMine
 * @Desciption 用动态规划求解国王与金矿的问题
 * @Author loren
 * @Date 2020/4/13 4:34 PM
 * @Version 1.0
 **/
public class KingAndGoldMine {

    /**
     * 递归解法
     *
     * @param n
     * @param w
     * @param g 数组g中存储每座金矿的金矿数
     * @param p 数组p中存储挖每座金矿需要的工人数
     * @return 该方法返回工人数为w时挖数组g中前n座金矿所能得到的最大金矿数
     */
    public static int getMaxGold(int n, int w, int[] g, int[] p) {
        if (n > g.length) {
            throw new RuntimeException("输入的n值大于给定的金矿数");
        }

        // 如果没有剩余的金矿了，则能获取到的金子数为0
        if (n == 0) {
            return 0;
        }

        // 如果只有一座金矿，且人数不足以开采这座金矿时，则能获取到的金子数为0
        if (n == 1 && w < p[0]) {
            return 0;
        }

        // 如果只剩一座金矿，且人数足以开采这座金矿时，则能获取到的金子数为g[0]
        if (n == 1 && w >= p[0]) {
            return g[0];
        }

        // 如果剩余金矿数量大于1，且剩余人数不足以开采第n座金矿，则排除掉第n座金矿，考虑前n-1座金矿
        if (n > 1 && w < p[n - 1]) {
            return getMaxGold(n - 1, w, g, p);
        }

        // 对于第n座金矿，考虑两种情况
        // 1：不开采这座金矿，剩余人数为 w ，能获得的最大金子数为 getMostGold(n - 1, w, g, p)
        // 2：开采这座金矿，剩余人数为 w - p[n - 1] ，能获得的最大金子数为 getMostGold(n - 1, w - p[n - 1], g, p) + g[n - 1]
        return Math.max(
                getMaxGold(n - 1, w, g, p),
                getMaxGold(n - 1, w - p[n - 1], g, p) + g[n - 1]
        );
    }

    /**
     * 递归 + 备忘录 解法
     * // TODO: 2020/4/14 备忘录
     *
     * @param n
     * @param w
     * @param g 数组g中存储每座金矿的金矿数
     * @param p 数组p中存储挖每座金矿需要的工人数
     * @return 该方法返回工人数为w时挖数组g中前n座金矿所能得到的最大金矿数
     */
    public static int getMaxGold2(int n, int w, int[] g, int[] p, Map<Input, Integer> map) {
        if (n > g.length) {
            throw new RuntimeException("输入的n值大于给定的金矿数");
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1 && w < p[0]) {
            return 0;
        }

        if (n == 1 && w >= p[0]) {
            return g[0];
        }

        if (n > 1 && w < p[n - 1]) {
            Input input = new Input(n - 1, w);
            if (map.containsKey(input)) {
                return map.get(input);
            }

            int value = getMaxGold2(n - 1, w, g, p, map);
            map.put(input, value);
            return value;
        }

        Input input1 = new Input(n - 1, w);
        Input input2 = new Input(n - 1, w - p[n - 1]);
        int value1 = 0;
        int value2 = 0;
        if (map.containsKey(input1)) {
            value1 = map.get(input1);
        } else {
            value1 = getMaxGold2(n - 1, w, g, p, map);
            map.put(input1, value1);
        }

        if (map.containsKey(input2)) {
            value2 = map.get(input2) + g[n - 1];
        } else {
            value2 = getMaxGold2(n - 1, w - p[n - 1], g, p, map);
            map.put(input2, value2);
            value2 += g[n - 1];
        }

        return Math.max(value1, value2);
    }

    private static class Input {
        private int n;
        private int w;

        public Input(int n, int w) {
            this.n = n;
            this.w = w;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + n;
            result = prime * result + w;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (!(obj instanceof Input)) {
                return false;
            }
            Input input = (Input) obj;
            if (this.n != input.n) {
                return false;
            }
            if (this.w != input.w) {
                return false;
            }
            return true;
        }
    }

    /**
     * 动态规划解法
     *
     * @param n
     * @param w
     * @param g 数组g中存储每座金矿的金子数
     * @param p 数组p中存储挖每座金矿需要的工人数
     * @return 该方法返回工人数为w时挖数组g中前n座金矿所能得到的最大金矿数
     */
    public static int getMaxGold3(int n, int w, int[] g, int[] p) {
        if (n > g.length) {
            throw new RuntimeException("输入的n值大于给定的金矿数");
        }

        if (w < 0) {
            throw new RuntimeException("输入的工人数w不能为负数");
        }

        // 如果没有金矿可挖了，或者没有工人数可用了，则能获取到的金子数为0
        if (n < 1 || w == 0) {
            return 0;
        }

        // 因为F(x,0)也要用到,所以表格应该有w+1列
        int col = w + 1;
        int[] preResult = new int[col];
        int[] result = new int[col];

        // 初始化边界
        // 这里是指，如果只有一座矿(金矿数组g的下标为0)，i为工人的数量
        for (int i = 0; i < col; i++) { // 逐个增加工人数量
            if (i < p[0]) { // 如果工人数量小于所需人数，则能获取到的金子数为0
                preResult[i] = 0;
            } else { //如果工人数量大于等于所需人数，因为只有一座矿可挖，则能获取到的金子数为g[0]
                preResult[i] = g[0];
            }
        }

        // 如果只有一座金矿，则返回用所有工人挖这座金矿能够获得的金子数量
        if (n == 1) {
            return preResult[w];
        }

        // 用preResult推出result，外循环控制递推的轮数，内循环进行递推
        // 这里的i指的金矿数组g的下标，逐个把每一个金矿都纳入考虑范围
        for (int i = 1; i < n; i++) {
            // 这里的j指的是工人的数量
            for (int j = 0; j < col; j++) {
                if (j < p[i]) { // 如果工人数量不足以开采数组下标为i这座矿，则得到的最大金子数 = 开采了前i-1座矿的最大金子数
                    result[j] = preResult[j];
                } else {
                    // 考虑两种情况：
                    // 1：如果不挖数组下标为i这座矿，得到的最大金子数量 = 挖数组下标为[0 ~ i-1]矿的最大金子数量
                    int result1 = preResult[j];
                    // 2：如果挖数组下标为i这座矿，则需要使用p[i]名工人，剩余w-p[i]名工人，则得到最大金子数 = preResult[j - p[i]] + g[i]
                    int result2 = preResult[j - p[i]] + g[i];
                    // 取两种情况的最大收益
                    result[j] = Math.max(result1, result2);
                }
            }

            for (int j = 0; j < col; j++) {
                preResult[j] = result[j];
            }
        }

        return result[w];
    }

    public static void main(String[] args) {
        int[] g = {400, 500, 200, 300, 350};
        int[] p = {5, 5, 3, 4, 3};
        System.out.println(getMaxGold(5, 10, g, p));
        System.out.println(getMaxGold2(5, 10, g, p, new HashMap<>()));
        System.out.println(getMaxGold3(5, 9, g, p));
    }

}
