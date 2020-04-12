package com.us.improve.leetcode.backtracking.queen8;

/**
 * @ClassName EightQueen2
 * @Desciption 8皇后问题：一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。回溯思想。
 * @Author loren
 * @Date 2020/4/12 2:45 PM
 * @Version 1.0
 **/
public class EightQueen2 {

    /**
     * 8位皇后
     */
    private static final int N = 8;

    /**
     * 结果数量
     */
    private int count = 0;

    /**
     * 核心函数
     *
     * @param chessboard 棋盘
     * @param row 当前考察行数
     */
    public void calEightQueen(int[][] chessboard, int row) {
        // 如果所有行的旗子都拜访好了，则打印结果
        if (row == N) {
            count++;
            System.out.println("Solution" + count + ": ");
            displayChessboard(chessboard);
            return;
        }

        // 针对每一行，都有8中放置方法，逐个考察
        for (int col = 0; col < N; col++) {
            // 如果chessboard[row][col]是安全的
            if (isSafe(chessboard, row, col)) {
                // 放置棋子
                chessboard[row][col] = 1;
                // 考察下一行
                calEightQueen(chessboard, row + 1);
                // 回溯
                chessboard[row][col] = 0;
            }
        }
    }

    /**
     * 判断当前位置是否可以放置皇后
     *
     * @param chessboard
     * @param row
     * @param col
     * @return
     */
    private boolean isSafe(int[][] chessboard, int row, int col) {
        // 检查正上位置
        for (int r = row - 1; r >= 0; r--) {
            if (chessboard[r][col] == 1) {
                return false;
            }
        }

        // 检查左上位置
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (chessboard[r][c] == 1) {
                return false;
            }
        }

        // 检查右上位置
        for (int r = row - 1, c = col + 1; r >= 0 && c < N; r--, c++) {
            if (chessboard[r][c] == 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 展示棋盘
     *
     * @param chessboard 棋盘
     */
    private void displayChessboard(int[][] chessboard) {
        if (chessboard == null) {
            return;
        }

        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                if (chessboard[i][j] == 1) {
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
        EightQueen2 eightQueen = new EightQueen2();

        int[][] chessboard = new int[N][N];
        eightQueen.calEightQueen(chessboard, 0);
    }

}
