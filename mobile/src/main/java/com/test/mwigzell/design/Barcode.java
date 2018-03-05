package com.test.mwigzell.design;

import java.util.List;
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

    int [][] m; // m x i cells for the mode and character cost

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
                throw new IllegalStateException("Unknown op:" + op);
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
            if (m[r][n] < min) {
                min = m[r][n];
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
        Stack<Operation> ops = new Stack<>();

        int prevMode = UNDEFINED;
        for (int c = m[0].length-1; c > 0; c--) {
            int minIdx = minCost(c);
            char ch = s.charAt(c);
            int charMode = mode(ch);
            if (c == m[0].length - 1) {
                prevMode = charMode;
            }
            // walking back from end of matrix, push the LATCH closer to
            // the front if the mode of the minimum cost matches the mode of the character
            // or the previous LATCH mode is same as the mode of the character
            int op = UNDEFINED;
            if (minIdx == charMode) {
                op = LATCH;
                prevMode = charMode;
            } else {
                if (prevMode != minIdx) {
                    op = SHIFT;
                    if (prevMode == charMode) {
                        op = LATCH;
                    }
                }
            }
            ops.push(new Operation(op, ch, charMode));
        }

        int mode = UNDEFINED;
        while(!ops.isEmpty()) {
            Operation op = ops.pop();

            //NOTE: the output looks right, but the underlying Operation
            // instances do not contain the corresponding MATCH operation,
            // this needs to be cleaned up if its to be made useful
            String out = String.format("%s %12s: %c\n",
                    mode == op.mode ? "     " : opToString(op.op),
                    modeToString(op.mode),
                    op.ch);
            builder.append(out);
            if (op.op == LATCH ) {
                mode = op.mode;
            }
        }
        return builder.toString();
    }

    void initRC(int[][] m) {
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                if (r == 0 || c == 0) {
                    m[r][c] = UNDEFINED;
                }
            }
        }
    }

    void printM(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(String.format(" %c ", s.charAt(i)));
        }
        System.out.println("");

        for (int r = 1; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                System.out.print(String.format("%2d ", m[r][c]));
            }
            System.out.println("");
        }
    }

    int cost(int mode, char c) {
        if (mode == mode(c)) {
            return 0;
        }
        return 1;
    }

    public String compute(String s) {
        String s1 = " " + s;
        m = new int[MAX_MODE + 1][s1.length()]; // leave 0 indices for initialization
        initRC(m);

        for (int c = 1; c < s1.length(); c++) {
            for (int r = 1; r < MAX_MODE + 1; r++) {
                char ch = s1.charAt(c);
                m[r][c] = m[r][c - 1] + cost(r, ch);
            }
        }
        printM(s1);
        return reconstructPath(s1);
    }
}
