package com.test.mwigzell.test.cracking;

import com.test.mwigzell.cracking.MinimalTree;
import com.test.mwigzell.top10.Node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by mwigzell on 11/22/16.
 */

public class MinimalTreeTest {
    @Test
    public void test() {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        MinimalTree tree = new MinimalTree();
        Node root = tree.build(array);

        assertNotNull(root);
        tree.print();
        int height = tree.height();
        assertEquals(3, height);
        System.out.println("Height of tree = " + height);
        tree.printLevels();

        assertTrue(tree.isBalanced(root));
        assertTrue(tree.isBST(root));

        ArrayList<LinkedList<Integer>> sequences = tree.bstSequence(root);
        System.out.println("#sequences=" + sequences.size());
        for (LinkedList<Integer> s : sequences) {
            for (Integer i : s) {
                System.out.print(String.format("%d ", i));
            }
            System.out.println();
        }
    }
}
