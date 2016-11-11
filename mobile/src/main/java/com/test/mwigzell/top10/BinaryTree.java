package com.test.mwigzell.top10;

/**
 * Created by mark on 11/8/16.
 */

public class BinaryTree {
    public boolean isFull(Node tree) {
        boolean rc = false;

        if (tree == null ) {
            rc = true;
        } else {
            if ((tree.left != null && tree.right == null) || (tree.left == null && tree.right != null)) {
                rc = false;
            } else {
                // either they're both null or both not null: its a full node: recurse
                rc = isFull(tree.left);
                if (rc) {
                    rc = isFull(tree.right);
                }
            }
        }
        return rc;
    }
}
