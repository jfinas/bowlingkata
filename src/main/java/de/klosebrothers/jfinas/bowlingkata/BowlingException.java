package de.klosebrothers.jfinas.bowlingkata;

public abstract class BowlingException extends RuntimeException {
    public BowlingException(String message) {
        super(message);
    }
}
