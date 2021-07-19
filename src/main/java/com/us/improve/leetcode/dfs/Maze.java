package com.us.improve.leetcode.dfs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName Maze
 * @Desciption 用DFS求解迷宫问题
 * @Author loren
 * @Date 2020/4/14 8:39 PM
 * @Version 1.0
 **/
public class Maze {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    private static class Node {
        private int x;
        private int y;
    }

    /**
     * 迷宫
     * 1表示墙壁，0表示可以走的路
     */
    private int[][] maze = new int[][] {
            { 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 0 },
            { 0, 0, 0, 0, 0 },
            { 0, 1, 0, 1, 0 },
            { 0, 1, 0, 1, 0 }
    };

    /**
     * 记录位置是否被访问过
     */
    private int[][] visit = new int[5][5];

    /**
     * 上下左右移动的偏移量
     */
    private int[][] move = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };

    /**
     *
     */
    private Stack<Node> path = new Stack<>();

    public void findPath() {
        path.push(new Node(0, 0));
        visit[0][0] = 1;
        dfs(0, 0);
    }

    private void dfs(int x, int y) {
        if (x == 4 && y == 4) {
            System.out.println(Arrays.toString(path.toArray(new Node[path.size()])));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if (check(nx, ny)) {
                path.push(new Node(nx, ny));
                visit[nx][ny] = 1;

                dfs(nx, ny);

                // 回溯
                visit[nx][ny] = 0;
                path.pop();
            }
        }
    }

    private boolean check(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5 && visit[x][y] != 1 && maze[x][y] != 1;
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.findPath();
    }

}
