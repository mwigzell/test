package com.test.mwigzell.test.geeks;

import com.test.mwigzell.geeks.graph.Bfs;

import org.junit.Test;

/**
 * Created by mark on 2/25/18.
 */

public class BfsTest {
    @Test
    public void test()
    {
        Bfs g = new Bfs(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);
    }
}
