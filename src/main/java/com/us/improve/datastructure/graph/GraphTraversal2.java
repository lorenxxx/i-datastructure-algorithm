package com.us.improve.datastructure.graph;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author loren
 * @Description 图的遍历（邻接表）
 * @Date 2021-07-25 18:54
 * @Version 1.0
 **/
public class GraphTraversal2 {

	/**
	 * dfs遍历
	 *
	 * @param graph 图 邻接表
	 * @param node  起点
	 */
	public void dfs(List<Integer>[] graph, int node) {
		int[] visited = new int[graph.length];

		doDfs(graph, visited, node);
	}

	private void doDfs(List<Integer>[] graph, int[] visited, int node) {
		visited[node] = 1;

		System.out.println(node);

		for (int i = 0; i < graph[node].size(); i++) {
			int next = graph[node].get(i);
			if (next != node && visited[next] == 0) {
				doDfs(graph, visited, next);
			}
		}
	}

	/**
	 * bsf遍历
	 *
	 * @param graph 图 邻接表
	 * @param node 起点
	 */
	public void bfs(List<Integer>[] graph, int node) {
		int[] queue = new int[graph.length];
		queue[0] = node;

		int cnt = 1;

		int[] visited = new int[graph.length];
		visited[node] = 1;

		System.out.println(node);

		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < graph[queue[i]].size(); j++) {
				int next = graph[queue[i]].get(j);
				if (next != queue[i] && visited[next] == 0) {
					queue[cnt++] = next;
					visited[next] = 1;

					System.out.println(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<Integer>[] graph = new List[] {
				Lists.newArrayList(2, 3),
				Lists.newArrayList(2),
				Lists.newArrayList(0, 1),
				Lists.newArrayList(2, 4),
				Lists.newArrayList(3, 5),
				Lists.newArrayList(4),
		};

		GraphTraversal2 traversal = new GraphTraversal2();

		traversal.dfs(graph, 0);

		System.out.println("-------------");

		traversal.bfs(graph, 0);
	}


}
