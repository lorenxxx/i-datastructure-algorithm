package com.us.improve.datastructure.graph;

import java.util.LinkedList;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-19 18:02
 * @Version 1.0
 **/
public class Graph {

	private boolean found = false;

	private int v;

	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int s, int t) {
		if (!this.adj[s].contains(t)) {
			this.adj[s].add(t);
		}
		if (!this.adj[t].contains(s)) {
			this.adj[t].add(s);
		}
	}

	public void dfs(int s, int t) {
		found = false;

		boolean[] visited = new boolean[v];

		int[] prev = new int[v];
		for (int i = 0; i < v; i++) {
			prev[i] = -1;
		}

		doDfs(s, t, visited, prev);
		print(prev, s, t);
	}

	private void doDfs(int w, int t, boolean[] visited, int[] prev) {
		if (found) {
			return;
		}

		visited[w] = true;
		if (w == t) {
			found = true;
			return;
		}

		for (int i = 0; i < adj[w].size(); i++) {
			int q = adj[w].get(i);
			if (!visited[q]) {
				prev[q] = w;
				doDfs(q, t, visited, prev);
			}
		}
	}

	private void print(int[] prev, int s, int t) {
		if (prev[t] != -1 && s != t) {
			print(prev, s, prev[t]);
		}
		System.out.println(t + "");
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 5);

		System.out.println();

		graph.dfs(0, 4);
	}

}
