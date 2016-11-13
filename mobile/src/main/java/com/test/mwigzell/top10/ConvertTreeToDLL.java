package com.test.mwigzell.top10;

/**
 * Created by mark on 11/10/16.
 */

public class ConvertTreeToDLL {

    Node concatenate(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node leftLast = left.left;
        Node rightLast = right.left;

        leftLast.right = right;
        right.left = leftLast;

        rightLast.right = left;
        left.left = rightLast;

        return left;
    }

    public Node convert(Node root) {
        if (root == null) {
            return null;
        }

        Node left = convert(root.left);
        Node right = convert(root.right);

        root.left = root.right = root;

        return concatenate(concatenate(left, root), right);
    }

    // Display Circular Link List
    public void display(Node head)
    {
        System.out.println("Circular Linked List is :");
        Node itr = head;
        do {
            System.out.print(itr.data + " " );
            itr = itr.right;
        } while (itr != head);
        System.out.println();
    }
}
