package com.test.mwigzell.test.khan;

import com.test.mwigzell.khan.PolyAlphabeticCipher;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 *
 */

public class PolyAlphabeticCipherTest {
    String message = "Klkbnqlcytfysryucocphgbdizzfcmjwkuchzyeswfogmmetwwossdchrzyldsbwnydednzwnefydthtddbojice" +
            "mlucdygicczhoadrzcylwadsxpilpiecskomoltejtkmqqymehpmmjxyolwpeewjckznpccpsvsxauyodhalmrioc" +
            "wpelwbcniyfxmwjcemcyrazdqlsomdbfljwnbijxpddsyoehxpceswtoxwbleecsaxcnuetzywfn";

    String newspaper="thewholegraingoodnessofbluechipdividendstockshasitslimitsutilitystocksconsumerstaplespipelinestelecomsandrealestateinvestmenttrustshavealllostgroundoverthepastmonthevenwhilehtebroadermarkethasbeenflatwiththebondmarketsignallinganexpectationofrisinginterestratesthefiveyearrallyforsteadybluechipdividendpayershasstalledshouldyoubescaredifyouownalotofthesestockseitherdirectlyorthroughmutualfundsorexchangetradedfundsdavidbaskinpresidentofbaskinfinancialserviceshasatwoprongedanswerkeepyourtopqualitydividendstocksbutbepreparedtofollowhisfirmsexampleintrimmingholdingsinstockssuchastranscanadacorpkeyeracorpandpembinapipelinecorp";

    @Test
    public void test() {
        PolyAlphabeticCipher cipher = new PolyAlphabeticCipher();
        PolyAlphabeticCipher.Frequency newspaperFrequency = cipher.buildFrequency(newspaper);
        PolyAlphabeticCipher.Frequency messageFrequency = cipher.buildFrequency(message);
        System.out.print("Frequency:\n" + newspaperFrequency.compare(messageFrequency));
        System.out.print("Distribution:\n" + cipher.buildTextDistribution(message));
        String keyword = "hack";
        System.out.println(String.format("Decrypt with keyword: " + keyword + "\n" + cipher.decrypt(message, keyword)));

    }

    @Test
    public void testEncrypt() {
        String keyword = "mark";
        String plain = "hihowareyouimfinewillyoubegoingtothebeachtodaythesunishotterintheafternoon";
        PolyAlphabeticCipher cipher = new PolyAlphabeticCipher();
        String encrypted = cipher.encrypt(plain, keyword);
        String plainBack = cipher.decrypt(encrypted, keyword);
        assertEquals(plain, plainBack);
        //PolyAlphabeticCipher.Frequency f = cipher.buildFrequency("ujzzjbjplpm");
        //PolyAlphabeticCipher.Frequency newspaperFrequency = cipher.buildFrequency(newspaper);
        //System.out.print("Frequency:\n" + newspaperFrequency.compare(f));
        System.out.print("Distribution:\n" + cipher.buildTextDistribution(encrypted));
    }
}
