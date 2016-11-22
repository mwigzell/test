package com.test.mwigzell.cracking;

/**
 * Created by mark on 11/17/16.
 */

public class RobotInAGrid {
    int rows, cols;

    int r, c;
    boolean[][] visited;

    public int finalRow() { return r;}
    public int finalCol() { return c;}

    boolean next(int row, int col, boolean[][] blocked) {
        if(row == rows -1 && col == cols -1) {
            r = row;
            c = col;
            return true;
        }
        if (col == cols) {
            return false;
        }
        if( row == rows) {
            return false;
        }
        if (blocked[row][col]) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        return next(row, col + 1, blocked) || next(row + 1, col, blocked);
    }

    public void run(int rows, int cols, boolean[][] blocked) {
        this.rows = rows;
        this.cols = cols;
        visited = new boolean[rows][cols];
        next(0, 0, blocked);
    }
}
