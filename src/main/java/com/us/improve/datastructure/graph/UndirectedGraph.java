package com.us.improve.datastructure.graph;

import java.util.LinkedList;

/**
 * @ClassName UndirectedGraph
 * @Desciption 无向图
 * @Author loren
 * @Date 2020/3/25 2:13 PM
 * @Version 1.0
 **/
public class UndirectedGraph {

    /**
     * 定点的个数
     */
    private int v;

    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adjacencyList;

    public UndirectedGraph(int v) {
        this.v = v;
        this.adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int s, int t) {
        adjacencyList[s].add(t);
        adjacencyList[t].add(s);
    }

}
