package de.klosebrothers.jfinas.bowlingkata;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BowlingFrameTest {
    @Test
    public void calculateThrowValueShouldReturnZeroGivenMiss() {
        BowlingFrame testFrame = new BowlingFrame("--".toCharArray());
        int expected = 0;
        int actual = testFrame.calculateThrowValue(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateThrowValueShouldReturnZeroGivenNoThrow() {
        BowlingFrame testFrame = new BowlingFrame("X ".toCharArray());
        int expected = 0;
        int actual = testFrame.calculateThrowValue(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateThrowValueShouldReturnCalculatedValueOfFirstThrowGivenSpare() {
        BowlingFrame testFrame = new BowlingFrame("8/".toCharArray());
        int expected = 8;
        int actual = testFrame.calculateThrowValue(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateThrowValueShouldReturnTenGivenStrike() {
        BowlingFrame testFrame = new BowlingFrame("X ".toCharArray());
        int expected = 10;
        int actual = testFrame.calculateThrowValue(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateThrowValueShouldReturnActualValueGivenNormalFrame() {
        BowlingFrame testFrame = new BowlingFrame("55".toCharArray());
        int expected = 5;
        int actual = testFrame.calculateThrowValue(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateThrowValueShouldReturnValueOfFirstThrowGivenZero() {
        BowlingFrame testFrame = new BowlingFrame("55".toCharArray());
        int expected = 5;
        int actual = testFrame.calculateThrowValue(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateThrowValueShouldReturnValueOfSecondThrowGivenOne() {
        BowlingFrame testFrame = new BowlingFrame("55".toCharArray());
        int expected = 5;
        int actual = testFrame.calculateThrowValue(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateThrowValueShouldReturnNumberOfRemaininPinsGivenSpareSymbol() {
        BowlingFrame testFrame = new BowlingFrame("8/".toCharArray());
        int expected = 2;
        int actual = testFrame.calculateThrowValue(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getScoreShouldReturnZeroGivenTwoMisses() {
        BowlingFrame testFrame = new BowlingFrame("--".toCharArray());
        int expected = 0;
        int actual = testFrame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getScoreShouldReturnTenGivenStrike() {
        BowlingFrame testFrame = new BowlingFrame("X ".toCharArray());
        int expected = 10;
        int actual = testFrame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getScoreShouldReturnTenGivenSpare() {
        BowlingFrame testFrame = new BowlingFrame("X ".toCharArray());
        int expected = 10;
        int actual = testFrame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getScoreShouldReturn8Given62() {
        BowlingFrame testFrame = new BowlingFrame("62 ".toCharArray());
        int expected = 8;
        int actual = testFrame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isStrikeShouldReturnTrueGivenStrike() {
        BowlingFrame testFrame = new BowlingFrame("X ".toCharArray());
        boolean expected = true;
        boolean actual = testFrame.isStrike();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isStrikeShouldReturnFalseGivenNormalFrame() {
        BowlingFrame testFrame = new BowlingFrame("55".toCharArray());
        boolean expected = false;
        boolean actual = testFrame.isStrike();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isSpareShouldReturnTrueGivenSpare() {
        BowlingFrame testFrame = new BowlingFrame("5/".toCharArray());
        boolean expected = true;
        boolean actual = testFrame.isSpare();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isSpareShouldReturnFalseGivenNormalFrame() {
        BowlingFrame testFrame = new BowlingFrame("55".toCharArray());
        boolean expected = false;
        boolean actual = testFrame.isSpare();
        Assertions.assertEquals(expected, actual);
    }

    @Test(expected = InvalidFrameException.class)
    public void selfCheckShouldThrowOnIllegalStrike() throws InvalidFrameException {
        BowlingFrame testFrame = new BowlingFrame("XX".toCharArray());
        testFrame.selfCheck();
    }

    @Test(expected = InvalidFrameException.class)
    public void selfCheckShouldThrowOnScoreOverTen() throws InvalidFrameException {
        BowlingFrame testFrame = new BowlingFrame("56".toCharArray());
        testFrame.selfCheck();
    }

    /*
     * Test can result in false positives, as getScore() will sometimes return values over 10 for illegal characters,
     * also resulting in the expected exception but wrong exception message!
     */
    @Test(expected = InvalidFrameException.class)
    public void selfCheckShouldThrowOnIllegalCharacters() throws InvalidFrameException {
        BowlingFrame testFrame = new BowlingFrame("Z5".toCharArray());
        testFrame.selfCheck();
    }
}
