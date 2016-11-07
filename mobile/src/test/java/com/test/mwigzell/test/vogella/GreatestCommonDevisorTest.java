package com.test.mwigzell.test.vogella;

import com.test.mwigzell.vogella.GreatestCommonDevisor;

import org.junit.Test;

/**
 * Created by mark on 11/5/16.
 */

public class GreatestCommonDevisorTest {

    @Test
    public void test1() {
        assert (GreatestCommonDevisor.gcd(4, 16) == 4);
        assert (GreatestCommonDevisor.gcd(16, 4) == 4);
        assert (GreatestCommonDevisor.gcd(15, 60) == 15);
        assert (GreatestCommonDevisor.gcd(15, 65) == 5);
        assert (GreatestCommonDevisor.gcd(1052, 52) == 4);
    }
}
