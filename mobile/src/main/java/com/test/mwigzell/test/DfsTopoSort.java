package com.test.mwigzell.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Depth First Search based topological sort of a DAG
 */

public class DfsTopoSort {
    AdjacencyMatrixGraph graph;
    static final int TEMP = 1;
    static final int VISITED = 2;

    Map<Integer, Integer> marked;
    Stack<Integer> list;

    public DfsTopoSort(AdjacencyMatrixGraph graph) {
        this.graph = graph;
    }

    public List<Integer> sort() {
        marked = new HashMap<>();

        list = new Stack<>();
        for ( int v = 0; v < graph.V; v++) {
            visit(v);
        }

        return list;
    }

    private void visit(int u) {
        if (marked.containsKey(u)) {
            if (marked.get(u) == VISITED) {
                return;
            }
            if (marked.get(u) == TEMP) {
                throw new IllegalStateException("not a DAG");
            }
        }
        marked.put(u, TEMP);
        for(int v : graph.getNeighbors(u)) {
            visit(v);
        }
        list.push(u);
        marked.put(u, VISITED);
    }
}
