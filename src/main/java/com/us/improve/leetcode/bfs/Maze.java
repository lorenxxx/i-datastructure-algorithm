package com.us.improve.leetcode.bfs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Maze
 * @Desciption 用BFS求解迷宫问题
 * @Author loren
 * @Date 2020/4/14 7:15 PM
 * @Version 1.0
 **/
public class Maze {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    private static class Node {
        private int x;
        private int y;
        private Node pre;
    }

    /**
     * 迷宫
     * 1表示墙壁，0表示可以走的路
     */
    private int[][] maze = new int[][] {
            {0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0}
    };

    /**
     * 记录位置是否被访问过
     */
    private int[][] visit = new int[5][5];

    /**
     * 上下左右移动的偏移量
     */
    private int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    /**
     * 路径
     */
    private Node[] q = new Node[25];

    public void bfs() {
        // 因为需要打印，这里用数组模拟队列
        int head = 0;
        int tail = 0;
        q[tail++] = new Node(0, 0, null);

        visit[0][0] = 1;

        while (true) {
            // 是否找到终点
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nx = q[head].getX() + move[i][0];
                int ny = q[head].getY() + move[i][1];
                if (check(nx, ny)) {
                    q[tail++] = new Node(nx, ny, q[head]);
                    visit[nx][ny] = 1;
                }

                if (nx == 4 && ny == 4) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                print(q[tail - 1]);
                break;
            }

            head++;
        }

    }

    private boolean check(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5 && visit[x][y] != 1 && maze[x][y] != 1;
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        print(node.getPre());
        System.out.println("(" + node.x + ", " + node.y + ")");
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.bfs();
    }


}
