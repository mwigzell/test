package com.test.mwigzell.test.khan;

import com.test.mwigzell.khan.CaesarCipher;

import org.junit.Test;

/**
 * Created by mark on 2/26/18.
 */

public class CaesarCipherTest {
    String encrypted1 = "gluhtlishjrvbadvyyplkaohavbyjpwolypzavvdlhrvuuleatlzzhnlzdpajoavcpnlulyljpwolyrlfdvykpzaolopkkluzftivsvmklhaoputfmhcvypalovsilpuluk";
    String encrypted2 = "vwduwljudeehghyhubwklqjlfrxogilqgsohdvhuhwxuqdqbeoxhsulqwviruydxowdqgdodupghvljqedvhgrqzklfkedqnbrxghflghrqldpvhwwlqjxsvdihkrxvhfr";
    @Test
    public void testCaesar() {
        CaesarCipher cipher = new CaesarCipher();
        System.out.println("Decrypted1: " + cipher.decrypt(encrypted1, 7));
        System.out.println("Decrypted2: " + cipher.decrypt(encrypted2, 3));
    }

    @Test
    public void testPoly() {
        CaesarCipher cipher = new CaesarCipher();
        String e = "Klkbnqlcytfysryucocphgbdizzfcmjwkuchzyeswfogmmetwwossdchrzyldsbwnydednzwnefydthtddbojice" +
                "mlucdygicczhoadrzcylwadsxpilpiecskomoltejtkmqqymehpmmjxyolwpeewjckznpccpsvsxauyodhalmrioc" +
                "wpelwbcniyfxmwjcemcyrazdqlsomdbfljwnbijxpddsyoehxpceswtoxwbleecsaxcnuetzywfn";
        System.out.println("Poly: " + cipher.decrypt(e));
    }
}
