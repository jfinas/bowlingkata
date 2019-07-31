package de.klosebrothers.jfinas.bowlingkata.bowlingframe;

import de.klosebrothers.jfinas.bowlingkata.BowlingException;

public class InvalidFrameException extends BowlingException {
    InvalidFrameException(String message) {
        super(message);
    }
}
