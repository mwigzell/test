package com.test.mwigzell.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by mark on 2/17/18.
 */

public class KahnTopoSort {
    AdjacencyMatrixGraph graph;
    int[] inDegree; // # incoming edges per node
    Queue<Integer> zeroIn;

    public KahnTopoSort(AdjacencyMatrixGraph graph) {
        this.graph = graph;
    }

    private void countInDegree() {
        inDegree = new int[graph.V];
        List<Integer>[] matrix = graph.getMatrix();
        for (int u = 0; u < graph.V; u++) {
            for (int v = 0; v < matrix[u].size(); v++) {
                inDegree[matrix[u].get(v)]++;
            }
        }
    }

    private void buildZeroIn() {
        zeroIn = new LinkedList<Integer>();
        for (int s = 0; s < inDegree.length; s++) {
            if (inDegree[s] == 0) {
                zeroIn.add(s);
            }
        }
    }

    private List<Integer> getNeighbors(int u) {
        List<Integer> neighbors = new ArrayList<>();
        List<Integer>[] matrix = graph.getMatrix();

        for (int v = 0; v < matrix[u].size(); v++) {
            neighbors.add(matrix[u].get(v));
        }

        return neighbors;
    }

    public List<Integer> sort() {
        List<Integer> list = new ArrayList<>();
        countInDegree();
        buildZeroIn();

        while (!zeroIn.isEmpty()) {
            int u = zeroIn.remove();
            list.add(u);

            List<Integer> neighbors = getNeighbors(u);
            for (int v : neighbors) {
                if (--inDegree[v] == 0) {
                    zeroIn.add(v);
                }
            }
        }

        if (list.size() != graph.V) {
            return null;
        }

        return list;
    }
}
