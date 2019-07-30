package de.klosebrothers.jfinas.bowlingkata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BowlingFrame {
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
