package com.test.mwigzell.test.top10;

import com.test.mwigzell.top10.ConvertTreeToDLL;
import com.test.mwigzell.top10.Node;

import org.junit.Test;

/**
 * Created by mark on 11/10/16.
 */

public class ConvertTreeToDLLTest {
    @Test
    public void test()
    {
        // Build the tree
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        // head refers to the head of the Link List
        ConvertTreeToDLL tree = new ConvertTreeToDLL();
        Node head = tree.convert(root);

        // Display the Circular LinkedList
        tree.display(head);
    }
}
