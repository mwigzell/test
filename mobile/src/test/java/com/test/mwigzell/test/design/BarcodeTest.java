package com.test.mwigzell.test.design;

import com.test.mwigzell.design.Barcode;

import org.junit.Test;

/**
 * Created by mark on 3/4/18.
 */

public class BarcodeTest {
    String text = "ab#CD@EF01234";

    @Test
    public void test() {
        Barcode barcode = new Barcode();
        String seq = barcode.compute(text);
        System.out.println(seq);
    }
}
