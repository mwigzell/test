package com.test.mwigzell.design;

/**
 * From Algorithm Design : distance editing using dynamic programing
 * variant for embedded substring problem: set up rowInit so cost of starting
 * match anywhere is same. Adjust goalCell to find lowest cost in the match row.
 * Note: pass in the substring to match as "s", and the text as "t"
 */

public class SubstringMatch extends ApproxMatch {

    public SubstringMatch() {
       super();
    }


    @Override
    protected void rowInit(int i) {
        m[0][i].cost = 0;
        m[0][i].parent = UNDEFINED;
    }

    @Override
    protected Cell goalCell(String s, String t) {
        int i, j;

        i = s.length() -1;
        j = 0;
        for (int k = 1; k < t.length(); k++) {
            if (m[i][k].cost < m[i][j].cost) {
                j = k;
            }
        }
        System.out.println("GOAL CELL=m["+ i + "] [" + j + "]");
        reconstructPath(s, t, i, j);
        return m[i][j];
    }
}
