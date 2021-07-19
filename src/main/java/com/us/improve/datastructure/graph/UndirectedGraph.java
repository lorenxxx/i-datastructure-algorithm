package com.us.improve.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName UndirectedGraph
 * @Desciption 无向图
 * @Author loren
 * @Date 2020/3/25 2:13 PM
 * @Version 1.0
 **/
public class UndirectedGraph {

    private int v;

    private LinkedList<Integer> adj[];

    public UndirectedGraph(int v) {
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

    public void display() {
        for (int i = 0; i < adj.length; i++) {
            System.out.println(i + " -> " + adj[i]);
        }
    }

    /**
     * 搜索起点s到终点t的路径，并打印
     *
     * @param s 起点
     * @param t 终点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }

        boolean[] visited = new boolean[this.v];
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int[] prev = new int[this.v];
        for (int i = 0; i < this.v; i++) {
            prev[i]= -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < this.adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
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
        UndirectedGraph graph = new UndirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);

        graph.display();

        System.out.println();

        graph.bfs(0, 4);
    }

}
