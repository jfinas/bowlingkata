package de.klosebrothers.jfinas.bowlingkata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
class BowlingFrame {
    private char[] throwList;

    BowlingFrame(char[] throwList) {
        this.throwList = throwList;
    }

    /**
     * Calculates the value of a single throw, no error handling yet.
     *
     * @param throwNumber the position of the throw in the Frame
     * @return the numeric value of the given throw
     */
    int calculateThrowValue(int throwNumber) {
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

    /**
     * Selfcheck method to ensure a frame is correct
     *
     * @return itself
     * @throws InvalidFrameException if the frame is invalid in any way
     */
    BowlingFrame selfCheck() throws InvalidFrameException {
        String allowedCharacters = "[0-9[/X-]]{2}";

        if (!throwList.toString().matches(allowedCharacters))
            throw new InvalidFrameException("There is an Illegal Character in the Frame!");
        if (throwList[0] == 'X' && throwList[1] != ' ') //invalid strike
            throw new InvalidFrameException("You cannot hit any pins after a Strike!");
        if (getScore() > 10)
            throw new InvalidFrameException("You cannot Score more than 10 pins in one Frame!");
        return this;
    }

    @JsonIgnore
    int getFirstThrowValue() {
        return calculateThrowValue(0);
    }

    /**
     * calculates and returns the score for the frame
     *
     * @return the calculated score
     */
    @JsonIgnore
    int getScore() {
        if (isStrike() || isSpare()) return 10;
        else return calculateThrowValue(0) + calculateThrowValue(1);
    }

    @JsonIgnore
    boolean isStrike() {
        return throwList[0] == 'X';
    }

    @JsonIgnore
    boolean isSpare() {
        return throwList[1] == '/';
    }
}
