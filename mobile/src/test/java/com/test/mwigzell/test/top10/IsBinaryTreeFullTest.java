package com.test.mwigzell.test.top10;

import org.junit.Test;

import com.test.mwigzell.top10.IsBinaryTreeFull;
import com.test.mwigzell.top10.Node;

/**
 * Created by mark on 11/8/16.
 */

public class IsBinaryTreeFullTest {
    @Test
    public void testIsFull()
    {
        IsBinaryTreeFull tree = new IsBinaryTreeFull();
        Node root;
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(40);
        root.left.left = new Node(50);
        root.right.left = new Node(60);
        root.left.left.left = new Node(80);
        root.right.right = new Node(70);
        root.left.left.right = new Node(90);
        root.left.right.left = new Node(80);
        root.left.right.right = new Node(90);
        root.right.left.left = new Node(80);
        root.right.left.right = new Node(90);
        root.right.right.left = new Node(80);
        root.right.right.right = new Node(90);

        if(tree.isFull(root))
            System.out.print("The binary tree is full");
        else
            System.out.print("The binary tree is not full");
    }
}
