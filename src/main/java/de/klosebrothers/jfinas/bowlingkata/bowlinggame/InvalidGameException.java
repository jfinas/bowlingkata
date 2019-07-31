package de.klosebrothers.jfinas.bowlingkata.bowlinggame;

import de.klosebrothers.jfinas.bowlingkata.BowlingException;

public class InvalidGameException extends BowlingException {
    public InvalidGameException(String message) {
        super(message);
    }
}
