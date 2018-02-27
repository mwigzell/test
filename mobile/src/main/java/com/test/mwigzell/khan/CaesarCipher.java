package com.test.mwigzell.khan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mark on 2/26/18.
 */

public class CaesarCipher {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    Map<Character, Integer> table = new HashMap<>();
    static final int MAXLETTERS = 26;

    public CaesarCipher() {
        for (int i = 0; i < alphabet.length(); i++) {
            table.put(alphabet.charAt(i), i);
        }
    }

    public String decrypt(String encrypted, int shift) {
        String decrypted = "";

        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < encrypted.length(); j++) {
            char c = Character.toLowerCase(encrypted.charAt(j));
            int n = table.get(c);
            n -= shift;
            builder.append(alphabet.charAt(Math.abs(n) % (MAXLETTERS-1)));
        }
        decrypted = builder.toString();

        return decrypted;
    }

    public String decrypt(String encrypted) {
        String decrypted = "";
        for (int i = 0; i < MAXLETTERS; i++) {
            System.out.println("Shift " + i + "=" + decrypt(encrypted, i));
        }
        return decrypted;
    }
}
