package de.klosebrothers.jfinas.bowlingkata;

public class BowlingGame {
    BowlingFrame[] bowlingFrames;

    public BowlingGame(BowlingFrame[] bowlingFrames) {
        this.bowlingFrames = bowlingFrames;
    }

    /**
     * Calculates the Score of a Line of Bowling, according to the rules given in the Kata
     *
     * @return the calculated score
     */
    public int calculateScore() {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            BowlingFrame currentFrame = bowlingFrames[i];
            score += currentFrame.getScore();
            if (currentFrame.isStrike())
                score += bowlingFrames[i + 1].getScore() + bowlingFrames[i + 2].getScore();
            if (currentFrame.isSpare())
                score += bowlingFrames[i + 1].getFirstThrowValue();
        }
        return score;
    }
}
