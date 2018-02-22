package com.test.mwigzell.test.test;

import com.test.mwigzell.test.AdjacencyMatrixGraph;
import com.test.mwigzell.test.DfsTopoSort;
import com.test.mwigzell.test.KahnTopoSort;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * Created by mark on 2/17/18.
 */

public class TopologicalSortTest {
    AdjacencyMatrixGraph g;

    @Before
    public void setup() {
        g=new AdjacencyMatrixGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
    }

    private void print(List<Integer> list) {
        if (list == null || list.size() == 0) {
            System.out.println("graph is not a DAG");
        } else {
            System.out.println("Following is a Topological Sort");
            if (!(list instanceof Stack)) {
                list.forEach(k -> {
                    System.out.print(k + " ");
                });
            } else {
                while(!list.isEmpty()) {
                    System.out.print(((Stack)list).pop() + " ");
                }
            }
        }
    }

    @Test
    public void kahnSort() {
        KahnTopoSort kahn = new KahnTopoSort(g);
        print(kahn.sort());
    }

    @Test
    public void kahnSortNotDAG() {
        g.addEdge(2, 5);
        KahnTopoSort kahn = new KahnTopoSort(g);
        print(kahn.sort());
    }

    @Test
    public void DfsSort() {
        DfsTopoSort dfs = new DfsTopoSort(g);
        print(dfs.sort());
    }
}
