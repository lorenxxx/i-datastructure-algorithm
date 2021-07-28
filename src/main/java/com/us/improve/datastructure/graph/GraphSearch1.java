package com.us.improve.datastructure.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author loren
 * @Description 图的搜索（邻接矩阵）
 * @Date 2021-07-25 19:22
 * @Version 1.0
 **/
public class GraphSearch1 {

	/**
	 * dfs搜索
	 *
	 * @param graph 图 邻接矩阵
	 * @param s     起点
	 * @param t     起点
	 */
	public void dfs(int[][] graph, int s, int t) {
		Map<Integer, Integer> visited = new HashMap<>();
		visited.put(s, null);

		doDfs(graph, visited, s, t);
	}

	private void doDfs(int[][] graph, Map<Integer, Integer> visited, int s, int t) {
		if (s == t) {
			// found
			// print visited
			return;
		}

		for (int i = 0; i < graph[s].length; i++) {
			if (i != s && !visited.containsKey(i) && graph[s][i] == 1) {
				visited.put(i, s);
				doDfs(graph, visited, i, t);
			}
		}
	}

	public void bfs(int[][] graph, int s, int t) {
		int[] queue = new int[graph.length];
		queue[0] = s;

		int cnt = 1;

		Map<Integer, Integer> visited = new HashMap<>();
		visited.put(s, null);

		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < graph[queue[i]].length; j++) {
				if (queue[i] != j && !visited.containsKey(j) && graph[queue[i]][j] == 1) {
					queue[cnt++] = j;
					visited.put(j, queue[i]);

					if (j == t) {
						// found
						// print visited
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] {
				{ 0, 1, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0 }
		};

		GraphSearch1 search = new GraphSearch1();
		search.dfs(graph, 0, 5);

		System.out.println("-------------");

		search.bfs(graph, 0, 5);
	}

}
