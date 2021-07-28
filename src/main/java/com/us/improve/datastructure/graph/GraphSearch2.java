package com.us.improve.datastructure.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-25 19:23
 * @Version 1.0
 **/
public class GraphSearch2 {

	public void dfs(List<Integer>[] graph, int s, int t) {
		Map<Integer, Integer> visited = new HashMap<>();
		visited.put(s, null);

		doDfs(graph, visited, s, t);
	}

	private void doDfs(List<Integer>[] graph, Map<Integer, Integer> visited, int s, int t) {
		if (s == t) {
			// found
			// print
			return;
		}

		for (int i = 0; i < graph[s].size(); i++) {
			int next = graph[s].get(i);
			if (next != s && !visited.containsKey(next)) {
				visited.put(next, s);
				doDfs(graph, visited, i, t);
			}
		}
	}

}
