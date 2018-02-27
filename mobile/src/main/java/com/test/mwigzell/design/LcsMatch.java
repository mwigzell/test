package com.test.mwigzell.design;

/**
 * From Algorithm Design : distance editing using dynamic programing
 * variant for Longest Common Subsequence match : bias match so no substitutions
 * Pass the sorted text as "s", so that the longest subsequence is found in "t"
 */

public class LcsMatch extends ApproxMatch {

    public LcsMatch() {
       super();
    }

    @Override
    protected int match(char c, char t) {
        if (c == t) {
            return 0;
        } else {
            return MAXLEN;
        }
    }
}
