package com.test.mwigzell.design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//return a String containing minimum operation sequence to
//encode s into a barcode.
// M - match
// S - shift
// L - latch
public class Barcode {
    static final int UNDEFINED = 0;
    static final int ALPHA = 1;
    static final int LOWER = 2;
    static final int PUNCTUATION = 3;
    static final int MIXED = 4;
    static final int MAX_MODE = 4;

    static final int MATCH = 1;
    static final int SHIFT = 2;
    static final int LATCH = 3;

    class Cost {
        int cost;
        public Cost(int cost) {
            this.cost = cost;
        }
    }

    Cost [][] m; // m x i cells for the mode and character cost

    /**
     * determine mode set of c
     * @param c
     * @return mode
     */
    int mode(char c) {
        if (Character.isLowerCase(c)) {
            return LOWER;
        } else if (Character.isUpperCase(c)) {
            return ALPHA;
        } else if (";<>@[]!".contains(Character.toString(c))){
            return PUNCTUATION;
        } else if (Character.isDigit(c) || "$%#+*@".contains(Character.toString(c))) {
            return MIXED;
        } else {
            throw new IllegalStateException("unknown char " + c);
        }
    }

    String opToString(int op) {
        switch(op) {
            case MATCH:
                return "MATCH";
            case SHIFT:
                return "SHIFT";
            case LATCH:
                return "LATCH";
            default:
                return "UNDEF";
        }
    }

    String modeToString(int mode) {
        switch(mode) {
            case ALPHA:
                return "ALPHA";
            case LOWER:
                return "LOWER";
            case PUNCTUATION:
                return "PUNCTUATION";
            case MIXED:
                return "MIXED";
        }
        return "UNDEFINED";
    }

    int minCost(int n) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int r = 1; r < m.length; r++) {
            if (m[r][n].cost < min) {
                min = m[r][n].cost;
                idx = r;
            }
        }
        return idx;
    }

    class Operation {
        int op;
        int mode;
        char ch;
        public Operation(int op, char ch, int mode) {
            this.op = op;
            this.ch = ch;
            this.mode = mode;
        }
    }

    String reconstructPath(String s) {
        StringBuilder builder = new StringBuilder();
        Queue<Operation> ops = new LinkedList<>();

        // TBD: since we are not really evaluating which is better, SHIFT or LATCH
        // we can't possibly find the best solution. How could the matrix be updated to
        // incrementally find the best solution, or should we regress down two pathways and
        // take the min cost of either way?
        int curMode = UNDEFINED;
        for (int c = 1; c < m[0].length; c++) {
            int minIdx = minCost(c);
            char ch = s.charAt(c);
            int charMode = mode(ch);
            int op = MATCH;
            if (curMode != minIdx) {
                // mode must switch, either LATCH or SHIFT
                if (c < m[minIdx].length -1 && (mode(s.charAt(c+1)) == minIdx)) {
                    op = LATCH;
                    curMode = minIdx;
                } else if(charMode != curMode) {
                    op = SHIFT;
                }
            }

            ops.add(new Operation(op, ch, charMode));
        }

        while(!ops.isEmpty()) {
            Operation op = ops.poll();
            String out = String.format("%s %12s: %c\n",
                    opToString(op.op),
                    modeToString(op.mode),
                    op.ch);
            builder.append(out);
        }
        return builder.toString();
    }

    void initRC() {
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                if (r == 0 || c == 0) {
                    m[r][c] = new Cost(UNDEFINED);
                }
            }
        }
    }

    void printCost(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(String.format(" %c ", s.charAt(i)));
        }
        System.out.println("");

        for (int r = 1; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                System.out.print(String.format("%2d ", m[r][c].cost));
            }
            System.out.println("");
        }
    }

    Cost cost(int prevMode, int row, int col, String s) {
        char c = s.charAt(col);
        int cost = m[prevMode][col-1].cost;
        //cost = m[row][col-1].cost; // TBD: the costing ain't right: try this one
        if (row == mode(c)) {
            return new Cost(cost + 0); // match
        } else {
            return new Cost(cost + 1); // latch or shift
        }
    }

    public String compute(String s) {
        String s1 = " " + s;
        m = new Cost[MAX_MODE + 1][s1.length()]; // leave 0 indices for initialization
        initRC();

        for (int c = 1; c < s1.length(); c++) {
            for (int r = 1; r < MAX_MODE + 1; r++) {
                int mode = c == 1 ? r : minCost(c-1);
                m[r][c] = cost(mode, r, c, s1);
            }
        }
        printCost(s1);
        System.out.println("");
        return reconstructPath(s1);
    }
}
