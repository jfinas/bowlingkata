package de.klosebrothers.jfinas.bowlingkata.bowlinggame;

import de.klosebrothers.jfinas.bowlingkata.bowlingframe.BowlingFrame;
import de.klosebrothers.jfinas.bowlingkata.bowlingframe.InvalidFrameException;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
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
    public int getScore() { //needs to be public for the JSON-Serializer to find
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


    /**
     * Method to check if a the game is valid, meaning it has the correct number of frames and all frames are valid.
     *
     * @return itself
     * @throws InvalidGameException  when there is an incorrect number of frames
     * @throws InvalidFrameException when one of the frames is invalid
     */
    public BowlingGame selfCheck() throws InvalidGameException, InvalidFrameException {
        if (bowlingFrames.length < 12)
            throw new InvalidGameException("There are not enough frames!");
        if (bowlingFrames.length > 12)
            throw new InvalidGameException("There are too many Frames!");
        for (BowlingFrame bowlingFrame : bowlingFrames) {
            bowlingFrame.selfCheck();
        }
        return this;
    }
}
