package de.klosebrothers.jfinas.bowlingkata.bowlinggame;

import de.klosebrothers.jfinas.bowlingkata.bowlingframe.BowlingFrame;
import de.klosebrothers.jfinas.bowlingkata.bowlingframe.InvalidFrameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BowlingGameTest {
    @Test
    public void calculateScoreShouldReturnZeroGivenOnliMissesShouldReturnZero() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
        };

        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 0;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreShouldReturnCorrectScoreGivenOneNormalFrame() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("52".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
        };

        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 7;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void calculateScoreShouldReturnCorrectValueGivenStrike() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("52".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 17 + 7;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreShouldReturnCorrectValueGivenSpare() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("5/ ".toCharArray()),
                new BowlingFrame("52".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 15 + 7;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreShouldReturnCorrectValueNormalFrameAtEnd() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("52".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("53".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 17 + 7 + 8;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreShouldReturnCorrectValueGivenStrikeAtEnd() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("52".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("53".toCharArray()),
                new BowlingFrame("--".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 17 + 7 + 18;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreShouldReturnCorrectValueGivenSpareAtEnd() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("52".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("5/ ".toCharArray()),
                new BowlingFrame("5 ".toCharArray()),
                new BowlingFrame("3 ".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 17 + 7 + 15;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreShouldReturnCorrectValueGivenStrikeAtEndnNormalFrameAsBonus() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("52".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("--".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("53".toCharArray()),
                new BowlingFrame("  ".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 17 + 7 + 10 + 8;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    // Tests provided by the kata
    @Test
    public void calculateScoreShouldReturnCorrectValueGivenOnlyStrikes() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
                new BowlingFrame("X ".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 10 * 30;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreShouldReturnCorrectValueGivenNormalFrames() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
                new BowlingFrame("9-".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 9 * 10;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreShouldReturnCorrectValueGivenOnlySpares() {
        BowlingFrame[] testFrames = {
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5 ".toCharArray()),
                new BowlingFrame("  ".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        int expected = 10 * 15;
        int actual = testGame.getScore();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void selfCheckShouldThrowIfFrameListIsTooShort() throws InvalidGameException {
        BowlingFrame[] testFrames = {
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5 ".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        try {
            Assertions.assertThrows(InvalidGameException.class, testGame::selfCheck);
        } catch (InvalidFrameException e) {
            ; // do nothing, because these are handled and tested elsewhere
        }

    }

    @Test
    public void selfCheckShouldThrowIfFrameListIsTooLong() throws InvalidGameException {
        BowlingFrame[] testFrames = {
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5/".toCharArray()),
                new BowlingFrame("5 ".toCharArray()),
                new BowlingFrame("5 ".toCharArray()),
                new BowlingFrame("5 ".toCharArray()),
        };
        BowlingGame testGame = new BowlingGame(testFrames);
        try {
            Assertions.assertThrows(InvalidGameException.class, testGame::selfCheck);
        } catch (InvalidFrameException e) {
            ; // do nothing, because these are handled and tested elsewhere
        }

    }
}
