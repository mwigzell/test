package com.test.mwigzell.cracking;

import com.test.mwigzell.top10.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by mwigzell on 11/22/16.
 */

public class MinimalTree {
    Node root;
    int weaveCounter = 0;

    Node buildHelper(int[] array, int low, int high) {
        int middle = low + (high - low)/2;
        Node root = new Node(array[middle]);
        if (low < middle) {
            root.left = buildHelper(array, low, middle - 1);
        }
        if ((middle) < high) {
            root.right = buildHelper(array, middle + 1, high);
        }
        return root;
    }

    public Node build(int[] array) {
        root = buildHelper(array, 0, array.length-1);
        return root;
    }

    void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.print(String.format("%d ", node.data));
        print(node.right);
    }

    public void print() {
        print(root);
        System.out.println();
    }

    int height(Node node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int height() {
        return height(root);
    }

    public void printLevels() {
        HashMap<Integer, LinkedList<Node>> depths = getDepths();
        for (int i = 0; i < depths.size(); i++) {
            LinkedList<Node> list = depths.get(i);
            for (Node node : list) {
                System.out.print(String.format("%d ", node.data));
            }
            System.out.println();
        }
    }

    void getDepths(Node root, HashMap<Integer, LinkedList<Node>> depths, int depth) {
        if (root == null) {
            return;
        }
        LinkedList<Node> list = depths.get(depth);
        if (list == null) {
            list = new LinkedList();
            depths.put(depth, list);
        }
        list.add(root);
        getDepths(root.left, depths, depth + 1);
        getDepths(root.right, depths, depth + 1);
    }

    public HashMap<Integer, LinkedList<Node>> getDepths() {
        HashMap<Integer, LinkedList<Node>> depths = new HashMap();
        getDepths(root, depths, 0);
        return depths;
    }

    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if ( Math.abs(leftHeight - rightHeight) > 1 ) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    boolean isBST(Node n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max) ) {
            return false;
        }
        if (!isBST(n.left, min, n.data) || !isBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

    public boolean isBST(Node root) {
        if (root == null) {
            return true;
        }
        return isBST(root, null, null);
    }

    void weavelists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        // one list is empty. Add remainder to a cloned prefix and store result
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        // recurse with head of first added to the prefix. Removing the head will damage
        // first, so we'll need to put it back where we found it afterwards
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weavelists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        // do the same thing with the second, damaging and then restoring the list
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weavelists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public ArrayList<LinkedList<Integer>> bstSequence(Node root) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if (root == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.data);

        ArrayList<LinkedList<Integer>> leftSeq = bstSequence(root.left);
        ArrayList<LinkedList<Integer>> rightSeq = bstSequence(root.right);

        for(LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weavelists(left, right, weaved, prefix);
                weaveCounter++;
                result.addAll(weaved);
            }
        }
        System.out.println("WeaveCounter=" + weaveCounter);
        return result;
    }
}
