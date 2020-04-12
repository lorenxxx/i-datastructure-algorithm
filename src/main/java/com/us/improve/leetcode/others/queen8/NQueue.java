package com.us.improve.leetcode.others.queen8;

/**
 * @ClassName NQueue
 * @Desciption N皇后问题
 * @Author loren
 * @Date 2020/4/12 3:58 PM
 * @Version 1.0
 **/
public class NQueue {

    /**
     * N个皇后
     */
    private int n;

    /**
     * 解法数量
     */
    private int count;

    public NQueue(int n) {
        this.n = n;
        this.count = 0;
    }

    public void calNQueen(int[][] chessboard, int row) {
        if (row == n) {
            count++;
            System.out.println("Solution" + count + ": ");
            printChessBoard(chessboard);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(chessboard, row, col)) {
                chessboard[row][col] = 1;
                calNQueen(chessboard, row + 1);
                chessboard[row][col] = 0;
            }
        }
    }

    public boolean isSafe(int[][] chessboard, int row, int col) {
        if (chessboard == null) {
            return false;
        }

        // 检查正上
        for (int r = row - 1; r >= 0; r--) {
            if (chessboard[r][col] == 1) {
                return false;
            }
        }

        // 检查左上
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (chessboard[r][c] == 1) {
                return false;
            }
        }

        // 检查右上
        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if (chessboard[r][c] == 1) {
                return false;
            }
        }

        return true;
    }

    public void printChessBoard(int[][] chessboard) {
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
        int n = 9;
        NQueue nQueue = new NQueue(n);
        int[][] chessboard = new int[n][n];
        nQueue.calNQueen(chessboard, 0);
    }

}
