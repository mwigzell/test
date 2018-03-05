package com.test.mwigzell.geeks.backtracking;

/* Java program to solve Rat in a Maze problem using
   backtracking */


import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class RatMaze
{
    final int N = 4;

    /* A utility function to print solution matrix
       sol[N][N] */
    void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] +
                        " ");
            System.out.println();
        }
    }
    boolean isDestination(int[][] maze, int r, int c) {
        if (r == maze.length -1 && c == maze[c].length -1) {
            return true;
        }
        return false;
    }
    boolean isFree(int[][] maze, int r, int c) {
        if (r >= 0 && r < maze.length && c >= 0 && c < maze[r].length &&
                maze[r][c] == 1) {
            return true;
        }
        return false;
    }

    /* This function solves the Maze problem using
       Backtracking. It mainly uses solveMazeUtil()
       to solve the problem. It returns false if no
       path is possible, otherwise return true and
       prints the path in the form of 1s. Please note
       that there may be more than one solutions, this
       function prints one of the feasible solutions.*/
    boolean solveMaze(int maze[][])
    {
        int sol[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (solveMazeUtil(maze, 0, 0, sol) == false)
        {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    /* A recursive utility function to solve Maze
       problem */
    boolean solveMazeUtil(int maze[][], int r, int c, int sol[][]) {
        boolean rc = false;
        if (isFree(maze, r, c)) {
           if (isDestination(maze, r, c)) {
               rc = true;
           } else {
               Queue<Point> q = new LinkedList<>();
               q.add(new Point(r+1, c));
               q.add(new Point(r,c+1));
               while(!q.isEmpty() && rc == false) {
                   Point p = q.poll();
                   rc = solveMazeUtil(maze, p.x, p.y, sol);
               }
           }
        }
        if (rc) {
            sol[r][c] = 1;
        }
        return rc;
    }

    public static void main(String args[])
    {
        RatMaze rat = new RatMaze();
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        rat.solveMaze(maze);
    }
}

