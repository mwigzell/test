package com.test.mwigzell.design;

/**
 * From Algorithm Design : distance editing using dynamic programing
 * variant for LCS problem: rig the match() so substitutions are not chosen
 */
// NOTE: THIS DOESN'T work as advertised, not sure why.

public class LongestCommonSubsequence extends ApproxMatch {

    public LongestCommonSubsequence() {
       super();
    }

    /*
    @Override
    protected void rowInit(int i) {
        m[0][i].cost = 0;
        m[0][i].parent = UNDEFINED;
    }
    */

    @Override
    protected int match(char c, char t) {
        if (c == t) {
            return 0;
        } else {
            return MAXLEN;
        }
    }

    /*
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
        reconstructPath(s, t, i, j);
        return m[i][j];
    }
    */
    @Override
    protected Cell goalCell(String s, String t) {
        int i = 7, j = 9;


        reconstructPath(s, t, i, j);
        return m[i][j];
    }
}
