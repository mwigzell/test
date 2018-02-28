package com.test.mwigzell.khan;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */

public class PolyAlphabeticCipher {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    Map<Character, Integer> table = new HashMap<>();
    static final int MAXLETTERS = 26;

    public class Frequency {
        Map<Character, Integer> frequency;
        int entries;
        Frequency(String sample) {
            entries = sample.length();
            frequency = new HashMap<>();
            for (int i = 0; i < entries; i++) {
                char c = Character.toLowerCase(sample.charAt(i));
                if (frequency.containsKey(c)) {
                    frequency.put(c, frequency.get(c) + 1);
                } else {
                    frequency.put(c, 1);
                }
            }
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<Character,Integer> entry : frequency.entrySet()) {
                builder.append(String.format("%c : %2d\n", entry.getKey(), entry.getValue()));
            }
            return builder.toString();
        }

        public String compare(Frequency other) {
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<Character,Integer> entry : frequency.entrySet()) {
                int std, msg;
                //std = entry.getValue() * 100/ entries;
                //msg = other.frequency.get(entry.getKey()) * 100 / other.entries;
                std = entry.getValue();
                if (other.frequency.containsKey(entry.getKey())) {
                    msg = other.frequency.get(entry.getKey());
                } else {
                    msg = 0;
                }
                builder.append(String.format("%c : %2d : %2d\n", entry.getKey(), std, msg));
            }
            return builder.toString();
        }
    }

    public PolyAlphabeticCipher() {
        for (int i = 0; i < alphabet.length(); i++) {
            table.put(alphabet.charAt(i), i + 1);
        }
    }

    public Frequency buildFrequency(String sample) {
        return new Frequency(sample);
    }

    public String buildTextDistribution(String text) {
        Frequency frequency = new Frequency(text);
        StringBuilder builder = new StringBuilder();
        for (char c : text.toCharArray()) {
            c = Character.toLowerCase(c);
            builder.append(String.format("%c : %2d\n", c, frequency.frequency.get(c)));
        }
        return builder.toString();
    }

    public String encrypt(String plain, String keyword) {
        StringBuilder builder = new StringBuilder();
        System.out.println(String.format("Encrypting %s using keyword %s", plain, keyword));
        for (int i = 0; i < plain.length(); i++) {
            int keyIndex = i % keyword.length();
            char kc = keyword.charAt(keyIndex);
            if (kc != ' ') {
                int keyShift = table.get(kc);
                char p = plain.charAt(i);
                int n = table.get(p);
                n += keyShift;
                char e = alphabet.charAt((n - 1) % MAXLETTERS);
                builder.append(e);
                System.out.println(String.format("Encrypt %c from %c using keyShift %2d, keyIndex %d", e, p, keyShift, keyIndex));
            } else {
                builder.append(plain.charAt(i));
            }
        }
        return builder.toString();
    }

    public String decrypt(String encrypted, String keyword) {
        StringBuilder builder = new StringBuilder();
        System.out.println(String.format("Decrypting %s using keyword %s", encrypted, keyword));
        for (int j = 0; j < encrypted.length(); j++) {
            char c = Character.toLowerCase(encrypted.charAt(j));
            int n = table.get(c);
            int keyIndex = j % keyword.length();
            char kc = keyword.charAt(keyIndex);
            if (kc != ' ') {
                int keyShift = table.get(kc);
                n -= keyShift;
                n += MAXLETTERS;
                char p = alphabet.charAt((n - 1) % MAXLETTERS);
                builder.append(p);
                System.out.println(String.format("Decrypt %c from %c using keyShift %2d keyIndex %d", p, c, keyShift, keyIndex));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
