package com.us.improve.leetcode.dfs;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * @ClassName FindAvailablePath
 * @Desciption TODO
 * @Author loren
 * @Date 2020/6/4 7:28 PM
 * @Version 1.0
 **/
public class AvailablePathSearcher {

    private Map<String, List<String>> pathMap = new HashMap<>();

    private List<String> availablePath = new ArrayList<>();

    private String destination = null;

    public void buildPathMap(List<Position> positions) {
        if (CollectionUtils.isEmpty(positions)) {
            return;
        }

        for (Position position : positions) {
            pathMap.put(position.getPoint(), position.getAdjacencyPoints());
        }
    }

    public void search(String source, String destination) {
        this.destination = destination;
        dfs(source);
    }

    public void dfs(String point) {
        if (this.destination.equals(point)) {
            availablePath.add(point);
            System.out.println(availablePath);
            return;
        }

        availablePath.add(point);

        List<String> adjacencyPoints = pathMap.get(point);
        for (String adjacencyPoint : adjacencyPoints) {
            dfs(adjacencyPoint);

            availablePath.remove(availablePath.size() - 1);
        }
    }

    public static void main(String[] args) {
        Position pA = new Position("A", Lists.newArrayList("B", "C"));
        Position pB = new Position("B", Lists.newArrayList("D"));
        Position pC = new Position("C", Lists.newArrayList("D"));
        Position pD = new Position("D", Lists.newArrayList("E", "F"));
        Position pE = new Position("E", Lists.newArrayList());
        Position pF = new Position("F", Lists.newArrayList("G"));
        Position pG = new Position("G", Lists.newArrayList());

        List<Position> positions = Lists.newArrayList(pA, pB, pC, pD, pE, pF, pG);

        AvailablePathSearcher searcher = new AvailablePathSearcher();
        searcher.buildPathMap(positions);

        searcher.search("A", "G");
    }

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Position {

    private String point;

    private List<String> adjacencyPoints;

}
