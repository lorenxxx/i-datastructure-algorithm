package com.us.improve.datastructure.graph;

/**
 * @Author loren
 * @Description 图的遍历（邻接矩阵）
 * @Date 2021-07-25 18:28
 * @Version 1.0
 **/
public class GraphTraversal1 {

	/**
	 * dfs遍历
	 *
	 * @param graph 图 邻接矩阵
	 * @param node  起点
	 */
	public void dfs(int[][] graph, int node) {
		int[] visited = new int[graph.length];

		doDfs(graph, visited, node);
	}

	private void doDfs(int[][] graph, int[] visited, int node) {
		visited[node] = 1;

		System.out.println(node);

		for (int i = 0; i < graph[node].length; i++) {
			if (i != node && visited[i] == 0 && graph[node][i] == 1) {
				doDfs(graph, visited, i);
			}
		}
	}

	/**
	 * bsf遍历
	 *
	 * @param graph 图 邻接矩阵
	 * @param node 起点
	 */
	public void bfs(int[][] graph, int node) {
		int[] queue = new int[graph.length];
		queue[0] = node;

		int cnt = 1;

		int[] visited = new int[graph.length];
		visited[node] = 1;

		System.out.println(node);

		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < graph[queue[i]].length; j++) {
				if (queue[i] != j && visited[j] == 0 && graph[queue[i]][j] == 1) {
					queue[cnt++] = j;
					visited[j] = 1;

					System.out.println(j);
				}
			}
		}

	}

	public static void main(String[] args) {
		int[][] graph = new int[][] {
				{ 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0 }
		};

		GraphTraversal1 traversal = new GraphTraversal1();

		traversal.dfs(graph, 0);

		System.out.println("-------------");

		traversal.bfs(graph, 0);
	}

}
