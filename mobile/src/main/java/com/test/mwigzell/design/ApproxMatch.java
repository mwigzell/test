package com.test.mwigzell.design;

/**
 * From Algorithm Design : distance editing using dynamic programing
 */

public class ApproxMatch {
    static final int MATCH = 0;
    static final int INSERT = 1;
    static final int DELETE = 2;
    static final int UNDEFINED = -1;

    class Cell {
        int cost;
        int parent;

        public Cell() {
            cost = 0;
            parent = UNDEFINED;
        }
    }

    static final int MAXLEN = 20;
    Cell m[][] = new Cell[MAXLEN + 1][MAXLEN + 1];

    public ApproxMatch() {
        for (int i = 0; i <= MAXLEN; i++) {
            for (int j = 0; j <= MAXLEN; j++) {
                m[i][j] = new Cell();
            }
        }
    }

    protected void rowInit(int i) {
        m[0][i].cost = i;
        if (i > 0) {
            m[0][i].parent = INSERT;
        } else {
            m[0][i].parent = UNDEFINED;
        }
    }

    protected void colInit(int i) {
        m[i][0].cost = i;
        if (i > 0) {
            m[i][0].parent = DELETE;
        } else {
            m[i][0].parent = UNDEFINED;
        }
    }

    protected Cell goalCell(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        reconstructPath(s, t, i, j);
        return m[i][j];
    }

    protected int match(char c, char t) {
        if (c == t) {
            return 0;
        } else {
            return 1;
        }
    }

    protected int indel(char c) {
        return 1;
    }

    public int stringCompare(String s, String t) {
        for (int i = 0; i < MAXLEN; i++) {
            rowInit(i);
            colInit(i);
        }

        int cost[] = new int[3]; //cost of the operations in Op
        s = " " + s;
        t = " " + t;

        for(int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                cost[MATCH] = m[i-1][j-1].cost + match(s.charAt(i), t.charAt(j));
                cost[INSERT] = m[i][j-1].cost + indel(t.charAt(j));
                cost[DELETE] = m[i-1][j].cost + indel(s.charAt(i));

                m[i][j].cost = cost[MATCH];
                m[i][j].parent = MATCH;
                for(int k = INSERT; k < DELETE; k++) {
                    if (cost[k] < m[i][j].cost) {
                        m[i][j].cost = cost[k];
                        m[i][j].parent = k;
                    }
                }
            }
        }


        dumpCost(s, t);
        dumpParent(s, t);

        return goalCell(s, t).cost;
    }

    void insertOut(String t, int j) {
        System.out.print("I");
    }

    void delOut(String s, int i) {
        System.out.print("D");
    }

    void matchOut(String s, String t, int i, int j) {
        if (s.charAt(i) == t.charAt(j)) {
            System.out.print("M");
        } else {
            System.out.print("S");
        }
    }

    void reconstructPath(String s, String t,  int i, int j) {
        switch (m[i][j].parent) {
            case UNDEFINED:
                break;
            case MATCH:
                reconstructPath(s, t, i-1, j-1);
                matchOut(s, t, i, j);
                break;
            case INSERT:
                reconstructPath(s, t, i, j-1);
                insertOut(t, j);
                break;
            case DELETE:
                reconstructPath(s, t, i-1, j);
                delOut(s, i);
                break;
        }
    }

    void print(String s) {
        System.out.print(s);
    }

    void dumpCost(String s, String t) {
        print("\n");
        print(String.format("     "));
        for (int j = 0; j < t.length(); j++) {
            print(String.format(" %c ", t.charAt(j)));
        }
        print("\n");

        print(String.format("     "));
        for (int j = 0; j < t.length(); j++) {
            print(String.format("%2d ", j));
        }
        print("\n");

        for (int i = 0; i < s.length(); i++) {
            print(String.format("%c %2d:", s.charAt(i), i));
            for (int j = 0; j < t.length(); j++) {
                print(String.format("%2d ", m[i][j].cost));
            }
            print("\n");
        }
    }

    void dumpParent(String s, String t) {
        print("\n");
        print(String.format("     "));
        for (int j = 0; j < t.length(); j++) {
            print(String.format(" %c ", t.charAt(j)));
        }
        print("\n");

        print(String.format("     "));
        for (int j = 0; j < t.length(); j++) {
            print(String.format("%2d ", j));
        }
        print("\n");

        for (int i = 0; i < s.length(); i++) {
            print(String.format("%c %2d:", s.charAt(i), i));
            for (int j = 0; j < t.length(); j++) {
                print(String.format("%2d ", m[i][j].parent));
            }
            print("\n");
        }
    }
}
