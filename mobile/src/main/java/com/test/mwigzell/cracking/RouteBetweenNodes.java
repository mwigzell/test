package com.test.mwigzell.cracking;

import com.test.mwigzell.vogella.Edge;
import com.test.mwigzell.vogella.Graph;
import com.test.mwigzell.vogella.Vertex;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by mwigzell on 11/22/16.
 */

public class RouteBetweenNodes {
    HashSet<Vertex> visited;
    HashMap<Vertex, Vertex> predecessors;
    LinkedList<Vertex> unvisited;
    Graph graph;

    public RouteBetweenNodes(Graph graph) {
        this.graph = graph;
    }

    void findNeighbours(Vertex node) {
        for (Edge edge : graph.getEdges()) {
            if (edge.getSource() == node) {
                Vertex neighbour = edge.getDestination();
                if (!visited.contains(neighbour)) {
                    unvisited.add(neighbour);
                    predecessors.put(neighbour, node);
                }
            }
        }
    }

    /**
     * check if there is a route betwen nodes
     * @param a
     * @param b
     * @return true if a route is found, else false
     */
    public boolean execute(Vertex a, Vertex b) {
        boolean rc = false;
        visited = new HashSet();
        predecessors = new HashMap();
        unvisited = new LinkedList();

        unvisited.add(a);
        while(!unvisited.isEmpty()) {
            Vertex node = unvisited.removeFirst();
            visited.add(node);
            if (node == b) {
                rc = true;
                break;
            }
            findNeighbours(node);
        }

        return rc;
    }

    public LinkedList<Vertex> getPath(Vertex node) {
        Vertex step;
        if ((step = predecessors.get(node)) == null) {
            return null;
        }
        LinkedList<Vertex> path = new LinkedList();
        path.add(node);
        path.add(step);
        while((step = predecessors.get(step)) != null) {
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
}
