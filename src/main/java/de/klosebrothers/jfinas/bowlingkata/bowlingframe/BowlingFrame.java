package de.klosebrothers.jfinas.bowlingkata.bowlingframe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
public class BowlingFrame {
    @Getter(onMethod = @__(@JsonIgnore))
    private final int LEGAL_THROWLIST_LENGTH = 2;
    private char[] throwList;

    public BowlingFrame(char[] throwList) {
        this.throwList = throwList;
    }

    /**
     * Calculates the value of a single throw, no error handling yet.
     *
     * @param throwNumber the position of the throw in the Frame
     * @return the numeric value of the given throw
     */
    public int calculateThrowValue(int throwNumber) {
        switch (throwList[throwNumber]) {
            case '-':
            case ' ':
                return 0;
            case 'X':
                return 10;
            case '/':
                return 10 - Character.getNumericValue(throwList[0]);
            default:
                return Character.getNumericValue(throwList[throwNumber]);
        }
    }

    @JsonIgnore
    private String throwListToString() {
        return Arrays.toString(throwList);
    }
    /**
     * Selfcheck method to ensure a frame is correct
     *
     * @return itself
     * @throws InvalidFrameException if the frame is invalid in any way
     */
    public BowlingFrame selfCheck() throws InvalidFrameException {
        String allowedCharacters = "[0-9[ /X-]]";

        if (throwList.length < LEGAL_THROWLIST_LENGTH)
            throw new InvalidFrameException("Not enough Throws in this Frame!: " + throwListToString());
        if (throwList.length > LEGAL_THROWLIST_LENGTH)
            throw new InvalidFrameException("Not too Many Throws in this Frame!: " + throwListToString());
        if (!Character.toString(throwList[0]).matches(allowedCharacters) || !Character.toString(throwList[1]).matches(allowedCharacters))
            throw new InvalidFrameException("There is an Illegal Character in the Frame!: " + throwListToString());
        if (throwList[0] == 'X' && throwList[1] != ' ') //invalid strike
            throw new InvalidFrameException("You cannot hit any pins after a Strike!: " + throwListToString());
        if (getScore() > 10)
            throw new InvalidFrameException("You cannot Score more than 10 pins in one Frame!: " + throwListToString());
        if (getScore() == 10 && (!isSpare() && !isStrike()))
            throw new InvalidFrameException("This actually is a spare!" + throwListToString());
        return this;
    }

    @JsonIgnore
    public int getFirstThrowValue() {
        return calculateThrowValue(0);
    }

    /**
     * calculates and returns the score for the frame
     *
     * @return the calculated score
     */
    @JsonIgnore
    public int getScore() {
        if (isStrike() || isSpare()) return 10;
        else return calculateThrowValue(0) + calculateThrowValue(1);
    }

    @JsonIgnore
    public boolean isStrike() {
        return throwList[0] == 'X';
    }

    @JsonIgnore
    public boolean isSpare() {
        return throwList[1] == '/';
    }
}
