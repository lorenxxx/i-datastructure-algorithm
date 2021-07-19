package com.us.improve.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-17 00:03
 * @Version 1.0
 **/
public class UndirectedGraph2 {

	private Map<String, List<String>> adjacency;

	public UndirectedGraph2() {
		this.adjacency = new HashMap();
	}

	public void addEdge(String source, String target) {
		doAddEdge(source, target);
		doAddEdge(target, source);
	}

	private void doAddEdge(String source, String target) {
		List<String> list = adjacency.get(source);
		if (list != null) {
			list.add(target);
		} else {
			list = new ArrayList<>();
			list.add(target);

			adjacency.put(source, list);
		}
	}

	public void display() {
		Iterator<Map.Entry<String, List<String>>> iterator = this.adjacency.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, List<String>> entry = iterator.next();
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
	}

	public void bfs(String source, String target) {
		if (source.equals(target)) {
			return;
		}

		Queue<String> queue = new LinkedList<>();
		queue.add(source);

		Map<String, String> visitedMap = new HashMap<>();
		visitedMap.put(source, null);

		while (queue.size() != 0) {
			String cur = queue.poll();
			List<String> curAdjacency = adjacency.get(cur);
			if (curAdjacency != null) {
				for (String item : curAdjacency) {
					if (!visitedMap.containsKey(item)) {
						visitedMap.put(item, cur);
						if (item.equals(target)) {
							printPath(visitedMap, source, target);
							return;
						}
						queue.add(item);
					}
				}
			}
		}
	}

	public void printPath(Map<String, String> visited, String source, String target) {
		if (!source.equals(target) && visited.get(target) != null) {
			printPath(visited, source, visited.get(target));
		}
		System.out.print(target + " ");
	}

	public static void main(String[] args) {
		UndirectedGraph2 graph = new UndirectedGraph2();
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");
		graph.addEdge("C", "E");
		graph.addEdge("D", "E");
		graph.addEdge("D", "F");

		graph.display();

		graph.bfs("A", "D");
	}

}
