package com.us.improve.leetcode.bfs;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-15 23:22
 * @Version 1.0
 **/
public class BFS {

	private static int[][] graph = new int[][] {
			{0, 0, 1, 1, 0, 0},
			{0, 0, 1, 0, 0, 0},
			{1, 1, 0, 0, 0, 0},
			{0, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 1},
			{0, 0, 0, 0, 1, 0}
	};

	private int[] visited = new int[graph.length];

	public void bfs(int[][] graph) {
		int[] queue = new int[graph.length];
		int cnt = 1;

		queue[0] = 0;
		visited[0] = 1;
		System.out.println(0);
		for (int i = 0; i < cnt; ++i) {
			for (int j = 0; j < graph[queue[i]].length; ++j) {
				if (queue[i] != j && graph[queue[i]][j] == 1 && visited[j] == 0) {
					visited[queue[i]] = 1;
					queue[cnt++] = j;
					System.out.println(j);
				}
			}
		}
	}

}
