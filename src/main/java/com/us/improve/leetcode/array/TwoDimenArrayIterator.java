package com.us.improve.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName TwoDimenArrayIterator
 * @Desciption 二维数组遍历
 * @Author loren
 * @Date 2020/4/24 7:36 PM
 * @Version 1.0
 **/
public class TwoDimenArrayIterator {

    /**
     * 问题描述
     *
     * 编写一个二维数组迭代器，包含两个方法
     * 1 hasNext()
     * 2 next()
     */

    /**
     * 解题思路
     *
     */

    public static void main(String[] args) {
        Integer[][] arr = {{1, 2, 3}, {4, 5}, {}, {}, {6, 7}};

        Iterator iterator = new Iterator(arr);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static class Iterator {

        private List<List<Integer>> data;

        private int row;

        private int col;

        public Iterator(List<List<Integer>> data) {
            this.data = data;
            this.row = 0;
            this.col = 0;
        }

        public Iterator(Integer[][] arr) {
            if (arr == null) {
                throw new RuntimeException("empty arr...");
            }

            this.data = new ArrayList<>();
            for (Integer[] item : arr) {
                List<Integer> list = Arrays.asList(item);
                this.data.add(list);
            }

            this.row = 0;
            this.col = 0;
        }

        public boolean hasNext() {
            for (int i = this.row; i < data.size(); i++) {
                for ( int j = this.col; j <= data.get(i).size(); j++) {
                    if (j == data.get(i).size()) {
                        this.col = 0;
                        break;
                    }

                    if (data.get(i).get(j) != null) {
                        this.row = i;
                        this.col = j;
                        return true;
                    }

                }
            }

            return false;
        }

        public Integer next() {
            Integer ret = this.data.get(this.row).get(this.col);
            this.col++;
            return ret;
        }

    }

}


