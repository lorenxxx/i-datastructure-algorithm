package com.us.improve.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author loren
 * @Description TODO
 * @Date 2021-07-22 17:42
 * @Version 1.0
 **/
public class FindAllPath {

	private LinkedList<Integer>[] graph;

	public List<List<Integer>> findAllPath() {
		List<List<Integer>> ret = new ArrayList<>();

		return null;
	}

	private void bfs(int s, int t) {
		if (s == t) {
			return;
		}

		List<Integer> path = new ArrayList<>();

		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);

		while (queue.size() != 0) {
			int w = queue.poll();
			for (int i = 0; i < graph[w].size(); i++) {
				int q = graph[w].get(i);
				if (q == t) {

				}
			}
		}

	}

}
