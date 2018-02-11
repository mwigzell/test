package com.test.mwigzell.cracking;

import java.util.ArrayList;

/**
 * Created by mark on 11/18/16.
 */

public class Permutations {
    void helper(String s, String prefix, ArrayList<String> list) {
        if (s.length() == 0) {
            list.add(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                String c = s.substring(i, i+1);
                String rem = s.substring(0, i) + s.substring(i+1);
                helper(rem, prefix + c, list);
            }
        }
    }
    public ArrayList<String> computeNoDups(String s) {
        ArrayList<String> list = new ArrayList<>();
        helper(s, "", list);
        return list;
    }

    // A utility function to find n!
    int fact(int n) {
        return (n==1)? 1 : n*fact(n-1);
    }

    String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return new String(chars);
    }

    // An iterative function to print all permutations of s.
    public void computeNoRecursion(String s) {
        // Find length of string and factorial of length
        int n = s.length();
        int fc = fact(n);

        // Point j to the 2nd position
        int j = 1;

        // To store position of character to be fixed next.
        // m is used as in index in s[].
        int m = 0;

        // Iterate while permutation count is
        // smaller than n! which fc
        for (int perm_c = 0; perm_c < fc; )
        {
            // Store perm as current permutation
            String perm = s;

            // Fix the first position and iterate (n-1)
            // characters upto (n-1)!
            // k is number of iterations for current first
            // character.
            int k = 0;
            while (k != fc/n)
            {
                // Swap jth value till it reaches the end position
                while (j != n-1)
                {
                    // Print current permutation
                    System.out.println(perm );

                    // Swap perm[j] with next character
                    perm = swap(perm, j, j + 1);

                    // Increment count of permutations for this
                    // cycle.
                    k++;

                    // Increment permutation count
                    perm_c++;

                    // Increment 'j' to swap with next character
                    j++;
                }

                // Again point j to the 2nd position
                j = 1;
            }

            // Move to next character to be fixed in s[]
            m++;

            // If all characters have been placed at
            if (m == n)
                break;

            // Move next character to first position
            s = swap(s, 0, m);
        }
    }
}
