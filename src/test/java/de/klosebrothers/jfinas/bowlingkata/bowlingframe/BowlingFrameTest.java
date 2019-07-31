package de.klosebrothers.jfinas.bowlingkata.bowlingframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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
    public void calculateThrowValueShouldReturnValueOfSecondThrowGivenGivene() {
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

    @Test
    public void selfCheckShouldThrowGivenIllegalStrike() throws InvalidFrameException {
        BowlingFrame testFrame = new BowlingFrame("XX".toCharArray());
        Assertions.assertThrows(InvalidFrameException.class, testFrame::selfCheck);
    }

    //
    @Test
    public void selfCheckShouldThrowGivenScoreOverTen() throws InvalidFrameException {
        BowlingFrame testFrame = new BowlingFrame("56".toCharArray());
        Assertions.assertThrows(InvalidFrameException.class, testFrame::selfCheck);
    }

    /*
     * Test can result in false positives, as getScore() will sometimes return values over 10 for illegal characters,
     * also resulting in the expected exception but wrong exception message!
     */
    @Test
    public void selfCheckShouldThrowGivenIllegalCharacters() throws InvalidFrameException {
        BowlingFrame testFrame = new BowlingFrame("Z5".toCharArray());
        Assertions.assertThrows(InvalidFrameException.class, testFrame::selfCheck);
    }

    @Test
    public void selfCheckShouldExitSuccesfullyGivenValidFrame() throws InvalidFrameException {
        BowlingFrame testFrame = new BowlingFrame("54".toCharArray());
        testFrame.selfCheck();
    }

    @Test
    public void selfCheckShouldExitSuccesfullyGivenValidStrike() throws InvalidFrameException {
        BowlingFrame testFrame = new BowlingFrame("X ".toCharArray());
        testFrame.selfCheck();
    }

    @Test
    public void selfCheckShouldExitSuccesfullyGivenValidSpare() throws InvalidFrameException {
        BowlingFrame testFrame = new BowlingFrame("5/".toCharArray());
        testFrame.selfCheck();
    }

    @Test
    public void selfCheckShouldThrowGivenTooShortFrameList() {
        BowlingFrame testFrame = new BowlingFrame("5".toCharArray());
        Assertions.assertThrows(InvalidFrameException.class, testFrame::selfCheck);
    }

    @Test
    public void selfCheckShouldThrowGivenTooLongFrameList() {
        BowlingFrame testFrame = new BowlingFrame("533".toCharArray());
        Assertions.assertThrows(InvalidFrameException.class, testFrame::selfCheck);
    }

    @Test
    public void selfCheckShouldNotThrowGivenCorrectLengthFrameList() {
        BowlingFrame testFrame = new BowlingFrame("53".toCharArray());
        testFrame.selfCheck();
    }
//
}
