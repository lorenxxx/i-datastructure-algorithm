package com.us.improve.leetcode.backtracking.queen8;

import java.util.Arrays;

/**
 * @ClassName EightQueen
 * @Desciption 8皇后问题：一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。回溯思想。
 * @Author loren
 * @Date 2020/4/12 2:09 PM
 * @Version 1.0
 **/
public class EightQueen {

    /**
     * 下标表示行, 值表示queen存储在哪一列
     */
    private int[] result = new int[8];

    public void cal8Queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }

        // 每一行都有8中放法
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8Queens(row + 1);
            }
        }
    }

    /**
     * 判断row行column列放置是否合适
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;

        // 逐行往上考察每一行
        for (int i = row - 1; i >= 0; i--) {
            // 第i行的column列有棋子吗？
            if (result[i] == column) {
                return false;
            }
            // 考察左上对角线：第i行leftup列有棋子吗？
            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    return false;
                }
            }

            // 考察右上对角线：第i行rightup列有棋子吗？
            if (rightUp < 8) {
                if (result[i] == rightUp) {
                    return false;
                }
            }

            leftUp--;
            rightUp++;
        }

        return true;
    }

    private void printQueens(int[] result) {
        System.out.println(Arrays.toString(result));

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueen queen8 = new EightQueen();
        queen8.cal8Queens(0);
    }

}
