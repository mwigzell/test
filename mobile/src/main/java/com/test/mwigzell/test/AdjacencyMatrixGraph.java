package com.test.mwigzell.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark on 2/17/18.
 */

//Class to represent a graph
public class AdjacencyMatrixGraph
{
    int V;// No. of vertices

    //An Array of List which contains
    //references to the Adjacency List of
    //each vertex
    List<Integer> adj[];
    public AdjacencyMatrixGraph(int V)// Constructor
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++)
            adj[i]=new ArrayList<Integer>();
    }

    // function to add an edge to graph
    public void addEdge(int u,int v)
    {
        adj[u].add(v);
    }

    public List<Integer>[] getMatrix() { return adj; }

    public List<Integer> getNeighbors(int u) {
        List<Integer> neighbors = new ArrayList<>();
        for (int v = 0; v < adj[u].size(); v++) {
            neighbors.add(adj[u].get(v));
        }
        return neighbors;
    }
}
